/**
 * Takes all the required information into a Data object, which is then passed into the Information class
 * to store into the array
 */
public class Data
{
    int time;
    double insideTemp;
    double outsideTemp;
    String furnaceStatus;
    public Data(int time, double insideTemp, double outsideTemp, String furnaceStatus){
        this.time=time;
        this.insideTemp=insideTemp;
        this.outsideTemp=outsideTemp;
        this.furnaceStatus=furnaceStatus;
    }

    public int getTime(){
        return time;
    }

    public double getInsideTemp(){
        return insideTemp;
    }
    
    public double getOutsideTemp(){
        return outsideTemp;
    }
    
    public String getFurnaceStatus(){
        return furnaceStatus;
    }
}
