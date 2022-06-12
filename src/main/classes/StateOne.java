package main.classes;

import main.FSMMachineController;
import main.enums.State;
import main.interfaces.*;

public class StateOne implements MachineStateInterface {

    @Override
    public void doWork(StateInterface state, String binaryValue) {

        if (State.valueOfThis(binaryValue).equals(State.STATE_ONE)) {
            // PREVIOUS STATE
            FSMMachineController.currentState = FSMMachineController.mapStateToClass(State.STATE_ZERO);
        } else {
            // SET NEW STATE
            FSMMachineController.currentState = FSMMachineController.mapStateToClass(State.STATE_TWO);
        }
    }

    public int getValue() { return 1; }
}