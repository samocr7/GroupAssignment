/**
 * Room Description: Class that becomes object, holds the information for the room being heated
 */

public class Room
{
    private double temp; // current temperature of the room
    private double size; // size of the room

    public Room(double temp, double size)
    {
        this.temp = temp; // set variables accordingly based on whats passed in
        this.size = size;
    }

    /**
     * getTemp Description: returns current temperature of room
     */
    public double getTemp()
    { 
        return temp;
    }
    
    /**
     * getSize Description: returns size of room
     */
    public double getSize()
    {
        return size;
    }

    /**
     * setTemp Description: sets the current temperature of the room
     */
    public void setTemp(double temp)
    {
        this.temp = temp;
    }
}
