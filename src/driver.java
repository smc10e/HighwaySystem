import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Sean on 10/30/2015.
 */
public class driver {

    static Frame frame = new Frame();
    static Panel panel = new Panel();
    static TextArea textArea = new TextArea();
    static WindowListener window = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);  // Terminate the program
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Vehicle car;
        Highway highway = new Highway();
        Random rand = new Random();
        Random rand2 = new Random();

        panel.add(textArea);
        frame.add(panel);
        frame.setSize(500,300);
        frame.setTitle("Highway");
        frame.setVisible(true);
        frame.addWindowListener(window);

        while(true) {
            highway.update();
            int lane = rand.nextInt(highway.getNumLanes());
            int speed = rand2.nextInt(3) + 1;

            car = new Vehicle();
            car.setSpeed(speed);
            highway.addVehicle(lane, car);
            display(highway);
            Thread.sleep(300);
        }
    }

    public static void display(Highway highway){
        textArea.setText("");
        List<Vehicle> vehicles;
        Vehicle vehicle;
        textArea.append("---------------------------------------------------------------------------------\n");
        for(int i =0; i < highway.getNumLanes(); i++){
            int lane = i + 1;
            textArea.append("L" + lane + ": ");
            vehicles = highway.getLanes().get(i);
            for(int j = 0; j < vehicles.size(); j++){
                vehicle = vehicles.get(j);
                if(vehicle != null) {
                    if (vehicle.getType() == "Car") {
                        textArea.append("C" + vehicle.getSpeed() + " ");
                    }
                }
                else{
                    textArea.append("   ");
                }
            }
            textArea.append("\n---------------------------------------------------------------------------------\n");
        }
        textArea.append("\n");
    }
}

