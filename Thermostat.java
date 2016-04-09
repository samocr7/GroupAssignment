public class Thermostat
{
    private double tempSetting;
    private int length;
    private double overheatSetting;
    private double freq;
    private double Qin;
    private Furnace furnace;
    private Room room;
    private Environment env;
    private final int BLC = 1;
    private final int SHC = 4;

    public Thermostat(double tempSetting, int length, double overheatSetting, double freq, Furnace furnace, Room room, Environment env){
        this.tempSetting=tempSetting;
        this.length=length;
        this.overheatSetting=overheatSetting;
        this.freq=freq;
        this.furnace=furnace;
        this.room = room;
        this.env = env;
    }

    public void turnFurnace()
    {

        if(room.getTemp() < tempSetting+overheatSetting){
            furnace.setStatus(1);
            Qin = (furnace.getOutput()) * (length/3600);
        }

        else{
            furnace.setStatus(0);
            Qin=0;
            
        }
        double Qloss = BLC * room.getSize() * (room.getTemp() - env.getTemp()) * (length/3600);

        double roomTempCheck = ((Qin - Qloss) / (SHC * room.getSize()) ) + room.getTemp();
        room.setTemp(roomTempCheck);

    }

    public double getTempSetting(){
        return tempSetting;
    }

    public double getOverheatSetting(){
        return overheatSetting;
    }
}

