import java.util.Objects;
import java.util.regex.Pattern;

public class Compound {

    private final String compoundId;
    private static final Pattern compoundIdPattern = Pattern.compile("^MRT-\\d{6}$");
    public Compound(String compoundId) {
        if (!compoundIdPattern.matcher(compoundId).matches()) {
            throw new IllegalArgumentException("Invalid compound ID format. Must be 'MRT-' followed by 6 digits.");
        }
        this.compoundId = compoundId;
    }
    public String getCompoundId() {
        return compoundId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compound compound = (Compound) o;
        return Objects.equals(compoundId, compound.compoundId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compoundId);
    }
}
