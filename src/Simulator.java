import java.util.ArrayList;
import coppelia.remoteApi;

/**
 * Created by miguel on 23/03/17.
 */
public class Simulator {

    //create object handles, they are arrays that carry the handle.
    private ArrayList<int> sonarHandle = new ArrayList<int>();
    private ArrayList<int> laserHandle = new ArrayList<int>();
    private ArrayList<int> cameraHandle = new ArrayList<int>();
    private ArrayList<int> handles = new ArrayList<int>();
    private String ip;
    private int port;
    private int clientID;
    private boolean connectionStatus;
    private int ret;

    //DUVIDA: eu coloco um objeto remoteApi como parametro no construtor?
    public Simulator(String ip, int port){
    //here i can call connect() to start the conection to the simulator
        this.ip = ip;
        this.port = port;
        connectionStatus = connect(ip, port);
    }

    //in this method, I'm going to set connection to the simulator,
    //get objects handles,
    //
    public boolean connect(String ip, int port){

        clientID = simxStart(ip, port, true, true, 5000, 50);

        if(clientID == -1){
            return false;
        }

        ret = simxGetObjects(clientID, "sim_handle_all", handles, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get vision handle returned with error");

        ret = simxGetObjectHandle(clientID, "sonarHanle", sonarHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get vision handle returned with error");

        ret = simxGetObjectHandle(clientID, "cameraHanle", cameraHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get vision handle returned with error");

        ret = simxGetObjectHandle(clientID, "laserHanle", laserHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get vision handle returned with error");

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

    public void updateSensors(){
        //nao sei qual funcao que chama aq
    }
    //readSensor --> implement a different method to each sensor (readSonar, readLaser).
    public ArrayList<int> readSonar(ArrayList<int> sonarHandle){
        return sonarHandle.getValue();
    }

    public ArrayList<int> readLaser (ArrayList<int> laserHandle){
        return laserHandle.getValue();
    }

    public ArrayList<int> readCamera(ArrayList<int> cameraHandle){
        return cameraHandle.getValue();
    }

    //robot position
    public float readPositionAbsolut(int clientID, int robotHandle){
        float position;

        simxGetObjectPosition(clientID, robotHandle, -1, position, simx_opmode_streaming );

        return position;
    }

    //in relation to the robot
    public float readPositionRelativ(int clientID, int objectHandle){
        float position;

        simxGetObjectPosition(clientID, objectHandle, -1, position, simx_opmode_buffer );

        return position;
    }

}
