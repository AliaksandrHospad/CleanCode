package typesOfPlanes;

import java.util.Objects;

 public abstract class PlaneCharacteristics {
    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public PlaneCharacteristics(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {return model;}

    public int maxSpeed() {
        return maxSpeed;
    }

    public int Get_Max_Flight_Distance() {
        return maxFlightDistance;
    }

    public int getMinLoadCapacity() {return this.maxLoadCapacity;}

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaneCharacteristics)) return false;
        PlaneCharacteristics planeCharacteristics = (PlaneCharacteristics) o;
        return maxSpeed == planeCharacteristics.maxSpeed &&
                maxFlightDistance == planeCharacteristics.maxFlightDistance &&
                maxLoadCapacity == planeCharacteristics.maxLoadCapacity &&
                Objects.equals(model, planeCharacteristics.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
