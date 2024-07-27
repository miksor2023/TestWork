package com.gridnine.testing;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filter.FilterContainer;

import java.util.List;

public class Main {

    public static void main(String args[]){
        FilterContainer container = new FilterContainer();
        List<Filter> filters = container.getFilters();
        List<Flight> testFlights = FlightBuilder.createFlights();

        for (Filter filter : filters){
            System.out.println(filter.getDescription());
            List<Flight> result = filter.doFilter(testFlights);
            printList(result);
        }

    }
    public static void printList( List<Flight> flights){
        for (Flight f : flights){
            System.out.println(f);
        }
    }
}
