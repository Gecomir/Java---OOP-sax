package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private final HelperRepository helperRepository;
    private final PresentRepository presentRepository;
    private final Shop shop = new ShopImpl();

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        //Creates a helper with the given name of the given type and adds it to the corresponding repository.
        //If the helper is invalid, throw an IllegalArgumentException with a message:
        //"Helper type doesn't exist!"
        //The method should return the following message:
        //"Successfully added {helperType} named {helperName}!"
        BaseHelper helper;

        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);

        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        //Creates an instrument with the given power and adds it to the collection of the helper.
        //If the helper doesn't exist, throw an IllegalArgumentException with a message:
        //"The helper you want to add an instrument to doesn't exist!"
        //The method should return the following message:
        //"Successfully added instrument with power {instrumentPower} to helper {helperName}!"

        if (helperRepository.findByName(helperName) == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);
        helperRepository.findByName(helperName).addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        //Creates a present with the provided name and required energy and adds it to the corresponding repository.
        //The method should return the following message:
        //•	"Successfully added Present: {presentName}!"

        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        //When the craft command is called, the action happens.
        //You should start crafting the given present, by assigning helpers which are almost ready:
        //The helpers that you should select are the ones with energy above 50 units.
        //The suitable ones start working on the given present.
        //If no helpers are ready, throw IllegalArgumentException with the following message:
        //"There is no helper ready to start crafting!"
        //After the work is done, you must return the following message, reporting whether the present is done and how many instruments have been broken in the process:
        //"Present {presentName} is {done/not done}. {countBrokenInstruments} instrument/s have been broken while working on it!"
        //Note: The name of the present you receive will always be a valid one.

        List<Helper> collect = helperRepository.getModels()
                .stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        long brokenInstruments = 0;
        Present present = presentRepository.findByName(presentName);

        for (Helper helper : collect) {
            shop.craft(present, helper);
            brokenInstruments += helper.getInstruments()
                    .stream()
                    .filter(Instrument::isBroken)
                    .count();

            if (present.isDone()) {
                break;
            }
        }

        if (present.isDone()) {
            return String.format(PRESENT_DONE, presentName, "done") +
                    String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
        }
        return String.format(PRESENT_DONE, presentName, "not done") +
                String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {
        //Returns information about crafted presents and helpers:
        //"{countCraftedPresents} presents are done!"
        //"Helpers info:"
        //"Name: {helperName1}"
        //"Energy: {helperEnergy1}"
        //"Instruments: {countInstruments} not broken left"
        //…
        //"Name: {helperNameN}"
        //"Energy: {helperEnergyN}"
        //"Instruments: {countInstruments} not broken left"


        long size = presentRepository.getModels()
                .stream()
                .filter(Present::isDone)
                .count();
        List<String> collect = helperRepository.getModels()
                .stream().map(helper -> String.format(
                        "Name: %s%n" +
                                "Energy: %d%n" +
                                "Instruments: %d not broken left%n", helper.getName(), helper.getEnergy(),
                        helper.getInstruments()
                                .stream()
                                .filter(instrument -> !instrument.isBroken())
                                .count()))
                .collect(Collectors.toList());
        return String.format("%d presents are done!%n", size) +
                String.format("Helpers info:%n") +
                String.join("", collect).trim();
    }
}

