package com.iopo;

public class BiathlonStanding {

    public static void main(String[] args) {

        ReadFromCSV readMyData = new ReadFromCSV();
        readMyData.readData("resources/Athletes.csv");
        readMyData.printAthletes();

    }
}
