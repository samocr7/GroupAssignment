/**
 * Data Description: Takes all the required information into a Data object, which is then passed into the Information class
 * to store into the array
 */

public class Data
{
    private int time, furnaceStat; // initialize variables
    private double temp, outTemp;

    public Data(int time, double temp, double outTemp, int furnaceStat) 
    {
        this.time = time; // set variables accordingly based on information passed in
        this.temp = temp;
        this.outTemp = outTemp;
        this.furnaceStat = furnaceStat;
    }
    
    public int getTime()
    {
        return time;
    }

    public double getInsideTemp(){
        return temp;
    }

    public double getOutsideTemp(){
        return outTemp;
    }

    public int getFurnaceStatus(){
        return furnaceStat;
    }
}
