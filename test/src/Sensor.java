//Aluno: Miguel Augusto Silva Guida

import java.util.ArrayList;

public abstract class Sensor {

    private double coordX; //coordinates X, y and Z in relation to the robot
    private double coordY;
    private double coordZ;

    public Sensor(double coordX, double coordY, double coordZ) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.coordZ = coordZ;
    }

    //public abstract void readData(ArrayList<Byte> data);
    
    //public abstract void readData(ArrayList<Double> data);

    public void readData(ArrayList<Byte> data){
        return ;   
    }
    
    //I created the paramater isDouble to avoid using generic types for ArrayList,
    //and to solve the proble of name clash.  
    public void readData(ArrayList<Double> data, int isDouble){
        return ;   
    }
    
    public double getCoordX() {

        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public double getCoordZ() {
        return coordZ;
    }

    public void setCoordZ(double coordZ) {
        this.coordZ = coordZ;
    }



    public String toString() {
        return "Sensor{" +
                "coordX=" + coordX +
                ", coordY=" + coordY +
                ", coordZ=" + coordZ +
                '}';
    }
}
