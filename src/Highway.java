import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by smcampbell on 10/30/2015.
 */
public class Highway {

    private int numLanes;
    private int maxVehicles;
    private int numVehicles = 0;
    private HashMap<Integer, List<Vehicle>> lanes = new HashMap<>();

    public Highway(){
        numLanes = 4;
        maxVehicles = 20;

        for(int i = 0; i < numLanes; i++){
            lanes.put(i, new LinkedList<>());
        }
    }

    public Highway(int numLanes, int maxVehicles){
        this.numLanes = numLanes;
        this.maxVehicles = maxVehicles;

        for(int i = 0; i < numLanes; i++){
            this.lanes.put(i, new LinkedList<>());
        }
    }

    public void addVehicle(int lane, Vehicle vehicle){
        //creates a list object to reference lists within the hash map
        List<Vehicle> vehicles;
        vehicles = lanes.get(lane);
        vehicles.add(vehicle);
        lanes.put(lane, vehicles);
        numVehicles++;
    }

    public void removeVehicle(int lane, Vehicle vehicle){
        List<Vehicle> vehicles;
        vehicles = lanes.get(lane);
        vehicles.remove(vehicle);
        lanes.put(lane, vehicles);
        numVehicles--;
    }

    public void display(){
        List<Vehicle> vehicles;
        Vehicle vehicle;
        for(int i =0; i < numLanes; i++){
            vehicles = lanes.get(i);
            for(int j = 0; j < vehicles.size(); j++){
                vehicle = vehicles.get(j);
                System.out.print(vehicle.getId() + " ");
            }
            System.out.println();
        }
    }

    public void setLanes(HashMap<Integer, List<Vehicle>> lanes) {
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

    public HashMap<Integer, List<Vehicle>> getLanes() {
        return lanes;
    }

}
