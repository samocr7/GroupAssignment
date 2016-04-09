import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class TimerTest
{

    private Timer timer1;
    private int printCount; // to count the number of times it prints
    private int index=0;
    ArrayList<Data> arrayInfo;
    public void timerStart(ArrayList<Data> arrayInfo, int delay, int printCount)
    {
        this.arrayInfo = arrayInfo;
        this.printCount = printCount;
        timer1 = new Timer(delay, new TimerTestListener()); 
        
            timer1.start();
           
          }

    private class TimerTestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            DecimalFormat twoDec = new DecimalFormat("#.##");
            if (index!=printCount) // to control the number of times the action is performed
            {
                System.out.printf( "%-15s %20s %20s %20s %n", arrayInfo.get(index).getTime(), twoDec.format(arrayInfo.get(index).getInsideTemp()), arrayInfo.get(index).getOutsideTemp(), arrayInfo.get(index).getFurnaceStatus());
                index++;
            }
            else timer1.stop();  // stoping the timer if the condition is met
        }
    }
}
