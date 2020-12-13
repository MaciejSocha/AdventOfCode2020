package day08;

import java.util.ArrayList;
import java.util.List;

public class BatchFile {
    private List<Command> file;

    public BatchFile(String inputFile) {
        file = new ArrayList<>();
        inputFile.lines().forEach(line -> file.add(new Command(line)));
    }

    public int process() {
        int accumulator = 0;
        Command actualCommand = file.get(0);
        int index = 0;
        boolean breakValue = true;
        do {
            actualCommand = file.get(index);
            switch (actualCommand.instruction) {
                case acc:
                    if (!actualCommand.visit()) {
                        breakValue = false;
                        break;
                    }
                    accumulator += actualCommand.value;
                    file.set(index, actualCommand);
                    index++;
                    break;

                case jmp:
                    if (!actualCommand.visit()) {
                        breakValue = false;
                        break;
                    }
                    file.set(index, actualCommand);
                    index += actualCommand.value;
                    break;

                case nop:
                    if (!actualCommand.visit()) {
                        breakValue = false;
                        break;
                    }
                    file.set(index, actualCommand);
                    index++;
                    break;
            }
        } while (breakValue);

        return accumulator;
    }
}
