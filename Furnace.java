/**
 * Furnace Description: Abstract, ElectricFurnace and GasFurnace extend this class.
 */

public abstract class Furnace
{
    protected int dateBuilt, output, status;
    protected double furnaceCap, efficiency, roomSize;

    public Furnace(int dateBuilt, double furnaceCap, double efficiency, double roomSize)
    {
        this.dateBuilt=dateBuilt;
        this.furnaceCap=furnaceCap;
        this.efficiency=efficiency;
        this.roomSize = roomSize;
    }

    /**
     * getOutput Description: Returns output amount of furnace
     */
    public int getOutput()
    { 
        return output;
    }

    /**
     * getStatus Description: Returns the status of the furnace (on/off)
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * getEff Description: Returns how efficient the furnace is
     */
    public String getEff() 
    {
        double eff = efficiency*100;
        return ""+eff+"%";
    }

    /**
     * getYear Description: Returns the year the furnace was built
     */
    public int getYear()
    {
        return dateBuilt;
    }

    /**
     * setStatus Description: Sets the status of the furnace (on/off)
     */
    public void setStatus(int status) 
    {
        this.status=status;
    }
}
