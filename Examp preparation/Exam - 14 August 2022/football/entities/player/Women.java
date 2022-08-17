package football.entities.player;

public class Women extends BasePlayer {
    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);

        this.setKg(60);
    }

    @Override
    public int stimulation() {
        int strength = this.getStrength();

        strength += 115;

        this.setStrength(strength);
        return strength;
    }
}
