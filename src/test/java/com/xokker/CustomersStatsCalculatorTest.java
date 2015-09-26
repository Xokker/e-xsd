package com.xokker;

import org.junit.Before;
import org.junit.Test;

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
    }
}