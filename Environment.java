/**
 * Environment Description: Object that gets instantiated, holds temperature outside of the room
 */

public class Environment
{
    private double temp; // initialize variables
    
    public Environment(double temp)
    {
        this.temp=temp;
    }
    
    /**
     * getTemp Description: returns outside temperature
     */
    public double getTemp()
    { 
        return temp;
    }
}
