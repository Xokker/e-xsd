package com.xokker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;

import static java.util.Collections.singletonMap;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
@Controller
@RequestMapping("/")
public class CustomersController {

    private final CustomersReader customersReader;
    private final CustomersStatsCalculator customersStatsCalculator;

    @Autowired
    public CustomersController(CustomersReader customersReader, CustomersStatsCalculator customersStatsCalculator) {
        this.customersReader = customersReader;
        this.customersStatsCalculator = customersStatsCalculator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getPage() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Customers customers = customersReader.read(new ByteArrayInputStream(bytes));
                CustomersStats stats = customersStatsCalculator.calculateStats(customers);

                return new ModelAndView("result", singletonMap("stats", stats));
            } catch (Exception e) {
                e.printStackTrace();
                return error("something wrong with file");
            }
        } else {
            return error("file is empty");
        }
    }

    private ModelAndView error(String message) {
        return new ModelAndView("index", singletonMap("error", message));
    }
}
