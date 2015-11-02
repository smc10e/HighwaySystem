import java.util.*;

/**
 * Created by smcampbell on 10/30/2015.
 */
public class Highway {

    private int numLanes;
    private int maxVehicles;
    private int numVehicles = 0;
    private int laneLength;
    private HashMap<Integer, Vector<Vehicle>> lanes = new HashMap<>();

    public Highway(){
        numLanes = 4;
        maxVehicles = 20;
        laneLength = 25;

        //Vector<Vehicle> v;
        for(int i = 0; i < numLanes; i++){
            Vector<Vehicle> vehicles = new Vector<>();
            for(int j = 0; j < laneLength; j++){
                vehicles.add(j, null);
                // lanes.put(i, new Vector<>(laneLength));
            }
            lanes.put(i, vehicles);
        }

        //v.setSize(25);
    }

    public Highway(int numLanes, int maxVehicles){
        this.numLanes = numLanes;
        this.maxVehicles = maxVehicles;

        for(int i = 0; i < numLanes; i++){
            this.lanes.put(i, new Vector<>());
        }
    }

    public void addVehicle(int lane, Vehicle vehicle){
        //creates a list object to reference lists within the hash map
        Vector<Vehicle> vehicles;
        vehicles = lanes.get(lane);
        vehicles.set(0, vehicle);
        lanes.put(lane, vehicles);
        numVehicles++;
    }

    public void removeVehicle(int lane, Vehicle vehicle){
        Vector<Vehicle> vehicles;
        vehicles = lanes.get(lane);
        vehicles.remove(vehicle);
        lanes.put(lane, vehicles);
        numVehicles--;
    }

    public void display(){
        List<Vehicle> vehicles;
        Vehicle vehicle;
        System.out.println("---------------------------------------------------------------------------------");
        for(int i =0; i < numLanes; i++){
            System.out.print("L" + i + ": ");
            vehicles = lanes.get(i);
            for(int j = 0; j < vehicles.size(); j++){
                vehicle = vehicles.get(j);
                if(vehicle != null) {
                    if (vehicle.getType() == "Car") {
                        System.out.print("C" + vehicle.getSpeed() + " ");
                    }
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------");
        }
        System.out.println();
    }

    public void update(){
        for(int l = 0; l < numLanes; l++) {
            Vector<Vehicle> vehicles = lanes.get(l);
            Vehicle vehicle;
            for (int i = vehicles.size() - 1; i >= 0; i--) {
                vehicle = vehicles.get(i);
                if (vehicle != null) {
                    int newSpot = i + vehicle.getSpeed();
                    if (newSpot < laneLength) {
                        for(int j = i+1; j <= newSpot; j++){
                            if(vehicles.elementAt(j) != null){
                                newSpot = j-1;
                                vehicle.setSpeed(vehicles.elementAt(j).getSpeed());
                                break;
                            }
                        }
                        vehicles.set(newSpot, vehicle);
                    }
                    vehicles.set(i, null);
                }
            }
            lanes.put(l, vehicles);
        }
    }

    public void setLanes(HashMap<Integer, Vector<Vehicle>> lanes) {
        this.lanes = lanes;
    }

    public void setMaxVehicles(int maxVehicles) {
        this.maxVehicles = maxVehicles;
    }

    public void setNumLanes(int numLanes) {
        this.numLanes = numLanes;
    }

    public void setNumVehicles(int numVehicles) {
        this.numVehicles = numVehicles;
    }

    public int getMaxVehicles() {
        return maxVehicles;
    }

    public int getNumLanes() {
        return numLanes;
    }

    public int getNumVehicles() {
        return numVehicles;
    }

    public HashMap<Integer, Vector<Vehicle>> getLanes() {
        return lanes;
    }

}
