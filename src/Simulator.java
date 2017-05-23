import coppelia.*;



import static coppelia.remoteApi.*;

/**
 * Created by miguel on 23/03/17.
 */
public class Simulator {

    // DUVIDA:os termos finais tem dois tipos, os de inicializacao e os de buffer. Qual eu uso?

    //create object handles, they are arrays that carry the handle.
    private remoteApi robotClient;
    private IntW sonarHandle;
    private IntW laserHandle;
    private IntW cameraHandle;
    private IntWA handles;
    private String ip;
    private int port;
    private int clientID;
    private boolean connectionStatus;
    private int ret;


    public Simulator(String ip, int port){
    //here i can call connect() to start the conection to the simulator
        this.ip = ip;
        this.port = port;
        robotClient = new remoteApi();
        sonarHandle = new IntW (16);
        laserHandle = new IntW (1);
        cameraHandle = new IntW (1);
        handles = new IntWA(3);
        connectionStatus = connect(ip, port);
    }


    //in this method, I'm going to set connection to the simulator,
    //get objects handles,
    //
    public boolean connect(String ip, int port){

        clientID = robotClient.simxStart(ip, port, true, true, 5000, 50);

        if(clientID == -1){
            return false;
        }
        for(int i = 0; i < 3; i++) {
            ret = robotClient.simxGetObjects(clientID, sim_handle_all, handles, simx_opmode_oneshot_wait);
            if (ret == remoteApi.simx_return_ok)
                System.out.println("Got Handle");
            else
                System.out.format("Error: get handles returned with error");
        }
        for(int i = 0; i < 16; i++) {
            ret = robotClient.simxGetObjectHandle(clientID, ("Pioneer_p3dx_ultrasonicSensor" + (i + 1)), sonarHandle, simx_opmode_oneshot_wait);
            if (ret == remoteApi.simx_return_ok)
                System.out.println("Got Handle");
            else
                System.out.format("Error: get sonar handle returned with error");
        }
        ret = robotClient.simxGetObjectHandle(clientID, "DefaultCamera", cameraHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle");
        else
            System.out.format("Error: get vision handle returned with error");

        ret = robotClient.simxGetObjectHandle(clientID, "Proximity_sensor", laserHandle, simx_opmode_oneshot_wait);
        if (ret == remoteApi.simx_return_ok)
            System.out.println("Got Handle!");
        else
            System.out.format("Error: get laser handle returned with error");

        return true;
    }

    public void disconnect(){
        robotClient.simxFinish(clientID);
    }

    public boolean checkConnection(){
        clientID = robotClient.simxGetConnectionId(clientID);

        if(clientID == -1){
            return false;
        }
        return true;
    }
    //DUVIDA :neste método eu colocoo como parametros os detectedpoints e a image tbm?
    public void updateSensors(){
        for(int i = 0; i < 16; i++){
            readSonar(sonarHandle);
        }
        readLaser();
        readCamera(cameraHandle);
    }

    //readSensor --> implement a different method to each sensor (readSonar, readLaser).
    public FloatWA readSonar(IntW sonarHandle){
        FloatWA detectedPoint = new FloatWA(16);

        robotClient.simxReadProximitySensor(clientID, sonarHandle.getValue(), null, detectedPoint, null, null,simx_opmode_streaming);

        return detectedPoint;
    }

    //Aqui no readLaser, se eu colocar o getStringSignal, como fica a leitura de dado?

    public CharWA readLaser (){
        CharWA signalValue = new CharWA(1);

        robotClient.simxGetStringSignal(clientID, "laserValue", signalValue ,simx_opmode_streaming);

        return signalValue;
    }


    public CharWA readCamera(IntW cameraHandle){
        CharWA image = new CharWA (1);
        //retorna image apenas
        IntWA resolution = new IntWA(1);
        //int [] values = cameraHandle.getArray(); <-- isso ou o que eu coloquei? Quando handle era IntWA
        robotClient.simxGetVisionSensorImage(clientID, cameraHandle.getValue(), resolution, image, 0, simx_opmode_streaming);

        return image;
    }

    //robotClient position
    public FloatWA readPositionAbsolut(int robotClientHandle){
        FloatWA position = new FloatWA(3);

        robotClient.simxGetObjectPosition(clientID, robotClientHandle, -1, position, simx_opmode_streaming );

        return position;
    }

    //in relation to the robotClient
    public FloatWA readPositionRelativ(int objectHandle){
        FloatWA position = new FloatWA(3);

        robotClient.simxGetObjectPosition(clientID, objectHandle, -1, position, simx_opmode_buffer );

        return position;
    }

    public int getClientID() {
        return clientID;
    }
}
