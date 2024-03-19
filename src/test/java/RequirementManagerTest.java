import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequirementManagerTest {
    private RequirementManager requirementManager;

    @BeforeEach
    void setUp() {
        requirementManager = new RequirementManager();
    }

    @Test
    void testRegisterCompound() {
        assertTrue(requirementManager.registerCompound("MRT-000001"), "Should register compound MRT-000001");
        assertFalse(requirementManager.registerCompound("MRT-000001"), "Should not register duplicate compound MRT-000001");
    }

    @Test
    void testAssignCompoundToWell() {
        requirementManager.getPlate().addWell("A1");
        requirementManager.registerCompound("MRT-000001");
        requirementManager.registerCompound("MRT-000002");
        requirementManager.registerCompound("MRT-000003");

        assertTrue(requirementManager.assignCompoundToWell("MRT-000001", "A1"), "Should assign compound MRT-000001 to well A1");
        assertTrue(requirementManager.assignCompoundToWell("MRT-000002", "A1"), "Should assign compound MRT-000002 to well A1");
        assertThrows(IllegalArgumentException.class, () -> requirementManager.assignCompoundToWell("MRT-000004", "A1"), "Should throw exception for unregistered compound MRT-000004");
        assertThrows(IllegalArgumentException.class, () -> requirementManager.assignCompoundToWell("MRT-000003", "InvalidWell"), "Should throw exception for invalid well ID");
    }

    @Test
    void testCopyWellContents() {
        requirementManager.registerCompound("MRT-000001");
        requirementManager.registerCompound("MRT-000002");

        requirementManager.getPlate().addWell("A1");
        requirementManager.getPlate().addWell("B2");

        requirementManager.assignCompoundToWell("MRT-000001", "A1");
        requirementManager.assignCompoundToWell("MRT-000002", "A1");

        requirementManager.copyWellContents("A1", "B2");

        assertEquals(requirementManager.getPlate().getCompoundsInWell("A1"), requirementManager.getPlate().getCompoundsInWell("B2"), "Contents of well A1 should be copied to well B2");
    }
}
