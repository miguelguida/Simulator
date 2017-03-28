import java.util.ArrayList;

/**
 * Created by miguel on 12/03/17.
 */
public class Sonar extends RangeSensor {
    private ArrayList<Double> data;
    private int nSensors;

    public Sonar(double coordX, double coordY, double coordZ, double minDistance, double maxDistance, double height, double beamAngle, double centerAngle,int nSensors){
        super(coordX, coordY, coordZ, minDistance, maxDistance, height, beamAngle, centerAngle);
        this.nSensors = nSensors;
        data = new ArrayList<Double>(nSensors);
    }

    public int getnSensors() {
        return nSensors;
    }

    public void setnSensors(int nSensors) {
        this.nSensors = nSensors;
    }

    public ArrayList<Double> getData() {
        return data;
    }

    public void setData(ArrayList<Double> data) {
        this.data = data;
    }


    public void readData(ArrayList<Double> data, int isDouble){
        this.data = data;
    }


    public String toString() {
        return "Sonar{" +super.toString() +", data=" + data +", nSensors=" + nSensors + "}";
    }
}
