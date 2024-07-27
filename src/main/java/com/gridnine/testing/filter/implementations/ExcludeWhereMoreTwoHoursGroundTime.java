package com.gridnine.testing.filter.implementations;

import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import com.gridnine.testing.filter.Filter;

import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.HOURS;

public class ExcludeWhereMoreTwoHoursGroundTime implements Filter {
    private String description = "List of flights, where flights with ground time more then two hours are excluded";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Flight> doFilter (List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            Long groundTimeInHours = 0L;
            List <Segment> segs = flight.getSegments();
            for (int i = 0; i < segs.size() - 1; i++) {
                groundTimeInHours += HOURS.between(segs.get(i).getArrivalDate(), segs.get(i+1).getDepartureDate());
            }
            if (groundTimeInHours <= 2L) result.add(flight);
        }
        return result;
    }

}
