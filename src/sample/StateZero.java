package sample;


public class StateZero implements MachineStateInterface {

    @Override
    public void doWork(StateInterface state, String binaryValue) {

        if (State.valueOfThis(binaryValue).equals(State.STATE_ZERO)) {
            FSMMachineController.currentState = FSMMachineController.mapStateToClass(State.STATE_ZERO);
        } else {
            // SET NEW STATE
            FSMMachineController.currentState = FSMMachineController.mapStateToClass(State.valueOfThis(binaryValue));
        }
    }

    public int getValue() { return 0; }
}