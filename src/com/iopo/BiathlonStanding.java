package com.iopo;

import java.io.File;

public class BiathlonStanding {

    private static final String MY_FILE = "resources" + File.separator + "Athletes.csv";

    public static void main(String[] args) {

        ReadFromCSV readMyData = new ReadFromCSV();
        readMyData.readData(MY_FILE);
        readMyData.printAthletes();

    }
}
