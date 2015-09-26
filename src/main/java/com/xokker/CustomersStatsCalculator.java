package com.xokker;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

/**
 * @author Ernest Sadykov
 * @since 26.09.2015
 */
@Service
public class CustomersStatsCalculator {

    public CustomersStats calculateStats(Customers customers0) {
        List<Customers.Customer> customers = customers0.getCustomer();

        BigDecimal totalOverall = customers.stream()
                .map(this::customerTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        int biggestClient = customers.stream()
                .sorted((c1, c2) -> customerTotal(c2).compareTo(customerTotal(c1)))
                .findFirst().get()
                .getId().intValue();

        BigDecimal totalOfBiggestOrder = sortedOrders(customers, reverseOrder()).findFirst().get();

        BigDecimal totalOfSmallestOrder = sortedOrders(customers, naturalOrder()).findFirst().get();

        int numberOfOrders = customers.stream()
                .mapToInt(c -> c.getOrders().getOrder().size())
                .sum();

        BigDecimal avgTotalOfOrders = totalOverall.divide(BigDecimal.valueOf(numberOfOrders), 2, RoundingMode.HALF_UP);

        return new CustomersStats(totalOverall, biggestClient, totalOfBiggestOrder,
                totalOfSmallestOrder, numberOfOrders, avgTotalOfOrders);
    }

    private Stream<BigDecimal> sortedOrders(List<Customers.Customer> customers,
                                                   Comparator<BigDecimal> comparator) {
        return customers.stream()
                .flatMap(c -> c.getOrders().getOrder().stream())
                .map(this::orderTotal)
                .sorted(comparator);
    }

    private BigDecimal orderTotal(Customers.Customer.Orders.Order order) {
        return order.getPositions().getPosition().stream()
                .map(p -> p.getPrice().multiply(new BigDecimal(p.getCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal customerTotal(Customers.Customer customer) {
        return customer.getOrders().getOrder().stream()
                .flatMap(o -> o.getPositions().getPosition().stream())
                .map(p -> p.getPrice().multiply(new BigDecimal(p.getCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
