public abstract class RangeSensor extends Sensor {

    private double minDistance;
    private double maxDistance;
    private double height; //in relation to the ground
    private double beamAngle;
    private double centerAngle; //angle in relation to the center of the robot

    public RangeSensor(double coordX, double coordY, double coordZ, double minDistance, double maxDistance, double height, double beamAngle, double centerAngle) {
        super(coordX, coordY, coordZ);
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.height = height;
        this.beamAngle = beamAngle;
        this.centerAngle = centerAngle;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBeamAngle() {
        return beamAngle;
    }

    public void setBeamAngle(double beamAngle) {
        this.beamAngle = beamAngle;
    }

    public double getCenterAngle() {
        return centerAngle;
    }

    public void setCenterAngle(double centerAngle) {
        this.centerAngle = centerAngle;
    }

    public java.lang.String toString() {
        return "RangeSensor{" +
                super.toString() +
                "minDistance=" + minDistance +
                ", maxDistance=" + maxDistance +
                ", height=" + height +
                ", beamAngle=" + beamAngle +
                ", centerAngle=" + centerAngle +
                '}';
    }
}
