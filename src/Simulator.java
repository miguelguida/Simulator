import java.util.ArrayList;
import coppelia.remoteApi;

/**
 * Created by miguel on 23/03/17.
 */
public class Simulator {

    //create object handles, they are arrays that carry the handle.
    private ArrayList<int> SonarHandle = new ArrayList<int>();
    private ArrayList<int> LaserHandle = new ArrayList<int>();
    private ArrayList<int> CameraHandle = new ArrayList<int>();
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

    public void disconnect(){
        simxFinish(clientID);
    }

    public boolean checkConnection(int clientID){
        clientID = simxGetConnectionId(simxInt clientID);

        if(clientID == -1){
            return false;
        }
        return true;
    }
    //updateSensors
    //readSensor --> implement a different method to each sensor (readSonar, readLaser).
    //readPositionAbsolut --> robot position
    //readPositionRelativ --> in relation to the robot

}
