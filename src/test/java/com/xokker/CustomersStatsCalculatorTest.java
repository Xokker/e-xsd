package com.xokker;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
public class CustomersStatsCalculatorTest {

    private Customers customers;

    @Before
    public void setUp() throws Exception {
        CustomersReader customersReader = new CustomersReader();
        customers = customersReader.read(ClassLoader.getSystemClassLoader().getResourceAsStream("example.xml"));

    }

    @Test
    public void testCalculateStats() throws Exception {
        CustomersStats stats = CustomersStatsCalculator.calculateStats(customers);
        assertNotNull(stats);
        assertEquals(233658, stats.getBiggestClient());
        assertEquals(BigDecimal.valueOf(357.), stats.getTotalOverall());
        assertEquals(2, stats.getNumberOfOrders());
        assertEquals(BigDecimal.valueOf(150.), stats.getTotalOfSmallestOrder());
        assertEquals(BigDecimal.valueOf(207.), stats.getTotalOfBiggestOrder());
        assertEquals(BigDecimal.valueOf(17850, 2), stats.getAvgTotalOfOrders());
    }
}