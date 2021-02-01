package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Trip;
import ru.netology.repository.TripRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TripManagerTest {
    private TripRepository repository = new TripRepository();
    private TripManager manager = new TripManager(repository);

    private Trip CIT_ALA_1st_trip = new Trip(1, 2939, "CIT", "ALA", 85);
    private Trip CIT_ALA_2nd_trip = new Trip(2, 1667, "CIT", "ALA", 55);
    private Trip CIT_ALA_3rd_trip = new Trip(3, 2667, "CIT", "ALA", 70);
    private Trip CIT_ALA_4th_trip = new Trip(4, 1548, "CIT", "ALA", 75);
    private Trip SCO_CIT_1th_trip = new Trip(5, 2534, "SCO", "CIT", 100);
    private Trip CIT_NQZ_1th_trip = new Trip(6, 1848, "CIT", "NQZ", 95);
    private Trip CIT_NQZ_2nd_trip = new Trip(7, 1902, "CIT", "NQZ", 100);
    private Trip NQZ_CIT_1st_trip = new Trip(8, 1667, "NQZ", "CIT", 90);

    @BeforeEach
    public void setUp() {
        manager.add(CIT_ALA_1st_trip);
        manager.add(CIT_ALA_2nd_trip);
        manager.add(CIT_ALA_3rd_trip);
        manager.add(CIT_ALA_4th_trip);
        manager.add(SCO_CIT_1th_trip);
        manager.add(CIT_NQZ_1th_trip);
        manager.add(CIT_NQZ_2nd_trip);
        manager.add(NQZ_CIT_1st_trip);
    }

    @Test
    public void shouldNotFindTrips() {
        Trip[] expected = new Trip[]{};
        Trip[] actual = manager.findAll("", "");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindALA_CITTrips() {
        Trip[] expected = new Trip[]{};
        Trip[] actual = manager.findAll("ALA", "CIT");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSCO_CITTrip() {
        Trip[] expected = new Trip[]{SCO_CIT_1th_trip};
        Trip[] actual = manager.findAll("SCO", "CIT");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindCIT_NQZTrip() {
        Trip[] expected = new Trip[]{CIT_NQZ_1th_trip, CIT_NQZ_2nd_trip};
        Trip[] actual = manager.findAll("CIT", "NQZ");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindCIT_ALATrips() {
        Trip[] expected = new Trip[]{CIT_ALA_4th_trip, CIT_ALA_2nd_trip, CIT_ALA_3rd_trip, CIT_ALA_1st_trip};
        Trip[] actual = manager.findAll("CIT", "ALA");

        assertArrayEquals(expected, actual);
    }
}
