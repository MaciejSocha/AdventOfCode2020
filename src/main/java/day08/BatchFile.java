package day08;

import java.util.ArrayList;
import java.util.List;

public class BatchFile {
    private final List<Command> file;

    public BatchFile(String inputFile) {
        file = new ArrayList<>();
        inputFile.lines().forEach(line -> file.add(new Command(line)));
    }

    public int changeElementsReturnItIndex(int indexToStartCount) {
        int i = indexToStartCount;
        while (i < file.size()) {
            if (file.get(i).instruction.equals(Instruction.jmp)) {
                file.set(i, new Command(Instruction.nop, file.get(i).value));
                return ++i;
            } else if (file.get(i).instruction.equals(Instruction.nop)) {
                file.set(i, new Command(Instruction.jmp, file.get(i).value));
                return ++i;
            } else
                i++;
        }
        return i;
    }

    public int process() {
        int accumulator = 0;
        Command actualCommand;
        int index = 0;
        boolean breakValue = true;
        boolean indexOutOfBand = false;
        do {
            if (index >= file.size()) {
                indexOutOfBand = true;
                break;
            }
            actualCommand = file.get(index);
            switch (actualCommand.instruction) {
                case acc:
                    if (actualCommand.visitInstruction()) {
                        breakValue = false;
                        break;
                    }
                    accumulator += actualCommand.value;
                    file.set(index, actualCommand);
                    index++;
                    break;

                case jmp:
                    if (actualCommand.visitInstruction()) {
                        breakValue = false;
                        break;
                    }
                    file.set(index, actualCommand);
                    index += actualCommand.value;
                    break;

                case nop:
                    if (actualCommand.visitInstruction()) {
                        breakValue = false;
                        break;
                    }
                    file.set(index, actualCommand);
                    index++;
                    break;
            }
        } while (breakValue);

        if (indexOutOfBand)
            return accumulator;
        return -1;
    }
}
