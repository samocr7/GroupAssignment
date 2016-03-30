public class ElectricFurnace extends Furnace
{
    private final double EFFICIENCY=92/100;
    public ElectricFurnace(){
        super();
    }

    public void setFurnaceCap(int furnaceCap){
        //sets the furnaceCap to the one passed in
        this.furnaceCap=furnaceCap;
    }
}
