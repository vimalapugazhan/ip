package utilities.file;

import main.Aragorn;
import tasks.Task;
import ui.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {

    /**
     * Adds formatted entries separated by "|" to a list which is then written into the text file.
     */
    public static void writeFile() {
        try {
            List<String> formattedEntries = new ArrayList<>();
            for (Task newTask : Aragorn.getList()) {
                formattedEntries.add(newTask.toFileString());
            }
            FileHandler.writeFile(formattedEntries);
        } catch (IOException e) {
            System.out.println(Constants.FILEWRITEERROR + e.getMessage() + Constants.NEWLINE + Constants.LINE);
        }
    }
}
