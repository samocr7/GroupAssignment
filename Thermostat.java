/**
 * Thermostat Description: Controls and starts/stops the furnace to meet program requirements
 */

public class Thermostat
{
    private double tempSetting, overheatSetting, freq;
    private int length; 
    private final int BLC = 1, SHC = 4;
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
     * helper method for determining if the room requires heating
     */
    private boolean roomIsTooCold() {
        return room.getTemp( )< tempSetting;
    }

    /**
     * helper method for determining if the room doesn't need heating
     */
    private boolean roomIsTooHot() {
        return room.getTemp() > (tempSetting+overheatSetting);
    }

    /**
     * turnFurnace Description: turn the furnace on or off depending on current state of room sensed by thermostat (what the variables are holding)
     */
    public void turnFurnace()
    {
        double Qin=0;
        int overheat = furnace.getStatus();
        switch(overheat)
        {
            case 0:if(roomIsTooCold()){
                furnace.setStatus(1); //turns furnace on
                Qin = furnace.getOutput()*((freq*60)/3600); //math for furnace input when turned on
            }
            else if((room.getTemp()>=tempSetting)&&(room.getTemp()<(tempSetting+overheatSetting))){
                Qin = 0;
                furnace.setStatus(0);
            }
            break;
            case 1: if(roomIsTooHot()){
                furnace.setStatus(0);//turns furnace off
                Qin=0; //furnace input is 0 when it is off
            }
            else if((room.getTemp()>=tempSetting)&&(room.getTemp()<(tempSetting+overheatSetting))){ //when the temperature is greater than the desired temperature, and proceeds to overheat
                Qin = furnace.getOutput()*((freq*60)/3600); //math for furnace input when turned on
            }
            else if(roomIsTooCold()){
                furnace.setStatus(1);//turns furnace on
                Qin = furnace.getOutput()*((freq*60)/3600);//math for furnace input when turned on
            }
            break;
        }

        double Qloss = BLC * room.getSize() * (room.getTemp() - env.getTemp()) * ((freq*60)/3600);//math for the heating that is lost 
        double roomTempCheck = ((Qin - Qloss) / (SHC * room.getSize()) ) + room.getTemp(); //math for the new temperature of the room
        room.setTemp(roomTempCheck); //sets the temperature of the room to the calculated temperature
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

