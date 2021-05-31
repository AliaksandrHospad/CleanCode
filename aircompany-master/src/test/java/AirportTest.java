import typesOfPlanes.ExperimentalPlane;
import modelsOfPlanes.SecurityLevel;
import modelsOfPlanes.ExperimentalTypes;
import modelsOfPlanes.MilitaryTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import typesOfPlanes.MilitaryPlane;
import typesOfPlanes.PassengerPlane;
import typesOfPlanes.PlaneCharacteristics;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<PlaneCharacteristics> planeCharacteristics = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryTypes.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryTypes.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryTypes.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryTypes.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryTypes.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryTypes.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, SecurityLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VerticalTakeOffAndLanding, SecurityLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void getTransportMilitaryPlanes() {
        Airport airport = new Airport(planeCharacteristics);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean flag = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryTypes.TRANSPORT)) {
                flag = true;
                break;
            }
        }
        Assert.assertEquals(flag, true);
    }

    @Test
    public void getPassengerPlaneWithMaxCapacity() {
        System.out.println("TEST testGetPassengerPlaneWithMaxCapacity started!");
        Airport airport = new Airport(planeCharacteristics);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void getPlaneMaxLoadCapacity() {
        Airport airport = new Airport(planeCharacteristics);
        airport.sortByMaxLoadCapacity();
        List<? extends PlaneCharacteristics> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            PlaneCharacteristics currentPlaneCharacteristics = planesSortedByMaxLoadCapacity.get(i);
            PlaneCharacteristics nextPlaneCharacteristics = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlaneCharacteristics.getMinLoadCapacity() > nextPlaneCharacteristics.getMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void hasBomberInMilitaryPlanes() {
        Airport airport = new Airport(planeCharacteristics);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean flag = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryTypes.BOMBER)) {
                flag = true;
            }
            else {
                Assert.fail("Test failed!");
            }
        }
    }

    @Test
    public void experimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planeCharacteristics);
        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : ExperimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == SecurityLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
