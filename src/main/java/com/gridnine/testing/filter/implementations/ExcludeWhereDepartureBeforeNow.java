package com.gridnine.testing.filter.implementations;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.filter.Filter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExcludeWhereDepartureBeforeNow implements Filter {
    private String description = "List of flights, where flights with departure time before then now are excluded";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Flight> doFilter (List<Flight> flights) {
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            boolean departureAfterNow = true;
            for (Segment seg : flight.getSegments()) {
                if (seg.getDepartureDate().isBefore(LocalDateTime.now())) departureAfterNow = false;
            }
            if (departureAfterNow) result.add(flight);
        }
        return result;
    }
}
