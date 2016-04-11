/**
 * InfoMaster Description: Controls data, writes information to screen and to file.
 */

import java.util.*; // import what we need
import java.io.*;

public class InfoMaster
{
    private int length, freq, time, furnaceStat;
    private Environment env;
    private Furnace furnace;
    private Room room;
    private Thermostat therm;
    private double temp, outTemp;
    private ArrayList<Data> info = new ArrayList<Data>();

    public InfoMaster(int length, double freq, Environment env, Furnace furnace, Room room, Thermostat therm)
    {
        this.length = length; // set variables accordingly based on whats passed in
        this.freq = (int)freq;
        this.env = env;
        this.furnace=furnace;
        this.room=room;
        this.therm=therm;
    }

    /**
     * start Description: Gets current temperatures, furnace status, instantiates adds the data object and its information to an array list
     */
    public void start()
    {
        temp = room.getTemp();
        time = 0;
        outTemp = env.getTemp();
        furnaceStat = furnace.getStatus();

        Data data = new Data(time, temp, outTemp, furnaceStat);
        info.add(data);
    }

    /**
     * update Description: Turns furnace, gets current temperatures, furnace status, instantiates adds the data object and its information to an array list
     */
    public void update()
    {
        therm.turnFurnace();

        temp = room.getTemp();
        time += freq;
        outTemp = env.getTemp();
        furnaceStat = furnace.getStatus();

        Data data = new Data(time, temp, outTemp, furnaceStat);
        info.add(data);
    }

    /**
     * printMessage Description: Prints information to screen and to the file
     */
    public void printMessage()
    {
        String str1 = "Gas Furnace capacity = "+furnace.getOutput()+"\t"+"Efficiency = " + furnace.getEff() +"\t" + "Pilot on = true"+"heating = false";
        String str2 = "Room: Year Built:"+furnace.getYear()+"\t"+"Temperature = "+room.getTemp()+"\t"+"Area (Sq ft) = "+room.getSize()+"\t"+"SHC = 4.0"+"\t"+"BLC = 1.0";
        String str3 = "Environment:   Temperature:"+env.getTemp();
        String str4 = "Thermostat:    Setting = "+therm.getTempSetting()+"\tOverheat = "+therm.getOverheatSetting();
        String str5 = "Starting simulation:    Display frequency(seconds) = "+freq + "\tRuntime(seconds): "+length;

        try
        {
            FileWriter fw = new FileWriter("output.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            System.out.println(str1);
            pw.println(str1);

            System.out.println(str2);
            pw.println(str2);

            System.out.println(str3);
            pw.println(str3);

            System.out.println(str4);
            pw.println(str4);

            System.out.println(str5);
            pw.println(str5);
            
            pw.close();
        }
        catch (IOException ex)
        {
            System.out.println("IOException Error!");
        }
    }

    /**
     * getArray Description: Returns array
     */
    public ArrayList getArray()
    {
        return info;
    }
}
