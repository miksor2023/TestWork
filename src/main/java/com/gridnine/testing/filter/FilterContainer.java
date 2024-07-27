package com.gridnine.testing.filter;

import com.gridnine.testing.filter.implementations.ExcludeWhereArrivalBeforeDeparture;
import com.gridnine.testing.filter.implementations.ExcludeWhereDepartureBeforeNow;
import com.gridnine.testing.filter.implementations.ExcludeWhereMoreTwoHoursGroundTime;

import java.util.List;

public class FilterContainer{
    private final List<Filter> filters;
    public FilterContainer(){
        this.filters = List.of(
                new ExcludeWhereDepartureBeforeNow(),
                new ExcludeWhereArrivalBeforeDeparture(),
                new ExcludeWhereMoreTwoHoursGroundTime());
    }
    public List<Filter> getFilters(){
        return filters;
    }
}
