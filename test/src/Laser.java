import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Laser extends RangeSensor {

    private ArrayList<Double> data;
    private int numreadings;
    private double resolution;
    private double interval;

    public Laser(double coordX, double coordY, double coordZ, double minDistance, double maxDistance, double height, double beamAngle, double centerAngle, int numreadings, double resolution, double interval) {
        super(coordX, coordY, coordZ, minDistance, maxDistance, height, beamAngle, centerAngle);
        this.numreadings = numreadings;
        this.resolution = resolution;
        this.interval = interval;
        data = new ArrayList<Double>(numreadings);
    }

    public void readData(ArrayList<Double> data, int isDouble) {

        this.data = data;
    }

    public ArrayList<Double> getData() {
        return data;
    }


    public int getNumreadings() {
        return numreadings;
    }

    public void setNumreadings(int numreadings) {
        this.numreadings = numreadings;
    }

    public double getResolution() {
        return resolution;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public double getInterval() {
        return interval;
    }

    public void setInterval(double interval) {
        this.interval = interval;
    }

    public String toString() {
        return "Laser{" +
                super.toString() +
                ", data=" + data +
                ", numreadings=" + numreadings +
                ", resolution=" + resolution +
                ", interval=" + interval +
                '}';
    }
}
