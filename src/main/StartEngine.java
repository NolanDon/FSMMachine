package main;

import main.FSMMachineController;

public class StartEngine {
    public static void main(String[] args) {}

    public StartEngine(String binaryValue) {
        FSMMachineController fsmMachine = new FSMMachineController();
        fsmMachine.startState(binaryValue);
    }
}