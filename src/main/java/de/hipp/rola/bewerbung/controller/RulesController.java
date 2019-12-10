package de.hipp.rola.bewerbung.controller;

import de.hipp.rola.bewerbung.constants.GameOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller that handles the Rules
 */
public class RulesController {

    public Map<GameOption, List<GameOption>> winsAgainstMapping = new LinkedHashMap<>();

    /**
     * Within this Constructor I create a map to determine which option wins against which options
     */
    public RulesController() {
        this.addRules(GameOption.PAPER, GameOption.STONE);
        this.addRules(GameOption.STONE, GameOption.SCISSORS);
        this.addRules(GameOption.SCISSORS, GameOption.PAPER);
    }

    /**
     * Takes a Base Option and saves an Array of options that the Base Option wins against
     *
     * @param base        BaseOption
     * @param winsAgainst an Array of options the BaseOption wins against
     */
    private void addRules(GameOption base, GameOption... winsAgainst) {
        if (!winsAgainstMapping.containsKey(base)) {
            winsAgainstMapping.put(base, new ArrayList<GameOption>());
        }
        winsAgainstMapping.get(base).addAll(Arrays.asList(winsAgainst));
    }

    /**
     * Checks if the optionToCheck is part of the List the playerOption wins against
     *
     * @param baseOption    baseOption which should be checked
     * @param optionToCheck the Option the baseOption should win against
     * @return {boolean} value if that is true or not
     */
    public boolean winsAgainst(GameOption baseOption, GameOption optionToCheck) {
        List<GameOption> winingList = winsAgainstMapping.get(baseOption);
        if (winingList == null || winingList.isEmpty()) {
            return false;
        }

        return winingList.contains(optionToCheck);
    }
}
