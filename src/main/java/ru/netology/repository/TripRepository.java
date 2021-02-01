package ru.netology.repository;

import ru.netology.domain.Trip;

public class TripRepository {
    private Trip[] trips = new Trip[0];

    public void save(Trip trip) {
        int length = trips.length + 1;
        Trip[] tmp = new Trip[length];
        System.arraycopy(trips, 0, tmp, 0, trips.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = trip;
        trips = tmp;
    }

    public Trip[] findAll() {
        return trips;
    }

    public Trip findById(int id) {
        for (Trip trip : trips) {
            if (trip.getId() == id) {
                return trip;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = trips.length - 1;
        Trip[] tmp = new Trip[length];
        int index = 0;
        for (Trip trip : trips) {
            if (trip.getId() != id) {
                tmp[index] = trip;
                index++;
            }
        }
        trips = tmp;
    }
}
