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

    public Command(Instruction instruction, int value) {
        this.instruction = instruction;
        this.value = value;
    }

    public boolean visitInstruction() {
        if (visited) return true;
        visited = true;
        return false;

    }
}
