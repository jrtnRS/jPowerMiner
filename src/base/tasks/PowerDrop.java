package base.tasks;

import base.Context;
import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.script.task.Task;
import org.rspeer.ui.Log;
import util.InventoryUtil;

import java.util.function.Predicate;

public class PowerDrop extends Task {

    private final Predicate<Item> ore = item -> {
      if(item == null) return false;
      return item.getName().toLowerCase().contains("ore") || item.getName().toLowerCase().contains("uncut");
    };

    @Override
    public boolean validate() {
        return Context.validatePowerDrop();
    }

    @Override
    public int execute() {
        Log.info("Dropping ores.");
        Time.sleep(200, 400); //time between mining and dropping
        InventoryUtil.columnDrop(ore);
        return 0;
    }
}
