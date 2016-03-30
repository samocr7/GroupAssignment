public class GasFurnace extends Furnace
{
    private final double EFFICIENCY=92/100;
    public GasFurnace(){
        super();
    }

    public void setFurnaceCap(int furnaceCap){
        //sets the furnaceCap to the one passed in
        this.furnaceCap=furnaceCap;
    }
}
