package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toyRepository;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {

        House house = null;

        switch (type) {
            case "LongHouse":
                house = new LongHouse(name);
                break;
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        houses.add(house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toyRepository.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toyRepository.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        House house =
                houses.stream()
                        .filter(h -> h.getName().equals(houseName))
                        .findFirst()
                        .orElse(null);

        house.buyToy(toy);
        toyRepository.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        Cat cat = null;

        switch (catType) {
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house =
                houses.stream()
                        .filter(h -> h.getName().equals(houseName))
                        .findFirst()
                        .orElse(null);

        if (houses.getClass().getSimpleName().equals("ShorthairCat") && catType.equals("LonghairCat") ||
                (houses.getClass().getSimpleName().equals("LonghairCat") && catType.equals("ShorthairCat"))) {
            return UNSUITABLE_HOUSE;
        }
        house.addCat(cat);

        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, catName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house =
                houses.stream()
                        .filter(c -> c.getName().equals(houseName))
                        .findFirst()
                        .orElse(null);

        house.feeding();

        int countCat = house.getCats().size();

        return String.format(FEEDING_CAT, countCat);

    }

    @Override
    public String sumOfAll(String houseName) {
        House house =
                houses.stream()
                        .filter(c -> c.getName().equals(houseName))
                        .findFirst()
                        .orElse(null);

        double allCatPrice = house.getCats()
                .stream()
                .mapToDouble(Cat::getPrice)
                .sum();

        double allToyPrice = house.getToys()
                .stream()
                .mapToDouble(Toy::getPrice)
                .sum();

        double value = allCatPrice + allToyPrice;

        return String.format(VALUE_HOUSE, houseName, value);
    }

    @Override
    public String getStatistics() {
        //"{houseName} {houseType}:
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        //Toys: {toysCount} Softness: {sumSoftness}"
        //"{houseName} {houseType}:
        //Cats: {catName1} {catName2} {catName3} ... / Cats: none
        //Toys: {toysCount} Softness: {sumSoftness}"
        //..."
        return houses.stream()
                .map(House::getStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
