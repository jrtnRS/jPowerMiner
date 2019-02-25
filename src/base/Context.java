package base;

import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Players;
import util.rocks.RockHandler;

public class Context {

    public static boolean validatePowerDrop() {
        return inMiningArea() && Inventory.isFull();
    }

    public static boolean validateMineRock() {
        return inMiningArea() && !Inventory.isFull() && !Players.getLocal().isAnimating();
    }

    private static boolean inMiningArea() {
        return RockHandler.ROCK_AREA.contains(Players.getLocal().getPosition());
    }

    private static int experienceGained;
    private static int oreMined;
    private static long startTime;
    private static boolean isMining = false;

    public static void startTimer() {
        if(startTime == 0) {
            startTime = System.currentTimeMillis();
        }
    }

    public static int getExperienceGained() {
        return experienceGained;
    }

    public static int getOreMined() {
        return oreMined;
    }

    public static void incrementOreMined() {
        oreMined++;
        experienceGained += RockHandler.ROCK.getExperience();
    }

    public static long getRunTime() {
        return System.currentTimeMillis() - startTime;
    }

    public static int getExperiencePerHour() {
        double xphr = experienceGained / ((double) getRunTime() / 3600000D);
        return (int) xphr;
    }

    public static boolean isMining() {
        return isMining;
    }

    public static void setMining(boolean mining) {
        isMining = mining;
    }
}
