import java.util.HashMap;
import java.util.regex.Pattern;

public class RequirementManager {
    private HashMap<String, Compound> registeredCompounds = new HashMap<>();
    private Plate plate = new Plate();
    public Plate getPlate() {
        return plate;
    }

    public boolean registerCompound(String compoundId) {
        // Check if the compound is already registered
        if (registeredCompounds.containsKey(compoundId)) {
            return false;
        }
        try {
            Compound compound = new Compound(compoundId);
            registeredCompounds.put(compoundId, compound);
        } catch (IllegalArgumentException e) {
            //If Compound constructor throws an exception due to invalid ID format
            throw new IllegalArgumentException("Cannot register compound: " + e.getMessage());
        }
        return true;
    }

    //Assign a registered compound to a well
    public boolean assignCompoundToWell(String compoundId, String wellId) {
        // Check if the compound ID is already registered
        Compound compound = registeredCompounds.get(compoundId);
        if (compound == null) {
            //if a compoundId is not registered before adding to a well, the operation should fail.
            throw new IllegalArgumentException("Compound ID " + compoundId + " is not registered yet.");
        }

        Well well = plate.getSpecifiedWell(wellId);
        if (well == null) {
            throw new IllegalArgumentException("Well ID " + wellId + " is not valid.");
        }

        return well.addCompound(compound);
    }

    //Copy the contents of a well
    public void copyWellContents(String sourceWellId, String targetWellId) {
        // Check if the source and target wells are exists
        Well sourceWell = plate.getSpecifiedWell(sourceWellId);
        Well targetWell = plate.getSpecifiedWell(targetWellId);
        if (sourceWell == null) {
            throw new IllegalArgumentException("Source well " + sourceWellId + " does not exist.");
        }
        if (targetWell == null) {
            plate.addWell(targetWellId);
            targetWell = plate.getSpecifiedWell(targetWellId);
        }

        targetWell.copyCompounds(sourceWell);

    }

}
