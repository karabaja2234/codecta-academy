package ba.codecta.disneychars;

public abstract class DisneyCharacter {
    public abstract String getName();
    public abstract String getImageName();

    public String welcomes() {
        return "Hello default!";
    }
}
