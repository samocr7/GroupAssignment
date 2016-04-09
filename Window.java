import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window extends JFrame
{
    //creates objects of the JPanel, JLabel and JTextField classes.
    JPanel panel=new JPanel();
    JLabel roomTemp, outsideTemp, desireTemp, furnaceType, furnaceCap, furnaceEff, roomSize, overheat, freq, time, dateBuilt;
    JTextField roomText, outsideText, desireText, furnaceText, furnaceCapText, effText, sizeText, overheatText, freqText, timeText, dateBuiltText;
    double roomTempDouble,outsideTempDouble, insideDesiredRoomTempDouble,furnaceCapDouble,furnaceEffDouble,roomSizeDouble,furnaceOverheatTempDouble,freqSecDouble;
    int lengthInt;
    private String furnaceTypeStr;
    private TaskMaster simulationRun;
    public Window(){
        setSize(1000,300); //
        setTitle("Furnace Simulation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500,500); 
        createPanel();
        add(panel);
        setVisible(true);
    }

    public void createPanel(){
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
        exit.addActionListener(new ExitButtonListener());   //exit button
    }

    public void setFields(){

        String roomTempStr = roomText.getText(); // this is the current inside temperature
        try
        {
            roomTempDouble = Double.parseDouble(roomTempStr);    
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            roomText.setText("Error! Invalid Input! Please enter a number.");
        }

        String outsideTempStr = outsideText.getText(); // this is the current outside temperature
        try
        {
             outsideTempDouble = Double.parseDouble(outsideTempStr);      
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            outsideText.setText("Error! Invalid Input! Please enter a number.");
        }

        String insideDesiredRoomTempStr = desireText.getText(); // this is the desired room temperature
        try
        {
             insideDesiredRoomTempDouble  = Double.parseDouble(insideDesiredRoomTempStr);      
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            desireText.setText("Error! Invalid Input! Please enter a number.");
        }

        furnaceTypeStr = furnaceText.getText(); // furnace type, 'Gas' or "Electric'
        try
        {
            if ((furnaceTypeStr.equalsIgnoreCase("Gas")) || (furnaceTypeStr.equalsIgnoreCase("Electric")))
            {
                // do the thing if its correct here
            }
            else
            {
                // throw the error if the input is invalid
                throw new IllegalArgumentException("Error! Invalid Input! Enter 'Gas' or 'Electric'");
            }
        }
        catch(IllegalArgumentException ex) // catch the exception that is thrown if user enters invalid input
        {
            furnaceText.setText(ex.getMessage());
            //System.out.println("Error! Invalid Input! Enter 'Gas' or 'Electric'");
        }
        

        String furnaceCapStr = furnaceCapText.getText(); // capacity of the furnace, in BTUs/hr
        try
        {
             furnaceCapDouble = Double.parseDouble(furnaceCapStr);    
            if(furnaceCapDouble<=0.0){
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            furnaceCapText.setText("Error! Invalid Input! Please enter a number.");
        } 
        catch(IllegalArgumentException ex){
            furnaceCapText.setText(ex.getMessage());
        }

        String furnaceEffStr = effText.getText(); // efficiency of the furnace 0.0 - 1.0
        try
        {
             furnaceEffDouble = Double.parseDouble(furnaceEffStr);
            if ((furnaceEffDouble >= 0.0) && (furnaceEffDouble <= 1.0))
            {
                // do the thing thats the thing that this thing should do when the input is correct
            }
            else // throw the error because the range entered isnt correct
            {
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number between 0.0 and 1.0");
            }
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            effText.setText("Error! Invalid Input! Please enter a number.");
        }
        catch (IllegalArgumentException ex)//when the efficiency is not between 0 and 1
        {
            effText.setText(ex.getMessage());
        }

        String roomSizeStr = sizeText.getText(); // size of the room to be heated
        try
        {
            roomSizeDouble = Double.parseDouble(roomSizeStr);
            if(roomSizeDouble<=0.0){
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            sizeText.setText(("Error! Invalid Input! Please enter a number."));
        }
        catch(IllegalArgumentException ex){
            sizeText.setText(ex.getMessage());
        }

        String furnaceOverheatTempStr=overheatText.getText();
        try
        {
             furnaceOverheatTempDouble = Double.parseDouble(furnaceOverheatTempStr);   
            if(furnaceOverheatTempDouble<=0.0){
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            overheatText.setText(("Error! Invalid Input! Please enter a number."));
        }
        catch(IllegalArgumentException ex){
            overheatText.setText(ex.getMessage());
        }

        String freqSecStr=freqText.getText();
        try
        {
             freqSecDouble = Double.parseDouble(freqSecStr);  
            if(freqSecDouble <=0.0){
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            freqText.setText(("Error! Invalid Input! Please enter a number."));
        }
        catch(IllegalArgumentException ex){
            freqText.setText(ex.getMessage());

        }

        String LengthStr=timeText.getText();

        try
        {
            lengthInt = Integer.parseInt(LengthStr);    
            if(lengthInt<=0){
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than 0.");
            }
        }
        catch(NumberFormatException ex)
        {
            //System.out.println(ex.getMessage());
            timeText.setText(("Error! Invalid Input! Please enter a number."));
        }
        catch(IllegalArgumentException ex){
            timeText.setText(ex.getMessage());
        }

        String dateBuiltStr=dateBuiltText.getText();

        try{
            int year = Integer.parseInt(dateBuiltStr);
            if(year<=0){
                throw new IllegalArgumentException("Error! Invalid Input! Please enter a number greater than .");
            }
        }
        catch(NumberFormatException ex){
        dateBuiltText.setText(("Error! Invalid Input! Please enter a number."));
        }
        catch(IllegalArgumentException ex){
        dateBuiltText.setText(ex.getMessage());
        }
    }
    public void simulationObjects(){
        int dateBuiltInt = Integer.parseInt(dateBuiltText.getText());
      
        Room room = new Room(roomTempDouble, roomSizeDouble);
        Environment env = new Environment(outsideTempDouble);
        Furnace heaterF = null;
         
        if ((furnaceTypeStr.equalsIgnoreCase("Gas")))
        {
            heaterF = new GasFurnace(dateBuiltInt,furnaceCapDouble, furnaceEffDouble, roomSizeDouble);
        }
        else
        {
            heaterF = new ElectricFurnace (dateBuiltInt,furnaceCapDouble, furnaceEffDouble, roomSizeDouble);
        }
        Thermostat thermostat = new Thermostat(insideDesiredRoomTempDouble, lengthInt,furnaceOverheatTempDouble,freqSecDouble, heaterF, room, env);
        InfoMaster update = new InfoMaster(lengthInt, freqSecDouble, env, heaterF, room, thermostat);
        simulationRun = new TaskMaster(lengthInt, freqSecDouble, update);
    }
    /**
     * Private inner class for EventListeners, each implementing the ActionListener
     */

    private class ExitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0); //exists the program
        }
    }
    private class CalculateButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setFields(); //parses all the info from the text fields and puts them in appropriate data types. (doubles/ints)
            simulationObjects(); // creates all the objects to run the simulation
            simulationRun.simulationRun();
        }
    }
}
