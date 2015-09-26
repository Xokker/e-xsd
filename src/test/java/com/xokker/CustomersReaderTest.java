package com.xokker;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.*;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
public class CustomersReaderTest {

    private CustomersReader customersReader;


    @Before
    public void setUp() throws Exception {
        customersReader = new CustomersReader();
    }

    @Test
    public void testRead() throws Exception {
        Customers customers = customersReader.read(ClassLoader.getSystemClassLoader().getResourceAsStream("example.xml"));
        assertNotNull(customers);
        assertEquals(1, customers.getCustomer().size());
    }
}