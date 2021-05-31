import typesOfPlanes.ExperimentalPlane;
import modelsOfPlanes.MilitaryTypes;
import typesOfPlanes.MilitaryPlane;
import typesOfPlanes.PassengerPlane;
import typesOfPlanes.PlaneCharacteristics;

import java.util.*;

public class Airport {
    private List<? extends PlaneCharacteristics> planes;

    public List<PassengerPlane> getPassengerPlane() {
        List<? extends PlaneCharacteristics> listPlane = this.planes;
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (PlaneCharacteristics p : listPlane) {
            if (p instanceof PassengerPlane)
                passengerPlanes.add((PassengerPlane) p);
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (PlaneCharacteristics planeCharacteristics : planes) {
            if (planeCharacteristics instanceof MilitaryPlane)
                militaryPlanes.add((MilitaryPlane) planeCharacteristics);
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity())
                planeWithMaxCapacity = passengerPlanes.get(i);
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryTypes.TRANSPORT)
            transportMilitaryPlanes.add(plane);
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryTypes.BOMBER)
                bomberMilitaryPlanes.add(plane);
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> ExperimentalPlanes = new ArrayList<>();
        for (PlaneCharacteristics planeCharacteristics : planes) {
            if (planeCharacteristics instanceof ExperimentalPlane)
                ExperimentalPlanes.add((ExperimentalPlane) planeCharacteristics);
        }
        return ExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<PlaneCharacteristics>() {
            public int compare(PlaneCharacteristics o1, PlaneCharacteristics o2) {
                return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<PlaneCharacteristics>() {
            public int compare(PlaneCharacteristics o1, PlaneCharacteristics o2) {
                return o1.maxSpeed() - o2.maxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<PlaneCharacteristics>() {
            public int compare(PlaneCharacteristics o1, PlaneCharacteristics o2) {
                return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends PlaneCharacteristics> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends PlaneCharacteristics> collection) {
        Iterator<? extends PlaneCharacteristics> iterator = collection.iterator();
        while (iterator.hasNext()) {
            PlaneCharacteristics planeCharacteristics = iterator.next();
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +'}';
    }

    public Airport(List<? extends PlaneCharacteristics> planes) {
        this.planes = planes;
    }

}
