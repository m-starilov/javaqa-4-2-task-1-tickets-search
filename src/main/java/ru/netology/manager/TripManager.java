package ru.netology.manager;

import ru.netology.domain.Trip;
import ru.netology.repository.TripRepository;

public class TripManager {
    private TripRepository repository;

    public TripManager(TripRepository repository) {
        this.repository = repository;
    }

    public void add(Trip trip){
        repository.save(trip);
    }

    public Trip[] findAll(String from, String to){
        Trip[] trips = repository.findAll();
        Trip[] result = new Trip[0];
        for (Trip trip : trips){
            if (trip.getDeparture().equals(from) && trip.getArrival().equals(to)){
                int length = result.length + 1;
                Trip[] tmp = new Trip[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = trip;
                result = tmp;
            }
        }
        return result;
    }

    public void deleteById(Trip trip){
        repository.removeById(trip.getId());
    }

    public Trip findById(Trip trip){
        return repository.findById(trip.getId());
    }
}
