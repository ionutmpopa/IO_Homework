package com.iopo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class ReadFromCSV {

    private BiathlonAthlete athlete;
    private BiathlonAthleteTree myBiathlonList = new BiathlonAthleteTree();

    public BiathlonAthlete getAthlete() {
        return athlete;
    }

    public void readData(String fileToBeParsed) {

        Path theFile = Paths.get(fileToBeParsed);
        System.out.println("The .csv file: " + theFile);

        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(theFile, charset)){

            //Here we make sure the header is not taken into consideration.
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {


                BiathlonAthlete result = buildPersonList(line);
                myBiathlonList.addAthlete(result);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public BiathlonAthlete buildPersonList (String expression) {

        TreeSet<BiathlonAthlete> myTempTree = new TreeSet<>(new TimeComparator());
        String[] myFirstSplit = expression.split("\r\n");

        for (String myLine : myFirstSplit) {

            String[] mySecondSplit = myLine.split(",");
            String myReplacedCharacter = mySecondSplit[3].replaceAll("[:]", ".");
            Integer myId = Integer.parseInt(mySecondSplit[0]);

            String firstRangeTime = convertMinutesToSeconds(myReplacedCharacter, mySecondSplit[4]);
            String secondRangeTime = convertMinutesToSeconds(firstRangeTime, mySecondSplit[5]);
            String finalRangeTime = convertMinutesToSeconds(secondRangeTime, mySecondSplit[6]).replaceAll("[.]", ":");

            BiathlonAthlete myAthlete = new BiathlonAthlete(myId, mySecondSplit[1], mySecondSplit[2], addLeadingZero(finalRangeTime),
                    mySecondSplit[4], mySecondSplit[5],mySecondSplit[6]);

            myTempTree.add(myAthlete);

            for (BiathlonAthlete eachAthlete : myTempTree) {
                athlete = eachAthlete;
                return athlete;
            }
        }
        return null;
    }

    private String convertMinutesToSeconds(String minutes, String expression) {

        String myInteger = minutes.replaceAll("([0-9]+)(\\.[0-9]+)", "$1");
        String myFractionalPart = minutes.replaceAll("([0-9]+)(\\.\\s*)([0-9]+)", "$3");

        Integer minutesResult = Integer.parseInt(myInteger) * 60;
        Integer secondsResult = Integer.parseInt(myFractionalPart);

        int result = minutesResult + addToSeconds(secondsResult, expression);

        if (addToSeconds(secondsResult, expression) > 59) {
            return (Integer.parseInt(myInteger) + 1) + "." + (result % 60);
        } else {
            return Integer.parseInt(myInteger) + "." + result % 60;
        }
    }

    private int addToSeconds(int seconds, String expression) {

        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            char myElement = expression.charAt(i);
            while (myElement == 'o') {
                count++;
                break;
            }
        }
        switch (count) {
            case 1:
                return seconds += 10;
            case 2:
                return seconds += 20;
            case 3:
                return seconds += 30;
            case 4:
                return seconds += 40;
            case 5:
                return seconds += 50;
            default:
                return seconds;
        }
    }

    private String addLeadingZero(String expression) {

        if (expression.matches("([0-9]+[:])([0-9]$)")) {
            String myConverted = expression.replaceAll("([0-9]+[:])([0-9]$)", "$10$2");
            return myConverted;
        } else {
            return expression;
        }
    }

    public void printAthletes() {
        myBiathlonList.listAthletes();
    }
}
