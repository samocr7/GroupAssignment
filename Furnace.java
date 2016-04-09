
/**
 * Abstract class Furnace - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Furnace
{
    protected int dateBuilt;
    protected double furnaceCap;
    protected double efficiency;
    protected double roomSize;
    protected int output;
    protected int status;
    
    public Furnace(int dateBuilt, double furnaceCap, double efficiency, double roomSize){
    this.dateBuilt=dateBuilt;
    this.furnaceCap=furnaceCap;
    this.efficiency=efficiency;
    this.roomSize = roomSize;
    }
    
    public int getOutput(){ return output;}
    public int getStatus() { return status; }
    public String getEff() 
    {
        double eff = efficiency*100;
        return ""+eff+"%";}
    public int getYear(){ return dateBuilt;}
        
        
    public void setStatus(int status) { this.status=status;}
}
