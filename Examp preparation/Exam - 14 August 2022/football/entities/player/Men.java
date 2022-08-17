package football.entities.player;

public class Men extends BasePlayer {
    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);

        this.setKg(85.50);
    }

    @Override
    public int stimulation() {
        int strength = this.getStrength();

        strength += 145;
        this.setStrength(strength);

        return strength;
    }
}

