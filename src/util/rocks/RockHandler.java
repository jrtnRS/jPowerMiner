package util.rocks;

import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.SceneObjects;

import java.util.Arrays;
import java.util.function.Predicate;

public class RockHandler {

    public static Area ROCK_AREA;
    public static Rock ROCK;

    private static final Predicate<SceneObject> validRock = rock -> {
        if(rock == null) return false;
        if(!rock.getName().contains("Rocks")) return false;
        short[] rockColors = rock.getDefinition().getNewColors();
        return(rockColors != null && Arrays.equals(rockColors, ROCK.getColor())
                && ROCK_AREA.contains(rock.getPosition()));
    };

    public static SceneObject getValidRock() {
        SceneObject rock = SceneObjects.getNearest(validRock);

        return rock;
    }
}
