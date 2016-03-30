import java.util.*;
/**
 * Takes in Data objects and stores them into an array, also prints out all the contents in the array.
 */
public class Information
{
    ArrayList<Data> info=new ArrayList<Data>();
    Data data;
    public void addData(Data data){
        info.add(data);
    }

    public void printInfo(){
        System.out.println("Time\t"+"Inside\t"+"Outside\t"+"Furnace Status");
        System.out.println("______\t"+"______\t"+"______\t"+"______");
        for(int i=0; i<info.size(); i++){
            System.out.println(info.get(i).getTime()+"\t"+info.get(i).getInsideTemp()+"\t"+info.get(i).getOutsideTemp()+"\t"+info.get(i).getFurnaceStatus());
        }
        
    }
}
