package base.tasks;

import base.Context;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.script.task.Task;
import util.rocks.RockHandler;

public class MineRock extends Task {
    @Override
    public boolean validate() {
        return Context.validateMineRock();
    }

    @Override
    public int execute() {
        SceneObject rock = RockHandler.getValidRock();
        if(rock != null) {
            Context.setMining(true);
            rock.interact("Mine");
            Time.sleepUntil(() -> !Context.isMining(), 5000);
            Time.sleep(100, 500); //little bit of randomization
        }
        return 0;
    }
}
