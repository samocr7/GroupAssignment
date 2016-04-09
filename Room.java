public class Room
{
    private double temp;
    private double size;//feet
    public Room(double temp, double size){
        this.temp=temp;
        this.size=size;
    
    }
    
    public double getTemp() { return temp; }
    public double getSize() { return size; }
    
    public void setTemp(double temp) { this.temp = temp; }
}
