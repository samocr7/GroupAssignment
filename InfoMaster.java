import java.util.*;
public class InfoMaster
{
    private int length;
    private int freq;
    private Environment env;
    private Furnace furnace;
    private Room room;
    private Thermostat therm;
    private double temp, outTemp;
    private int time, furnaceStat;
    private ArrayList<Data> info = new ArrayList<Data>();
    
    public InfoMaster(int length, double freq, Environment env, Furnace furnace, Room room, Thermostat therm)
    {
        this.length = length;
        this.freq = (int)freq;
        this.env = env;
        this.furnace=furnace;
        this.room=room;
        this.therm=therm;
    }

    public void start()
    {
        temp = room.getTemp();
        time = 0;
        outTemp = env.getTemp();
        furnaceStat = furnace.getStatus();
        
        Data data = new Data(time, temp, outTemp, furnaceStat);
        info.add(data);
    }
    
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
    
    public void printMessage()
    {
        System.out.println("Gas Furnace capacity = "+furnace.getOutput()+"\t"+"Efficiency = " + furnace.getEff() +"\t" + "Pilot on = true"+"heating = false");
        System.out.println("Room: Year Built:"+furnace.getYear()+"\t"+"Temperature = "+room.getTemp()+"\t"+"Area (Sq ft) = "+room.getSize()+"\t"+"SHC = 4.0"+"\t"+"BLC = 1.0");
        System.out.println("Environment:   Temperature:"+env.getTemp());
        System.out.println("Thermostat:    Setting = "+therm.getTempSetting()+"\tOverheat = "+therm.getOverheatSetting());
        System.out.println("Starting simulation:    Display frequency(seconds) = "+freq + "\tRuntime(seconds): "+length);
    }
    
    public ArrayList getArray() { return info;}
}
