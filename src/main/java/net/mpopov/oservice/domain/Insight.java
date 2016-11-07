package net.mpopov.oservice.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "public.insight")
public class Insight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "insight_insight_id_seq")
    @SequenceGenerator(name = "insight_insight_id_seq", sequenceName = "insight_insight_id_seq")
    @Column(name = "insight_id", nullable = false)
    private Long insightId;

    @Column(name = "bill_period_begin")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @NotNull
    private Date billPeriodBegin;

    @Column(name = "bill_period_end")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @NotNull
    private Date billPeriodEnd;

    @Column(name = "estimated_cost")
    @NotNull
    @Min(0)
    private Integer estimatedCost;

    @Column(name = "projected_cost")
    @NotNull
    @Min(0)
    private Integer projectedCost;

    @Column(name = "estimated_usage")
    @NotNull
    @Min(0)
    private Integer estimatedUsage;

    @Column(name = "projected_usage")
    @NotNull
    @Min(0)
    private Integer projectedUsage;

    @Column(name = "currency")
    @Size(min = 1, max = 3)
    private String currency;

    @Column(name = "is_active_peak_energy_usage")
    private Boolean isActivePeakEnergyUsage;

    public Long getInsightId() {
        return insightId;
    }

    public void setInsightId(Long insightId) {
        this.insightId = insightId;
    }

    public Date getBillPeriodBegin() {
        return billPeriodBegin;
    }

    public void setBillPeriodBegin(Date billPeriodBegin) {
        this.billPeriodBegin = billPeriodBegin;
    }

    public Date getBillPeriodEnd() {
        return billPeriodEnd;
    }

    public void setBillPeriodEnd(Date billPeriodEnd) {
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
        return "Insight [insightId=" + insightId + ", billPeriodBegin=" + billPeriodBegin + ", billPeriodEnd=" + billPeriodEnd
                + ", estimatedCost=" + estimatedCost + ", projectedCost=" + projectedCost + ", currency=" + currency + "]";
    }

}
