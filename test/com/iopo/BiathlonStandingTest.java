package com.iopo;


import org.junit.*;
import static junit.framework.Assert.assertEquals;


public class BiathlonStandingTest {

    private ReadFromCSV myAthlete;

    @Before
    public void setup() {
        System.out.println("Testing ...");
        myAthlete = new ReadFromCSV();
    }

    @Test
    public void testWhenAddAthleteCalculateFinalTime() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE1).getSkiTimeResult();
        assertEquals("28:51", myAthlete.getAthlete().getSkiTimeResult());
    }

    @Test
    public void testWhenAddAthleteCalculateFinalTimeTwo() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE2).getSkiTimeResult();
        assertEquals("31:19", myAthlete.getAthlete().getSkiTimeResult());
    }

    @Test
    public void testWhenAddAthleteCalculateFinalTimeThree() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE3).getSkiTimeResult();
        assertEquals("33:07", myAthlete.getAthlete().getSkiTimeResult());
    }

    @Test
    public void testWhenAddAthleteCalculateFinalTimeFour() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE4).getSkiTimeResult();
        assertEquals("34:03", myAthlete.getAthlete().getSkiTimeResult());
    }

    @Test
    public void testWhenAddAthleteCalculateFinalTimeFive() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE5).getSkiTimeResult();
        assertEquals("33:51", myAthlete.getAthlete().getSkiTimeResult());
    }

    @Test
    public void testWhenAddAthleteCalculateFinalTimeSix() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE6).getSkiTimeResult();
        assertEquals("37:26", myAthlete.getAthlete().getSkiTimeResult());
    }

    @Test
    public void testParsingAndCalculating() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE6).toString();
        assertEquals("7,George Michael,UK,37:26,ooooo,ooooo,ooooo", myAthlete.getAthlete().toString());
    }

    @Test
    public void testParsingAndCalculatingTwo() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE5).toString();
        assertEquals("6,Straw Man,IR,33:51,xxoox,xxoox,xoxxx", myAthlete.getAthlete().toString());
    }

    @Test
    public void testParsingAndCalculatingThree() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE4).toString();
        assertEquals("3,Anthony Hopkins,UK,34:03,xxoox,xxoox,ooxxx", myAthlete.getAthlete().toString());
    }

    @Test
    public void testParsingAndCalculatingFour() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE3).toString();
        assertEquals("5,Tim Riviera,USA,33:07,xxxxx,xxoox,ooxxx", myAthlete.getAthlete().toString());
    }

    @Test
    public void testParsingAndCalculatingFive() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE2).toString();
        assertEquals("4,Bruce Princeton,UK,31:19,xxxxx,ooooo,oooxx", myAthlete.getAthlete().toString());
    }

    @Test
    public void testParsingAndCalculatingSix() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE1).toString();
        assertEquals("2,Jimmy Spilberg,UK,28:51,xxxxx,xxoox,ooxxx", myAthlete.getAthlete().toString());
    }

    @Test
    public void testParsingAndCalculatingSeven() {
        myAthlete.addAthleteAndGetFinalTime(AthleteForTest.ATHLETE7).toString();
        assertEquals("8,George Micha,US,35:09,ooooo,oxxxx,xxxxx", myAthlete.getAthlete().toString());
    }
}
