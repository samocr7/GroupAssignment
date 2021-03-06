/**
 * TaskMaster Description: Handles the task of printing the current information about the system.
 * Includes things such as current furnace status, time, and temperature.
 */

import javax.swing.*; // get what we need
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class TaskMaster
{
    private int delay; // initalize variables/instantiate objects
    private InfoMaster info;
    private int freq, length, printTimes;
    private ArrayList<Data> arrayInfo;

    public TaskMaster(int length, double freq, InfoMaster info)
    {
        this.length = length; // set variables accordingly based on whats passed in
        this.freq = (int) freq;
        this.info = info;
    }

    /**
     * simulationRun Description: Creates timer, table, does maths, calls timer to display information
     */
    public void simulationRun()
    {
        int delta = freq*60;
        printTimes = length / delta; // maths
        delay = freq*1000;
        
        info.start(); // start er up

        for(int i = 0; i < printTimes; i++) // call the update method based on counter
        {
            info.update();
        }
        
        info.printMessage(); // print the data
        String divider = "------------";
        System.out.printf( "%-15s %20s %20s %20s %n", "Time", "Inside", "Outside", "Furnace Status");
        System.out.printf( "%-15s %20s %20s %20s %n", divider, divider, divider, divider);

        arrayInfo = info.getArray();
        
        TimerTest time = new TimerTest(); // actually create the timer and pass in the information
        time.timerStart(arrayInfo, delay, printTimes);
    } 
}

