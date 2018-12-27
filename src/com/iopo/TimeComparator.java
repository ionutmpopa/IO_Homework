package com.iopo;

import java.util.Comparator;

public class TimeComparator implements Comparator<BiathlonAthlete> {

    @Override
    public int compare(BiathlonAthlete a1, BiathlonAthlete a2) {
        return a1.getSkiTimeResult().compareTo(a2.getSkiTimeResult());
    }

}
