package net.mpopov.oservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mpopov.oservice.domain.Insight;
import net.mpopov.oservice.service.InsightService;
import net.mpopov.oservice.xml.model.InsightBean;

@Controller
@RequestMapping("/v1")
public class JsonController {
    @Autowired
    private InsightService insightService;

    @RequestMapping(value = "/insight", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody InsightBean getInsight(HttpServletRequest request) {

        Insight insight = insightService.last();

        InsightBean insightBean = new InsightBean();
        if (insight != null) {
            insightBean.setBillPeriodBegin(new DateTime(insight.getBillPeriodBegin()).withZone(DateTimeZone.UTC));
            insightBean.setBillPeriodEnd(new DateTime(insight.getBillPeriodEnd()).withZone(DateTimeZone.UTC));
            insightBean.setEstimatedCost(insight.getEstimatedCost());
            insightBean.setProjectedCost(insight.getProjectedCost());
            insightBean.setEstimatedUsage(insight.getEstimatedUsage());
            insightBean.setProjectedUsage(insight.getProjectedUsage());
            insightBean.setCurrency(insight.getCurrency());
            insightBean.setIsActivePeakEnergyUsage(insight.getIsActivePeakEnergyUsage());
        }
        return insightBean;
    }
}
