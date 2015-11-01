import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Sean on 10/30/2015.
 */
public class driver {

    public static void main(String[] args){
        Vehicle car = new Vehicle(4, "car", "Chevy", "Cruze");
        Vehicle car1 = new Vehicle();
        Vehicle car2 = new Vehicle();
        Vehicle car3 = new Vehicle();

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getType());

        Highway highway = new Highway();

/*        //check for invalid usage
        if(lane > numLanes){
            System.out.println("Max lane = " + numLanes + ". Vehicle added to max lane");
            lane = numLanes-1; //max lane is indexed at numLanes - 1
        }
        else if(lane < 0){
            System.out.println("Min lane = 1. Vehicle added to lane 1");
            lane = 0;   //lane 1 is indexed at 0
        }*/

        highway.addVehicle(0, car);
        highway.addVehicle(3, car1);
        highway.addVehicle(2, car2);
        highway.addVehicle(1, car3);

        System.out.println("Num Cars on highway: " + highway.getNumVehicles());

        highway.display();

        highway.update();

/*        while(true){
            car = new Vehicle();
            car.setSpeed(1);

            Random random = new Random();
            int n = random.nextInt(4);

            highway.addVehicle(n, car);
        }*/
    }
}
