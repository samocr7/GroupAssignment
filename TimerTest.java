/**
 * TimerTest Description: This class handles the timer, effectively printing out the furnace status and other information
 * to the screen and the file.
 */

import javax.swing.*; // import what we need
import java.awt.event.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class TimerTest
{
    private Timer timer1; // initialize and create variables
    private int printCount; // to count the number of times it prints
    private int index = 0; // everything needs to start somewhere
    ArrayList<Data> arrayInfo;
    
    /**
     * timerStart Description: Starts the timer with pre-defined delay that is passed in as a parameter.
     */
    public void timerStart(ArrayList<Data> arrayInfo, int delay, int printCount)
    {
        this.arrayInfo = arrayInfo; // set variables/array accordingly with whats been passed in
        this.printCount = printCount;
        
        timer1 = new Timer(delay, new TimerTestListener()); // instantiate a new timer and start the timer
        timer1.start();
    }

    /**
     * TimerTestListener Description: Carries out whats supposed to happen when timer starts. Prints information to screen/file.
     */
    private class TimerTestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            DecimalFormat twoDec = new DecimalFormat("#.##"); // convert to appropriate format
            if (index != printCount) // to control the number of times the action is performed
            {
                System.out.printf( "%-15s %20s %20s %20s %n", arrayInfo.get(index).getTime(), twoDec.format(arrayInfo.get(index).getInsideTemp()), arrayInfo.get(index).getOutsideTemp(), arrayInfo.get(index).getFurnaceStatus());
                index++;
            }
            else
            {
                timer1.stop();  // stoping the timer if the condition is met
            }
        }
    }
}
