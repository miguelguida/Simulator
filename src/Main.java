import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;


public class Main {
    static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main(String[] args) {

        Mat img = new Mat(3, 3, CvType.CV_64FC1);
        Simulator mVrep = new Simulator("127.0.0.1", 25000);
        System.out.println("Laser Value: ");
        while(true){
            //for (int i=0; i< mVrep.readLaser().getArray().length; ++i)
                //System.out.println("Laser " + ": " + mVrep.readLaser().getString());
            System.out.println(mVrep.readCamera().getArray());
        }
        //System.out.println("\nCheck Connection: "+mVrep.checkConnection());
        //System.out.println("\nClientID: "+mVrep.getClientID());
    }
}
