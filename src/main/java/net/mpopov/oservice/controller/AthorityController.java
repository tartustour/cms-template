package net.mpopov.oservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.mpopov.oservice.common.ConfigUtil;
import net.mpopov.oservice.common.ParamEncoderUtil;
import net.mpopov.oservice.domain.Athority;
import net.mpopov.oservice.domain.AthorityEnum;
import net.mpopov.oservice.service.AthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/athority")
public class AthorityController
{

    private static String tableId = "athorityList";

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
                "athorityId");
        String sortOrder = ParamEncoderUtil.getSortOrder(request, tableId);

        map.put("athorityList", athorityService.list(pageIndex,
                configUtil.getRecordsPerAdminPage(), sortColumn, sortOrder));

        map.put("listSize", athorityService.count());

        return new ModelAndView("athority-list", map);
    }

    @RequestMapping("add")
    public ModelAndView add()
    {
        ModelAndView mv = new ModelAndView("athority-form");
        mv.getModelMap().put("athority", new Athority());

        mv.getModelMap().put("athorities", AthorityEnum.values());
        return mv;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid Athority athority, BindingResult result,
            RedirectAttributes redirectAttrs)
    {

        if (result.hasErrors())
        {
            return "athority-form";
        }

        if (athority.getAthorityId() == null)
        {
            athorityService.add(athority);
        }
        else
        {
            athorityService.save(athority);
        }

        String message = "message.save.succefull";
        redirectAttrs.addFlashAttribute("successMessage", message);

        return "redirect:list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView editForm(@RequestParam("athorityId") Long athorityId)
    {
        ModelAndView mv = new ModelAndView("athority-form");
        Athority athority = athorityService.load(athorityId);
        mv.getModelMap().put("athority", athority);

        mv.getModelMap().put("athorities", AthorityEnum.values());
        return mv;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam("athorityId") Long athorityId,
            RedirectAttributes redirectAttrs)
    {
        if (athorityService.canRemove(athorityId))
        {
            athorityService.remove(athorityId);
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
}
