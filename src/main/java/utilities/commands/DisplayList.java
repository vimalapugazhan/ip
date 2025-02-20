package utilities.commands;


import tasks.Task;
import ui.Constants;

import java.util.ArrayList;

public class DisplayList {

    /**
     * Displays the inputted array list to show details of task and the number of tasks remaining.
     *
     * @param list Array list containing the details of tasks.
     */
    public static void listCommand(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.out.println(Constants.EMPTYLIST);
            return;
        }
        System.out.println(Constants.LINE);
        System.out.println(Constants.CURRENTLIST);
        for (int i = 0; i < list.size(); i += 1) {
            System.out.println(Constants.TAB + (i + 1) + Constants.DOT + list.get(i).taskString());
        }
        System.out.println(Constants.NEWLINE);
    }
}
