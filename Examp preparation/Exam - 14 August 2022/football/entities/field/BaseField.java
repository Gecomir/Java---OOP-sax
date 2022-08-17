package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        setCapacity(capacity);

        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumEnergy() {
        int energy = 0;
        for (Supplement supplement : supplements) {
            energy += supplement.getEnergy();
        }

        return energy;
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() == this.getCapacity()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        players.add(player);
    }


    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {

        return name + " (" + getClass().getSimpleName() + "):" + System.lineSeparator() +
                "Player: " + (players.size() == 0 ? "none" : players.stream().map(Player::getName).collect(Collectors.joining(" "))) + System.lineSeparator() +
                "Supplement: " + supplements.size() + System.lineSeparator() +
                "Energy: " + sumEnergy();

    }

    @Override
    public Collection<Player> getPlayers() {
        return players;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return supplements;
    }

    @Override
    public String getName() {
        return name;
    }
}
