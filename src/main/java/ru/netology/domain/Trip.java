package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trip implements Comparable<Trip>{
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int time;

    @Override
    public int compareTo(Trip o) {
        return price - o.price;
    }
}
