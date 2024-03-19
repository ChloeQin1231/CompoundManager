import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PlateTest {

    private Plate plate;

    @BeforeEach
    void setUp() {
        plate = new Plate();
    }

    @Test
    void testAddWell() {
        plate.addWell("A1");
        assertNotNull(plate.getSpecifiedWell("A1"), "Well with ID A1 should be added to the plate.");
    }

    @Test
    void testGetCompoundsInWell() {
        Well well = new Well("A1");
        Compound compound1 = new Compound("MRT-000001");
        Compound compound2 = new Compound("MRT-000005");
        //well.addCompound(compound1);
        //well.addCompound(compound2);
        plate.addWell("A1");
        plate.getSpecifiedWell("A1").addCompound(compound1);
        plate.getSpecifiedWell("A1").addCompound(compound2);
        Set<Compound> compounds = plate.getCompoundsInWell("A1");



        assertTrue(compounds.contains(compound1), "The well should contain compound1.");
        assertTrue(compounds.contains(compound2), "The well should contain compound2.");
    }

    @Test
    void testGetAllCompounds() {
        Well well1 = new Well("A1");
        Compound compound1 = new Compound("MRT-000001");
        Compound compound2 = new Compound("MRT-000002");

        Well well2 = new Well("B2");
        Compound compound3 = new Compound("MRT-000003");

        plate.addWell("A1");
        plate.addWell("B2");
        plate.getSpecifiedWell("A1").addCompound(compound1);
        plate.getSpecifiedWell("A1").addCompound(compound2);
        plate.getSpecifiedWell("B2").addCompound(compound3);

        Set<String> allCompounds = plate.getAllCompounds();
        assertTrue(allCompounds.contains(compound1.getCompoundId()), "The list of all compounds should contain compound1.");
        assertTrue(allCompounds.contains(compound2.getCompoundId()), "The list of all compounds should contain compound2.");
        assertTrue(allCompounds.contains(compound3.getCompoundId()), "The list of all compounds should contain compound3.");
    }
}
