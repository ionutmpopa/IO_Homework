package com.iopo;

import java.util.Objects;

public class BiathlonAthlete {

    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    public BiathlonAthlete(int athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiathlonAthlete that = (BiathlonAthlete) o;
        return athleteNumber == that.athleteNumber &&
                Objects.equals(skiTimeResult, that.skiTimeResult) &&
                Objects.equals(firstShootingRange, that.firstShootingRange) &&
                Objects.equals(secondShootingRange, that.secondShootingRange) &&
                Objects.equals(thirdShootingRange, that.thirdShootingRange);
    }

    @Override
    public String toString() {
        return  athleteNumber +
                "," + athleteName +
                "," + countryCode +
                "," + skiTimeResult +
                "," + firstShootingRange +
                "," + secondShootingRange +
                "," + thirdShootingRange;
    }
}
