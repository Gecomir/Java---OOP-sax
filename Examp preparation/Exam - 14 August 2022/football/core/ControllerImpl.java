package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.BaseField;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<BaseField> fields;

    public ControllerImpl() {
        supplement = new SupplementRepositoryImpl();
        fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        fields.add((BaseField) field);

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplementDelivery;

        switch (type) {
            case "Powdered":
                supplementDelivery = new Powdered();
                break;
            case "Liquid":
                supplementDelivery = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplement.add(supplementDelivery);


        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {

        Supplement supplementAdd = supplement.findByType(supplementType);

        if (supplementAdd == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = getField(fieldName);

        field.addSupplement(supplementAdd);

        supplement.remove(supplementAdd);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);

    }

    private Field getField(String fieldName) {
        return fields.stream().filter(s -> s.getName().equals(fieldName)).findAny().get();
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = getField(fieldName);

        if ((player.getClass().getSimpleName().equals("Men") && field.getClass().getSimpleName().equals("ArtificialTurf")) ||
                (player.getClass().getSimpleName().equals("Women") && field.getClass().getSimpleName().equals("NaturalGrass"))) {
            return FIELD_NOT_SUITABLE;
        }

        field.addPlayer(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);

    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getField(fieldName);

        field.drag();

        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getField(fieldName);

        int fieldStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();

        return String.format(STRENGTH_FIELD, fieldName, fieldStrength);
    }

    @Override
    public String getStatistics() {
        return fields.stream().map(Field::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
