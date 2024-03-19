import java.util.HashSet;
import java.util.Set;
public class Well {

    private final String wellId;
    private final Set<Compound> compounds;//All compounds in a given well must be distinct

    public Well(String wellId) {
        this.wellId = wellId;
        this.compounds = new HashSet<>();
    }

    public boolean addCompound(Compound compound) {
        return compounds.add(compound);
    }

    //Copy the contents of a well
    public void copyCompounds(Well otherWell) {
        this.compounds.addAll(otherWell.compounds);
    }
    //Get Compounds in a given well
    public Set<Compound> getCompounds() {
        return new HashSet<>(compounds);
    }

    public String getWellId() {
        return wellId;
    }
}
