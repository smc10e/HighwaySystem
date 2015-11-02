import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Sean on 10/30/2015.
 */
public class driver {

    public static void main(String[] args){
        Vehicle car;
        Highway highway = new Highway();
        Random rand = new Random();
        Random rand2 = new Random();

        while(true) {
            highway.update();
            int lane = rand.nextInt(highway.getNumLanes());
            int speed = rand2.nextInt(3) + 1;

            car = new Vehicle();
            car.setSpeed(speed);
            highway.addVehicle(lane, car);
            highway.display();
        }
    }
}
