/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class TaskMaster
{
    private int delay;
    private InfoMaster info;
    private int freq, length, printTimes;
    private ArrayList<Data> arrayInfo;

    public TaskMaster(int length, double freq, InfoMaster info)
    {
        this.length = length;
        this.freq =(int)freq;
        this.info = info;
    }

    public void simulationRun()
    {
        printTimes = length / freq;
        info.start();

        for(int i=0; i<printTimes; i++)
            info.update();

        delay = freq*1000;
        info.printMessage();
        String divider = "------------";
        System.out.printf( "%-15s %20s %20s %20s %n", "Time", "Inside", "Outside", "Furnace Status");
        System.out.printf( "%-15s %20s %20s %20s %n", divider, divider, divider, divider);
        
        arrayInfo = info.getArray();
        TimerTest time = new TimerTest();
        time.timerStart(arrayInfo, delay, printTimes);
    }
}

