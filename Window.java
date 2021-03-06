/**
 * Window Description: This is the class that's instantiated to create the window that will show on screen.
 * Default values are programmed in and those values passed to the methods/classes unless the user changes those default values.
 * If the user changes those values they are exception checked then passed to the methods.
 */

import javax.swing.*; // import what we need
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Window extends JFrame
{
    //creates objects of the JPanel, JLabel and JTextField classes, initialize all variables.
    JPanel panel=new JPanel();
    JLabel roomTemp, outsideTemp, desireTemp, furnaceType, furnaceCap, furnaceEff, roomSize, overheat, freq, time, dateBuilt;
    JTextField roomText, outsideText, desireText, furnaceText, furnaceCapText, effText, sizeText, overheatText, freqText, timeText, dateBuiltText;
    double roomTempDouble,outsideTempDouble, insideDesiredRoomTempDouble,furnaceCapDouble,furnaceEffDouble,roomSizeDouble,furnaceOverheatTempDouble,freqSecDouble;
    int lengthInt, dateBuiltInt;
    private String furnaceTypeStr;
    private TaskMaster simulationRun;

    /**
     * Window Description: Constructor, sets default settings that allow us to bring up the GUI.
     */
    public Window()
    {
        setSize(1000,300); //
        setTitle("Furnace Simulation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500,500); 
        createPanel();
        add(panel);
        setVisible(true);
    }

    /**
     * createPanel Description: Create the panel (text fields, buttons, etc) that will be added to the window.
     */
    public void createPanel()
    {
        panel.setLayout(new GridLayout(12,2)); //7 rows, 2 column grid

        JButton simulate=new JButton("Simulate"); //simulate button
        JButton exit = new JButton("Exit"); //exit button

        roomTemp = new JLabel("Room Temperature:",JLabel.LEFT);  //roomTemperature label
        outsideTemp = new JLabel("Outside Temperature:",JLabel.LEFT);   //outsideTemperature label
        desireTemp = new JLabel("Desired Temperature:",JLabel.LEFT); //DesiredTemperature label
        furnaceType = new JLabel("Type of Furnace:",JLabel.LEFT); //furnaceType label
        furnaceCap = new JLabel("Furnace Capacity:",JLabel.LEFT);  //furanceCap  label
        furnaceEff = new JLabel("Furnace Efficiency:",JLabel.LEFT);  //furnaceEff label
        roomSize= new JLabel("Size of the room:",JLabel.LEFT); //roomSize label
        overheat = new JLabel("Overheat amount:",JLabel.LEFT); //overheat label
        freq = new JLabel("Output intervals:",JLabel.LEFT);    //frequency label
        time = new JLabel("Simulation duration:",JLabel.LEFT); //simulation time label
        dateBuilt= new JLabel("Year the furnace was built:",JLabel.LEFT); //datebuilt label

        roomText= new JTextField("22.00",8);  //roomTemperature text field
        outsideText = new JTextField("10.00",8);   //outsideTemperature text field
        desireText = new JTextField("22.00",8);  //desiredTemperature text field
        furnaceText= new JTextField("Gas",8);   //furnaceType text field
        furnaceCapText = new JTextField("50000",7);  //furnaceCap text field
        effText = new JTextField("0.9",7);   //furnace efficiency text field
        sizeText= new JTextField("2000",7); //roomSize text field
        overheatText= new JTextField("2.0",7); //overheat text field
        freqText= new JTextField("5",7);    //frequency text field
        timeText= new JTextField("7200",7); //time text field
        dateBuiltText= new JTextField("XXXX",7); //dateBuilt text field

        //adds all the labels, text fields and buttons to the panel
        panel.add(roomTemp);
        panel.add(roomText);

        panel.add(outsideTemp);
        panel.add(outsideText);

        panel.add(desireTemp);
        panel.add(desireText);

        panel.add(furnaceType);
        panel.add(furnaceText);

        panel.add(furnaceCap);
        panel.add(furnaceCapText);

        panel.add(furnaceEff);
        panel.add(effText);

        panel.add(roomSize);
        panel.add(sizeText);

        panel.add(overheat);
        panel.add(overheatText);

        panel.add(freq);
        panel.add(freqText);

        panel.add(time);
        panel.add(timeText);

        panel.add(dateBuilt);
        panel.add(dateBuiltText);

        panel.add(simulate);
        panel.add(exit);

        //event listener for buttons
        simulate.addActionListener(new CalculateButtonListener()); //simulate button
        exit.addActionListener(new ExitButtonListener()); //exit button
    }

    /**
     * setFields Description: Checks given inputs from text boxes for exceptions while converting inputs into the correct format for passing into methods.
     * If exceptions occur the text fields are set to an error that the user can see and change from the window they are looking at.
     */
    public boolean setFields()
    {
        String roomTempStr = roomText.getText(); // this is the current inside temperature, get it from the text box
        boolean validate=true; //sets to false when an exception is caught
        try
        {
            roomTempDouble = Double.parseDouble(roomTempStr); // try and turn it into a double, catch an exception if it occurs.
        }
        catch(NumberFormatException ex) // catch exception
        {
            roomText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }

        String outsideTempStr = outsideText.getText(); // this is the current outside temperature, get it from the text box
        try
        {
            outsideTempDouble = Double.parseDouble(outsideTempStr);      
        }
        catch(NumberFormatException ex) // catch exception
        {
            outsideText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }

        String insideDesiredRoomTempStr = desireText.getText(); // this is the desired room temperature, get it from the text box
        try
        {
            insideDesiredRoomTempDouble  = Double.parseDouble(insideDesiredRoomTempStr);      
        }
        catch(NumberFormatException ex) // catch exception
        {
            desireText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }

        furnaceTypeStr = furnaceText.getText(); // furnace type, 'Gas' or "Electric', get it from the text box
        try
        {
            if (!((furnaceTypeStr.equalsIgnoreCase("Gas")) || (furnaceTypeStr.equalsIgnoreCase("Electric"))))
            {
                throw new IllegalArgumentException("Error! Invalid Input! Enter 'Gas' or 'Electric'"); // throw the error if the input is invalid

            }
        }
        catch(IllegalArgumentException ex) // catch the exception that is thrown if user enters invalid input
        {
            furnaceText.setText(ex.getMessage());
            validate=false;
        }

        String furnaceCapStr = furnaceCapText.getText(); // capacity of the furnace, in BTUs/hr, get it from the text box
        try
        {
            furnaceCapDouble = Double.parseDouble(furnaceCapStr);    
            if(furnaceCapDouble<=0.0) // throw the error if furnace capacity is less than or equal to 0
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");

            }
        }
        catch(NumberFormatException ex) // catch exception
        {
            furnaceCapText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        } 
        catch(IllegalArgumentException ex) // catch exception
        {
            furnaceCapText.setText(ex.getMessage());
            validate=false;
        }

        String furnaceEffStr = effText.getText(); // efficiency of the furnace 0.0 - 1.0, get it from the text box
        try
        {
            furnaceEffDouble = Double.parseDouble(furnaceEffStr);
            if ((!(furnaceEffDouble >= 0.0) && (furnaceEffDouble <= 1.0))) // throw exception because the range entered isnt between/equal to 0.0 and 1.0
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number between 0.0 and 1.0");

            }
        }
        catch(NumberFormatException ex) // catch exception
        {
            effText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }
        catch (IllegalArgumentException ex) // catch exception
        {
            effText.setText(ex.getMessage());
            validate=false;
        }

        String roomSizeStr = sizeText.getText(); // size of the room to be heated, get it from the text box
        try
        {
            roomSizeDouble = Double.parseDouble(roomSizeStr);
            if(roomSizeDouble <= 0.0) // throw exception because illegal range, must be greater or equal to 0.0
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex) // catch exception
        {
            sizeText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }
        catch(IllegalArgumentException ex) // catch exception
        {
            sizeText.setText(ex.getMessage());
            validate=false;
        }

        String furnaceOverheatTempStr = overheatText.getText(); // amount to which the furnace should overheat, get it from the text box
        try
        {
            furnaceOverheatTempDouble = Double.parseDouble(furnaceOverheatTempStr);   
            if(furnaceOverheatTempDouble <= 0.0) // throw exception because illegal range, must be greater or equal to 0.0
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex) // catch exception
        {
            overheatText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }
        catch(IllegalArgumentException ex) // catch exception
        {
            overheatText.setText(ex.getMessage());
            validate=false;
        }

        String freqSecStr=freqText.getText();
        try
        {
            freqSecDouble = Double.parseDouble(freqSecStr);  
            if(freqSecDouble <= 0.0) // throw exception because illegal range, must be greater or equal to 0.0
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex) // catch exception
        {
            //System.out.println(ex.getMessage());
            freqText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }
        catch(IllegalArgumentException ex) // catch exception
        {
            freqText.setText(ex.getMessage());
            validate=false;
        }

        String LengthStr=timeText.getText(); // get the length (how long to run), get it from the text box
        try
        {
            lengthInt = Integer.parseInt(LengthStr);    
            if(lengthInt <= 0) // throw exception because illegal range, must be greater or equal to 0
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex) // catch exception
        {
            timeText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }
        catch(IllegalArgumentException ex) // catch exception
        {
            timeText.setText(ex.getMessage());
            validate=false;
        }

        String dateBuiltStr=dateBuiltText.getText(); // date the furnace was built, get it from the text box
        try{
            dateBuiltInt = Integer.parseInt(dateBuiltStr);
            if(dateBuiltInt <= 0) // throw exception because illegal range, must be greater or equal to 0
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex) // catch exception
        {
            dateBuiltText.setText("Error! Invalid Input! Please enter a number.");
            validate=false;
        }
        catch(IllegalArgumentException ex) // catch exception
        {
            dateBuiltText.setText(ex.getMessage());
            validate=false;
        }
        return validate;
    }

    /**
     * simulationObjects Description: Creates/instantiates Room, Environment, Furnace, Thermostat, InfoMaster, TaskMaster
     */
    public void simulationObjects()
    {
        Room room = new Room(roomTempDouble, roomSizeDouble); // instantiate new room
        Environment env = new Environment(outsideTempDouble); // instantiate outside environment
        Furnace heaterF = null;

        if ((furnaceTypeStr.equalsIgnoreCase("Gas")))
        {
            heaterF = new Gas(dateBuiltInt,furnaceCapDouble, furnaceEffDouble, roomSizeDouble);
        }
        else
        {
            heaterF = new Electric (dateBuiltInt,furnaceCapDouble, furnaceEffDouble, roomSizeDouble);
        }
        Thermostat thermostat = new Thermostat(insideDesiredRoomTempDouble, lengthInt,furnaceOverheatTempDouble,freqSecDouble, heaterF, room, env);
        InfoMaster update = new InfoMaster(lengthInt, freqSecDouble, env, heaterF, room, thermostat);
        simulationRun = new TaskMaster(lengthInt, freqSecDouble, update);
    }

    /**
     * ExitButtonListener Description: Closes the program if this method is called (the exit button is clicked)
     */
    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0); //exists the program
        }
    }

    /**
     * CalculateButtonListener Description: Runs program (calculates) if method is called (the calculate button is pressed)
     */
    private class CalculateButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(setFields()==true){
                simulationObjects(); // creates all the objects to run the simulation
                simulationRun.simulationRun();
            }
        }
    }
}
