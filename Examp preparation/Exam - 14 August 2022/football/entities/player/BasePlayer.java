package football.entities.player;

import static football.common.ExceptionMessages.*;

public class BasePlayer implements Player {
    private String name;
    private String nationality;
    private double kg;
    private int strength;

    public BasePlayer(String name, String nationality, int strength) {
        setName(name);
        setNationality(nationality);
        this.name = name;
        this.nationality = nationality;
        this.strength = strength;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }

        this.nationality = nationality;
    }

    @Override
    public int stimulation() {
        return 0;
    }

    @Override
    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }

        this.strength = strength;
    }


    @Override
    public int getStrength() {
        return strength;
    }
}
