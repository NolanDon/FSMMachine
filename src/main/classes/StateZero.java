package main.classes;

import main.FSMMachineController;
import main.enums.*;
import main.interfaces.*;

public class StateZero implements MachineStateInterface {

    @Override
    public void doWork(StateInterface state, String binaryValue) {

        if (State.valueOfThis(binaryValue).equals(State.STATE_ZERO)) {
            // KEEP STATE
            return;
        } else {
            // SET NEW STATE
            FSMMachineController.currentState = FSMMachineController.mapStateToClass(State.STATE_ONE);
        }
    }

    public int getValue() { return 0; }
}