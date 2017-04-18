import coppelia.*;

import static coppelia.remoteApi.*;

/**
 * Created by miguel on 23/03/17.
 */
public class Simulator {

    /*D U V I D A S:
      - TIPO DOS HANDLES, COM ARRAYLIST N TAVA DANDO CERTO
      - CRIACAO DOS OBJETOS, OQ EU PASSO POR PARAMETRO?
      - DEU PROBLEMA PARA PEGAR O HANDLE DOS SENSORES :/
      - SERA QUE EH PROBLEMA COM O IP QUE EU COLOQUEI?
    */
    //create object handles, they are arrays that carry the handle.
    private remoteApi robot;
    private IntW sonarHandle;
    private IntW laserHandle;
    private IntW cameraHandle;
    private IntWA handles;
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
        robot = new remoteApi();
        sonarHandle = new IntW(16);
        laserHandle = new IntW(1);
        cameraHandle = new IntW(1);
        handles = new IntWA(3);
        connectionStatus = connect(ip, port);
    }


    //in this method, I'm going to set connection to the simulator,
    //get objects handles,
    //
    public boolean connect(String ip, int port){

        clientID = robot.simxStart(ip, port, true, true, 5000, 50);

        if(clientID == -1){
            return false;
        }

        ret = robot.simxGetObjects(clientID, sim_handle_all, handles, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get handles returned with error");

        ret = robot.simxGetObjectHandle(clientID, "sonarHandle", sonarHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get sonar handle returned with error");

        ret = robot.simxGetObjectHandle(clientID, "cameraHandle", cameraHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get vision handle returned with error");

        ret = robot.simxGetObjectHandle(clientID, "laserHandle", laserHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get laser handle returned with error");

        return true;
    }

    public void disconnect(){
        robot.simxFinish(clientID);
    }

    public boolean checkConnection(){
        clientID = robot.simxGetConnectionId(clientID);

        if(clientID == -1){
            return false;
        }
        return true;
    }
    //DUVIDA :neste método eu colocoo como parametros os detectedpoints e a image tbm?
    public void updateSensors(int clientID, IntWA cameraHandle, IntWA laserHandle,
                              IntWA sonarHandle){


    }
    //readSensor --> implement a different method to each sensor (readSonar, readLaser).
    public FloatWA readSonar(int clientID, IntW sonarHandle){
        FloatWA detectedPoint = new FloatWA(16);

        robot.simxReadProximitySensor(clientID, sonarHandle.getValue(), null, detectedPoint, null, null,simx_opmode_streaming);

        return detectedPoint;
    }

    public FloatWA readLaser (int clientID, IntW laserHandle){
        FloatWA detectedPoint = new FloatWA(1);

        robot.simxReadProximitySensor(clientID, laserHandle.getValue(), null, detectedPoint, null, null,simx_opmode_streaming);

        return detectedPoint;
    }


    public CharWA readCamera(int clientID, IntW cameraHandle){
        CharWA image = new CharWA (1);
        //retorna image apenas
        IntWA resolution = new IntWA(1);

        robot.simxGetVisionSensorImage(clientID, cameraHandle.getValue(), resolution, image, 0, simx_opmode_streaming);

        return image;
    }

    //robot position
    public FloatWA readPositionAbsolut(int clientID, IntW robotHandle){
        FloatWA position = new FloatWA(3);

        robot.simxGetObjectPosition(clientID, robotHandle.getValue(), -1, position, simx_opmode_streaming );

        return position;
    }

    //in relation to the robot
    public FloatWA readPositionRelativ(int clientID, int objectHandle){
        FloatWA position = new FloatWA(3);

        robot.simxGetObjectPosition(clientID, objectHandle, -1, position, simx_opmode_buffer );

        return position;
    }

}
