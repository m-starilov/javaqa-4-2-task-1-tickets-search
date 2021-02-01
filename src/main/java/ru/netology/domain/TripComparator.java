package ru.netology.domain;

import java.util.Comparator;

public class TripComparator implements Comparator<Trip> {
    @Override
    public int compare(Trip o1, Trip o2) {
        return o1.getTime() - o2.getTime();
    }
}
