public class Thermostat
{
    private int tempSetting=22;
    private int length=7200;
    private int overheatSetting=2;
    private int freq=5;
    private final int TIME=60;
    private int furnaceStatus=0;

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

    public void setTempSetting(int tempSetting){
        //sets the temperature setting to the one passed in
        this.tempSetting=tempSetting;
    }

    public void setOverheatSetting(int overheatSetting){
        //sets the overheat setting to the one passed in
        this.overheatSetting=overheatSetting;
    }
    
    public void setLength(int length){
    //sets the length setting to the one passed in
    this.length=length;
    }
    
    public void setFreq(int freq){
    //sets the frequency to the one passed in
    this.freq=freq;
    }
}

