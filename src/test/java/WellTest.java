import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WellTest {
    @Test
    void testAddCompound() {
        Well well = new Well("A1");
        Well well2 = new Well("F12");
        Compound compound1 = new Compound("MRT-000001");
        Compound compound2 = new Compound("MRT-000002");

        assertTrue(well.addCompound(compound1), "Adding a compound for the first time should return true.");
        assertTrue(well.addCompound(compound2), "Adding a different compound should return true.");
        assertTrue(well2.addCompound(compound1), "Adding a compound for the first time should return true.");
        // Adding the same compound again should return false
        assertFalse(well.addCompound(compound1), "Adding the same compound again should return false.");
    }

    @Test
    void testCopyCompounds() {
        Well sourceWell = new Well("A1");
        Well targetWell = new Well("F12");

        Compound compound1 = new Compound("MRT-000001");
        Compound compound2 = new Compound("MRT-000002");

        sourceWell.addCompound(compound1);
        sourceWell.addCompound(compound2);

        targetWell.copyCompounds(sourceWell);

        // Check if the target well contains the same compounds as the source well
        assertEquals(sourceWell.getCompounds(), targetWell.getCompounds(), "Copied compounds should match the source well's compounds.");
    }

    @Test
    void testGetCompounds() {
        Well well = new Well("A1");
        Compound compound1 = new Compound("MRT-000001");
        Compound compound2 = new Compound("MRT-000002");

        well.addCompound(compound1);
        well.addCompound(compound2);

        Set<Compound> compounds = well.getCompounds();
        assertTrue(compounds.contains(compound1), "The well should contain compound1.");
        assertTrue(compounds.contains(compound2), "The well should contain compound2.");
    }
}
