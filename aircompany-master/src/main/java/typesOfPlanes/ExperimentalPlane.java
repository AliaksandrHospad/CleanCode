package typesOfPlanes;

import modelsOfPlanes.SecurityLevel;
import modelsOfPlanes.ExperimentalTypes;

public class ExperimentalPlane extends PlaneCharacteristics {

    private ExperimentalTypes type;
    private SecurityLevel securityLevel;


    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalTypes type, SecurityLevel securityLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.securityLevel = securityLevel;
    }

    public SecurityLevel getClassificationLevel(){
        return securityLevel;
    }

    public void setClassificationLevel(SecurityLevel securityLevel){
        this.securityLevel = securityLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
