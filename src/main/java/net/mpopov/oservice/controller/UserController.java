package net.mpopov.oservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.mpopov.oservice.common.ConfigUtil;
import net.mpopov.oservice.common.ParamEncoderUtil;
import net.mpopov.oservice.controller.editor.AthorityEditor;
import net.mpopov.oservice.domain.Athority;
import net.mpopov.oservice.domain.User;
import net.mpopov.oservice.service.AthorityService;
import net.mpopov.oservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/user")
public class UserController
{
    private static String tableId = "userList";

    @Autowired
    private UserService userService;

    @Autowired
    private AthorityService athorityService;

    @Autowired
    private ConfigUtil configUtil;

    @RequestMapping("list")
    public ModelAndView list(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", configUtil.getRecordsPerAdminPage());

        int pageIndex = ParamEncoderUtil.getPageIndex(request, tableId);
        String sortColumn = ParamEncoderUtil.getSortColumn(request, tableId,
                "userId");
        String sortOrder = ParamEncoderUtil.getSortOrder(request, tableId);

        map.put("userList", userService.list(pageIndex,
                configUtil.getRecordsPerAdminPage(), sortColumn, sortOrder));

        map.put("listSize", userService.count());

        return new ModelAndView("user-list", map);
    }

    @RequestMapping("add")
    public ModelAndView add()
    {
        ModelAndView mv = new ModelAndView("user-form");
        mv.getModelMap().put("user", new User());

        List<Athority> athorities = athorityService.list();
        mv.getModelMap().put("athorities", athorities);

        return mv;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(@Valid User user, BindingResult result,
            RedirectAttributes redirectAttrs)
    {
        if (result.hasErrors())
        {
            ModelAndView mv = new ModelAndView("user-form");
            mv.getModelMap().put("user", user);

            List<Athority> athorities = athorityService.list();
            mv.getModelMap().put("athorities", athorities);
            return mv;
        }

        if (user.getUserId() == null)
        {
            userService.add(user);
        }
        else
        {
            userService.save(user);
        }

        String message = "message.save.succefull";
        redirectAttrs.addFlashAttribute("successMessage", message);

        ModelAndView mv = new ModelAndView("redirect:list");
        return mv;
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView editForm(@RequestParam("userId") Long userId)
    {
        ModelAndView mv = new ModelAndView("user-form");
        User user = userService.load(userId);
        mv.getModelMap().put("user", user);

        List<Athority> athorities = athorityService.list();
        mv.getModelMap().put("athorities", athorities);

        mv.getModelMap().put("athorityRole",
                user.getAthority().getAthorityRole());

        return mv;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam("userId") Long userId,
            RedirectAttributes redirectAttrs)
    {
        if (userService.canRemove(userId))
        {
            userService.remove(userId);
            String message = "message.delete.succefull";
            redirectAttrs.addFlashAttribute("successMessage", message);
        }
        else
        {
            String message = "message.delete.depencyPresence";
            redirectAttrs.addFlashAttribute("errorMessage", message);
        }

        return "redirect:list";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Athority.class, new AthorityEditor(
                athorityService));
    }
}
