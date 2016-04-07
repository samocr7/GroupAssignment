public class Thermostat
{
    private double tempSetting;
    private int length;
    private double overheatSetting;
    private double freq;
    private int furnaceStatus;

    public Thermostat(double tempSetting, int length, double overheatSetting, double freq, int furnaceStatus){
        this.tempSetting=tempSetting;
        this.length=length;
        this.overheatSetting=overheatSetting;
        this.freq=freq;
        this.furnaceStatus=furnaceStatus;

    }
    
    public void turnFurnace(double temp)
    {
        if(temp < tempSetting)
            furnaceStatus=1;
            else
            furnaceStatus=0;
    }
}

