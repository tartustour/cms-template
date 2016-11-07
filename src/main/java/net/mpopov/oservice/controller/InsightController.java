package net.mpopov.oservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.mpopov.oservice.domain.Insight;
import net.mpopov.oservice.service.InsightService;
import net.mpopov.oservice.common.ConfigUtil;
import net.mpopov.oservice.common.ParamEncoderUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/insight")
public class InsightController
{

    private static String tableId = "insightList";

    @Autowired
    private InsightService insightService;

    @Autowired
    private ConfigUtil configUtil;

    @RequestMapping("list")
    public ModelAndView list(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", configUtil.getRecordsPerAdminPage());

        int pageIndex = ParamEncoderUtil.getPageIndex(request, tableId);
        String sortColumn = ParamEncoderUtil.getSortColumn(request, tableId,
                "insightId");
        String sortOrder = ParamEncoderUtil.getSortOrder(request, tableId);

        map.put("insightList", insightService.list(pageIndex,
                configUtil.getRecordsPerAdminPage(), sortColumn, sortOrder));

        map.put("listSize", insightService.count());

        return new ModelAndView("insight-list", map);
    }

    @RequestMapping("add")
    public ModelAndView add()
    {
        ModelAndView mv = new ModelAndView("insight-form");
        mv.getModelMap().put("insight", new Insight());
        return mv;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid Insight insight, BindingResult result,
            RedirectAttributes redirectAttrs)
    {

        if (result.hasErrors())
        {
            return "insight-form";
        }

        if (insight.getInsightId() == null)
        {
            insightService.add(insight);
        }
        else
        {
            insightService.save(insight);
        }

        String message = "message.save.succefull";
        redirectAttrs.addFlashAttribute("successMessage", message);

        return "redirect:list";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView editForm(@RequestParam("insightId") Long insightId)
    {
        ModelAndView mav = new ModelAndView("insight-form");
        Insight insight = insightService.load(insightId);
        mav.getModelMap().put("insight", insight);
        return mav;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(@RequestParam("insightId") Long insightId,
            RedirectAttributes redirectAttrs)
    {
        if (insightService.canRemove(insightId))
        {
            insightService.remove(insightId);
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
