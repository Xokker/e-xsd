package com.xokker;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
public class CustomersStats {

    private final BigDecimal totalOverall;
    private final int biggestClient;
    private final BigDecimal totalOfBiggestOrder;
    private final BigDecimal totalOfSmallestOrder;
    private final int numberOfOrders;
    private final BigDecimal avgTotalOfOrders;

    public CustomersStats(BigDecimal avgTotalOfOrders, int numberOfOrders, BigDecimal totalOfSmallestOrder,
                          BigDecimal totalOfBiggestOrder, int biggestClient, BigDecimal totalOverall) {
        this.avgTotalOfOrders = avgTotalOfOrders;
        this.numberOfOrders = numberOfOrders;
        this.totalOfSmallestOrder = totalOfSmallestOrder;
        this.totalOfBiggestOrder = totalOfBiggestOrder;
        this.biggestClient = biggestClient;
        this.totalOverall = totalOverall;
    }

    public BigDecimal getTotalOverall() {
        return totalOverall;
    }

    public int getBiggestClient() {
        return biggestClient;
    }

    public BigDecimal getTotalOfBiggestOrder() {
        return totalOfBiggestOrder;
    }

    public BigDecimal getTotalOfSmallestOrder() {
        return totalOfSmallestOrder;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public BigDecimal getAvgTotalOfOrders() {
        return avgTotalOfOrders;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("totalOverall", totalOverall)
                .append("biggestClient", biggestClient)
                .append("totalOfBiggestOrder", totalOfBiggestOrder)
                .append("totalOfSmallestOrder", totalOfSmallestOrder)
                .append("numberOfOrders", numberOfOrders)
                .append("avgTotalOfOrders", avgTotalOfOrders)
                .toString();
    }
}
