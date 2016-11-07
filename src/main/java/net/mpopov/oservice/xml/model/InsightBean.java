package net.mpopov.oservice.xml.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;

@XmlRootElement(name = "insight")
@XmlType(propOrder = { "billPeriodBegin", "billPeriodEnd", "estimatedCost", "projectedCost", "estimatedUsage", "projectedUsage",
        "currency", "isActivePeakEnergyUsage" })
public class InsightBean {
    private DateTime billPeriodBegin;

    private DateTime billPeriodEnd;

    private Integer estimatedCost;

    private Integer projectedCost;

    private Integer estimatedUsage;

    private Integer projectedUsage;

    private String currency;

    private Boolean isActivePeakEnergyUsage;

    public DateTime getBillPeriodBegin() {
        return billPeriodBegin;
    }

    public void setBillPeriodBegin(DateTime billPeriodBegin) {
        this.billPeriodBegin = billPeriodBegin;
    }

    public DateTime getBillPeriodEnd() {
        return billPeriodEnd;
    }

    public void setBillPeriodEnd(DateTime billPeriodEnd) {
        this.billPeriodEnd = billPeriodEnd;
    }

    public Integer getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Integer estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public Integer getProjectedCost() {
        return projectedCost;
    }

    public void setProjectedCost(Integer projectedCost) {
        this.projectedCost = projectedCost;
    }

    public Integer getEstimatedUsage() {
        return estimatedUsage;
    }

    public void setEstimatedUsage(Integer estimatedUsage) {
        this.estimatedUsage = estimatedUsage;
    }

    public Integer getProjectedUsage() {
        return projectedUsage;
    }

    public void setProjectedUsage(Integer projectedUsage) {
        this.projectedUsage = projectedUsage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getIsActivePeakEnergyUsage() {
        return isActivePeakEnergyUsage;
    }

    public void setIsActivePeakEnergyUsage(Boolean isActivePeakEnergyUsage) {
        this.isActivePeakEnergyUsage = isActivePeakEnergyUsage;
    }

    @Override
    public String toString() {
        return "InsightBean [billPeriodBegin=" + billPeriodBegin + ", billPeriodEnd=" + billPeriodEnd + ", estimatedCost="
                + estimatedCost + ", projectedCost=" + projectedCost + ", currency=" + currency + "]";
    }

}
