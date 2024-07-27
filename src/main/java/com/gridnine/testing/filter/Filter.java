package com.gridnine.testing.filter;

import com.gridnine.testing.entity.Flight;

import java.util.List;

public interface Filter {
    List<Flight> doFilter(List<Flight> flights);
    String getDescription();
}
