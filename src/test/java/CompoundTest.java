import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompoundTest {
    @Test
    void testValidCompoundId() {
        String validId = "MRT-000005";
        Compound compound = new Compound(validId);
        assertEquals(validId, compound.getCompoundId(), "Compound ID should match the one provided at construction for a valid ID.");
    }

    @Test
    void testInvalidCompoundId() {
        String invalidId = "MRT-1234567";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Compound(invalidId);
        }, "An IllegalArgumentException should be thrown for an invalid Compound ID.");

        assertTrue(thrown.getMessage().contains("Invalid compound ID format"), "Exception message should indicate an invalid Compound ID format.");
    }
}