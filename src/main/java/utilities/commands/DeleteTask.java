package utilities.commands;

import main.Aragorn;
import ui.Constants;
import utilities.parser.InputParser;

public class DeleteTask {

    /**
     * Deletes a task from the task list and prints the number of tasks remaining.
     *
     * @param input Parsed input containing index of the task being deleted.
     * @param remainingTasks Number of tasks that remain incomplete.
     */
    protected static void deleteTask(InputParser input, int remainingTasks) {
        try {
            int index = Integer.parseInt(input.getSplitInput()[0]);
            String icon = Aragorn.getList().get(index).getStatusIcon();
            if (icon.equals(Constants.INCOMPLETE)) {
                remainingTasks -= 1;
            }
            System.out.println(Constants.DELETETASK + Aragorn.getList().get(index).taskString() + Constants.NEWLINE);
            Aragorn.getList().remove(index);
            Constants.printRemainingTasks(remainingTasks, Aragorn.getList().size());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Constants.INVALIDTASK);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Constants.INVALIDINDEX);
        }
    }
}
