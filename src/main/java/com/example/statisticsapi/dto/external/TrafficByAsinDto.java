package com.example.statisticsapi.dto.external;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TrafficByAsinDto {
    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;
    private BigDecimal browserSessionPercentage;
    private BigDecimal browserSessionPercentageB2B;
    private BigDecimal mobileAppSessionPercentage;
    private BigDecimal mobileAppSessionPercentageB2B;
    private BigDecimal sessionPercentage;
    private BigDecimal sessionPercentageB2B;
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;
    private BigDecimal browserPageViewsPercentage;
    private BigDecimal browserPageViewsPercentageB2B;
    private BigDecimal mobileAppPageViewsPercentage;
    private BigDecimal mobileAppPageViewsPercentageB2B;
    private BigDecimal pageViewsPercentage;
    private BigDecimal pageViewsPercentageB2B;
    private BigDecimal buyBoxPercentage;
    private BigDecimal buyBoxPercentageB2B;
    private BigDecimal unitSessionPercentage;
    private BigDecimal unitSessionPercentageB2B;
}
