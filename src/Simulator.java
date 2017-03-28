import java.util.ArrayList;

/**
 * Created by miguel on 23/03/17.
 */
public class Simulator {

    //create object handles, they are arrays that carry the handle.
    private ArrayList<double> SonarHandle = new ArrayList<double>();
    private ArrayList<double> LaserHandle = new ArrayList<double>();
    private String ip;
    private int port;
    private int clientID;

    public Simulator(String ip, int port){
    //here i can call connect() to start the conection to the simulator
        this.ip = ip;
        this.port = port;
    }

    //in this method, I'm going to set connection to the simulator,
    //get objects handles,
    //
    public boolean connect(){

        clientID = simxStart("127.0.0.1", 25000, true, true, 5000, 50);

        if(clientID == -1){
            return false;
        }
        return true;
    }

    public boolean disconnect(){
        simxFinish(clientID);
    }

    //checkConnection --> check if connection is ok
    //updateSensors
    //readSensor --> implement a different method to each sensor (readSonar, readLaser).
    //readPositionAbsolut --> robot position
    //readPositionRelativ --> in relation to the robot

}
