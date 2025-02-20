package utilities.commands;

import main.Aragorn;
import ui.Constants;
import utilities.parser.InputParser;

public class UnmarkTask {

    /**
     * Unmarks a completed task from the task list and prints the number of tasks remaining.
     *
     * @param input Parsed input containing index of the task being unmarked.
     * @param remainingTasks Number of tasks that remain incomplete.
     */
    protected static void unmarkTask(InputParser input, int remainingTasks) {
        try {
            int index = Integer.parseInt(input.getSplitInput()[0]);
            String icon = Aragorn.getList().get(index).getStatusIcon();
            if (icon.equals(Constants.INCOMPLETE)) {
                System.out.println(Constants.ALREADYUNMARKED);
                return;
            }
            Aragorn.getList().get(index).markAsUndone();
            remainingTasks += 1;
            System.out.println(Constants.UNMARKTASK + Aragorn.getList().get(index).taskString() + Constants.NEWLINE);
            Constants.printRemainingTasks(remainingTasks, Aragorn.getList().size());
        } catch (NullPointerException e) {
            System.out.println(Constants.INVALIDINDEX);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Constants.INVALIDTASK);
        }
    }

}
