package com.gridnine.testing.filter.implementations;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.filter.Filter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExcludeWhereArrivalBeforeDeparture implements Filter {
    private String description = "List of flights, where flights with arrival time before then departure time are excluded";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            boolean arrivalAfterDeparture = true;
            for (Segment seg : flight.getSegments()) {
                if (seg.getArrivalDate().isBefore(seg.getDepartureDate())) arrivalAfterDeparture = false;

            }
            if (arrivalAfterDeparture) result.add(flight);
        }
        return result;
    }
}
