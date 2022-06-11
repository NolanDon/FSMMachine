package sample;

class StartEngine {
    public static void main(String[] args) {
        FSMMachineController fsmMachine = new FSMMachineController();
        fsmMachine.startState("1010");
    }
}