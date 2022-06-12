package sample;

public class StateTwo implements MachineStateInterface {

    @Override
    public void doWork(StateInterface state, String binaryValue) {

        if (State.valueOfThis(binaryValue).equals(State.STATE_ONE)) {
            // KEEP STATE
            return;
        } else {
            // SET NEW STATE
            FSMMachineController.currentState = FSMMachineController.mapStateToClass(State.STATE_ONE);
        }
    }

    public int getValue() { return 2; }
}