/**
 * Created by Sean on 10/30/2015.
 */
public class driver {

    public static void main(String[] args){
        Vehicle car = new Vehicle(4, "car", "Chevy", "Cruze");

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getType());
    }
}
