/**
 * Thermostat Description: Controls and starts/stops the furnace to meet program requirements
 */

public class Thermostat
{
    private double tempSetting, overheatSetting, freq, Qin;
    private int length, BLC = 1, SHC = 4;
    private Furnace furnace;
    private Room room;
    private Environment env;

    public Thermostat(double tempSetting, int length, double overheatSetting, double freq, Furnace furnace, Room room, Environment env)
    {
        this.tempSetting = tempSetting; // set variables accordingly based on whats passed in
        this.length = length;
        this.overheatSetting = overheatSetting;
        this.freq = freq;
        this.furnace = furnace;
        this.room = room;
        this.env = env;
    }

    /**
     * turnFurnace Description: turn the furnace on or off depending on current state of room sensed by thermostat (what the variables are holding)
     */
    public void turnFurnace()
    {
        if(room.getTemp() < tempSetting+overheatSetting) // turn the furnace on
        {
            furnace.setStatus(1);
            Qin = (furnace.getOutput()) * (length/3600);
        }
        else // keep the furnace off
        {
            furnace.setStatus(0);
            Qin=0;
        }
        
        double Qloss = BLC * room.getSize() * (room.getTemp() - env.getTemp()) * (length/3600); // maths
        double roomTempCheck = ((Qin - Qloss) / (SHC * room.getSize()) ) + room.getTemp();
        room.setTemp(roomTempCheck);
    }

    /**
     * getTempSetting Description: returns what the temperature setting is
     */
    public double getTempSetting()
    {
        return tempSetting;
    }

    /**
     * getOverheatSetting Description: returns the amount that the furnace should overheat the room by
     */
    public double getOverheatSetting()
    {
        return overheatSetting;
    }
}

