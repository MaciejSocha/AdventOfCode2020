package day08;

public class Command {
    Instruction instruction;
    int value;
    private boolean visited;

    public Command(String line) {
        String inst = line.split(" ")[0];
        switch (inst) {
            case "acc":
                instruction = Instruction.acc;
                break;
            case "jmp":
                instruction = Instruction.jmp;
                break;
            case "nop":
                instruction = Instruction.nop;
                break;
        }
        value = Integer.parseInt(line.split(" ")[1]);
        visited = false;
    }

    public boolean visit() {
        if (visited) return false;
        visited = true;
        return true;

    }
}
