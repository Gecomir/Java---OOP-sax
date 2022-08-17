package football.entities.field;

public class NaturalGrass extends BaseField{
    private static int capacity = 150;

    public NaturalGrass(String name) {
        super(name, capacity);
    }
}
