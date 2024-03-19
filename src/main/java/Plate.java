import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Plate {
    private final HashMap<String, Well> wells = new HashMap<>();
    private static final Pattern wellIdPattern = Pattern.compile("^[A-Z]\\d+$");
    public Well getSpecifiedWell(String wellId) {
        return wells.get(wellId);
    }

    public void addWell(String wellId) {
        if (!wellIdPattern.matcher(wellId).matches()) {
            throw new IllegalArgumentException("Invalid well ID: " + wellId);
        }
        wells.putIfAbsent(wellId, new Well(wellId));
    }

    //Get Compounds in a given well
    public Set<Compound> getCompoundsInWell(String wellId) {
        Well well = wells.get(wellId);
        return well != null ? well.getCompounds() : Set.of();
    }

    //Get a list of all compounds on a plate
    public Set<String> getAllCompounds() {
        HashSet<String> allCompounds = new HashSet<>();
        for (Well well : wells.values()) {
            Set<Compound> compounds = well.getCompounds();
            for (Compound compound : compounds) {
                allCompounds.add(compound.getCompoundId());
            }
        }
        return allCompounds;
    }
}
