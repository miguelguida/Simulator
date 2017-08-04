import java.util.ArrayList;

public class Camera extends Sensor {

    private ArrayList<Byte> data;
    private double fps;
    private String color;
    private int height;
    private int length;
    private int numBits;
    private double minFOV;
    private double maxFOV;
    private double currentFOV;



    public Camera(double coordX, double coordY, double coordZ, double fps, String color, int height, int length, int numBits, double minFOV, double maxFOV, double currentFOV){
        super(coordX, coordY, coordZ);
        this.fps = fps;
        this.color = color;
        this.height = height;
        this.length = length;
        this.numBits = numBits;
        this.minFOV = minFOV;
        this.maxFOV = maxFOV;
        this.currentFOV = currentFOV;

        if(color == "RGB"){
            data = new ArrayList<Byte>(height*length*3);
        }
        else if(color == "CMYK"){
            data = new ArrayList<Byte>(height*length*4);
        }
        else if(color == "Pantone"){
            data = new ArrayList<Byte>(height*length*6);
        }
    }
    
    
    public void readData(ArrayList<Byte> data){

        this.data = data;
    }

    public ArrayList<Byte> getData() {
        return data;
    }

    // PS: não sei se isso faz sentido no caso em que estamos tratando
    //public void setData(byte element) {
    //    data.add(element);
    //}

    public double getFps() {
        return fps;
    }

    public void setFps(double fps) {
        this.fps = fps;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumBits() {
        return numBits;
    }

    public void setNumBits(int numBits) {
        this.numBits = numBits;
    }

    public double getMinFOV() {
        return minFOV;
    }

    public void setMinFOV(double minFOV) {
        this.minFOV = minFOV;
    }

    public double getMaxFOV() {
        return maxFOV;
    }

    public void setMaxFOV(double maxFOV) {
        this.maxFOV = maxFOV;
    }

    public double getCurrentFOV() {
        return currentFOV;
    }

    public void setCurrentFOV(double currentFOV) {
        this.currentFOV = currentFOV;
    }

    public String toString() {
        return "Camera{" + 
                super.toString() +
                ", data=" + data +
                ", fps=" + fps +
                ", color='" + color + '\'' +
                ", height=" + height +
                ", length=" + length +
                ", numBits=" + numBits +
                ", minFOV=" + minFOV +
                ", maxFOV=" + maxFOV +
                ", currentFOV=" + currentFOV +
                '}';
    }
}
