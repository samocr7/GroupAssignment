public class ElectricFurnace extends Furnace
{
    //private double efficiency;
    //private double furnaceCap;
    private int output = furnaceOutput();
    public ElectricFurnace(int dateBuilt, double furnaceCap, double efficiency, double roomSize){
        super(dateBuilt,furnaceCap, efficiency, roomSize);
        
    }
    
     public int furnaceOutput()
    {
        if (dateBuilt < 1980){
            if (roomSize < 1300)
                output = 50000;
                else if ((roomSize >= 1300) && (roomSize < 1700))
                output = 55000;
                else if ((roomSize >= 1700) && (roomSize < 2500))
                output = 65000;
                else if ((roomSize >= 2500) && (roomSize < 3500))
                output = 80000;
                else if ((roomSize >= 3500) && (roomSize < 4500))
                output = 100000;
        }
        
        else {
            if (roomSize < 1300)
                output = 40000;
                else if ((roomSize >= 1300) && (roomSize < 1700))
                output = 45000;
                else if ((roomSize >= 1700) && (roomSize < 2500))
                output = 50000;
                else if ((roomSize >= 2500) && (roomSize < 3500))
                output = 60000;
                else if ((roomSize >= 3500) && (roomSize < 4500))
                output = 70000;
            }
            return output;
    }
    
    public int getOutput() { return output; }
}
