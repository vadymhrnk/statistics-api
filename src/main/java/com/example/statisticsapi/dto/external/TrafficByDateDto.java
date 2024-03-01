package com.example.statisticsapi.dto.external;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TrafficByDateDto {
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;
    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;
    private BigDecimal buyBoxPercentage;
    private BigDecimal buyBoxPercentageB2B;
    private BigDecimal orderItemSessionPercentage;
    private BigDecimal orderItemSessionPercentageB2B;
    private BigDecimal unitSessionPercentage;
    private BigDecimal unitSessionPercentageB2B;
    private BigDecimal averageOfferCount;
    private BigDecimal averageParentItems;
    private int feedbackReceived;
    private int negativeFeedbackReceived;
    private BigDecimal receivedNegativeFeedbackRate;
}
