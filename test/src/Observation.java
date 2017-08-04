

import java.util.*;

public class Observation{

    private int readings;
    List observations;
    Sensor sensor;

    public Observation(Sensor sensor, int readings){
        this.sensor = sensor;
        this.readings = readings;
      //  observations = new ArrayList<sensor.readData().getClass()>(readings);
    }


    public int getReadings() {
        return readings;
    }

    public void setReadings(int readings) {
        this.readings = readings;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public void update(){
        //atualiza observations
    }

    public String toString() {
        String str = "Observation{" +
                "readings=" + readings ;


       /* for(int aux : readings)
            String str += (", observations"+aux+"="+observations(aux)+"\n");


        ", sensor=" + sensor +
                '}';*/
        return str;

    }
}