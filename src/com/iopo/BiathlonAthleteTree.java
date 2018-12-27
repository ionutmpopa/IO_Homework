package com.iopo;

import java.util.TreeSet;

public class BiathlonAthleteTree {

    private TreeSet<BiathlonAthlete> biathlonAthlete;

    public BiathlonAthleteTree() {
        this.biathlonAthlete = new TreeSet<>(new TimeComparator());
    }

    public Boolean addAthlete(BiathlonAthlete athlete) {

        try {
            checkDuplicateContent(athlete);
            biathlonAthlete.add(athlete);
            return true;

        } catch (DuplicateException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void listAthletes() {
        for (BiathlonAthlete eachAthlete : biathlonAthlete) {
            System.out.println(eachAthlete.getAthleteName() + " " + eachAthlete.getSkiTimeResult());
        }
    }

    private void checkDuplicateContent(BiathlonAthlete biathlonAth) {
        if (biathlonAthlete.contains(biathlonAth)) {
            throw new DuplicateException(biathlonAth.getAthleteName() + " has already been added to the list!");
        }
    }

    public TreeSet<BiathlonAthlete> getBiathlonAthlete() {
        return biathlonAthlete;
    }
}

