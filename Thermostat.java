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

    public void turnFurnace(){
        if (furnaceStatus==0){
            //turn furnace on
            furnaceStatus=1;
        }
        else{
            //turns furnace off
            furnaceStatus=0;
        }
    }

}

