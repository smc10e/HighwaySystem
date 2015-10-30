/**
 * Created by Sean on 10/30/2015.
 */
public class Vehicle {

    private int numDoors;
    private String type;
    private String make;
    private String model;
    private int speed;


    public Vehicle(){
        numDoors = 4;
        type = "Sedan";
        make = "Honda";
        model = "Civic";
        speed = 0;
    }

    public Vehicle(int numDoors, String type, String make, String model){
        this.numDoors = numDoors;
        this.type = type;
        this.make = make;
        this.model = model;
    }

    public int getNumDoors(){
        return numDoors;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}