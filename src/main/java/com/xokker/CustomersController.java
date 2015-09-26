package com.xokker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
@Controller
@RequestMapping("/")
public class CustomersController {

    private final CustomersStatsCalculator customersStatsCalculator;

    @Autowired
    public CustomersController(CustomersStatsCalculator customersStatsCalculator) {
        this.customersStatsCalculator = customersStatsCalculator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "index";
    }
}
