package sample;
import java.util.HashMap;

public class FSMMachineController {

    private static MachineStateInterface currentState = new StateZero();

    public static void main(String[] args){}

    enum State {
        STATE_ZERO("0"), STATE_ONE("1"), STATE_TWO("2");

        String key;

        State(String key) { this.key = key; }

        static State valueOfThis(String x) {
            if ("0".equals(x)) { return STATE_ZERO; }
            else if ("1".equals(x)) { return STATE_ONE; }
            else if ("2".equals(x)) { return STATE_TWO; }
            else { throw new IllegalArgumentException(); }
        }
    }

    private static MachineStateInterface mapStateToClass(State state) {
        HashMap <State, MachineStateInterface> stateMapper = new HashMap();

        stateMapper.put(State.STATE_ZERO, new StateZero());
        stateMapper.put(State.STATE_ONE, new StateOne());
        stateMapper.put(State.STATE_TWO, new StateTwo());

        return stateMapper.get(state);
    }

    void startState(String value) {
        if (value == null) {return;}

        System.out.println("STARTING STATE: " + currentState.getValue());
        System.out.println("STARTING BINARY: " + value.charAt(0) + "\n");

        for (var i = 0; i < value.length(); i++) {

            String letter = Character.toString(value.charAt(i));
            transitionState(currentState, letter);
        }

        System.out.println("[FSMMachine]: final state: " + currentState);
    }

    static void transitionState(MachineStateInterface state, String binaryValue) {
        state.doWork(state, binaryValue);
    }

    interface StateInterface {
        default void doWork(StateInterface state, String binaryValue) {}
        default int getValue() { return 0; }
    }

    interface MachineStateInterface extends StateInterface {
        private void doWork() {
            currentState.doWork();
        }
    }

    public static class StateZero implements MachineStateInterface {

        @Override
        public void doWork(StateInterface state, String binaryValue) {

            // if binary is zero don't change state
            if (State.valueOfThis(binaryValue).equals(State.STATE_ZERO)) {
                currentState = mapStateToClass(State.STATE_ZERO);
            } else {
                // SET NEW CURRENT STATE
                currentState = mapStateToClass(State.valueOfThis(binaryValue));
                System.out.println("0 -> " + binaryValue + " -> " + currentState.getValue());
            }
        }

        @Override
        public int getValue() { return 0; }
    }
    public static class StateOne implements MachineStateInterface {

        @Override
        public void doWork(StateInterface state, String binaryValue) {
            // if binary is zero go forward
//            System.out.println("State.valueOfThis(binaryValue).equals(State.STATE_ONE)" + State.valueOfThis(binaryValue).equals(State.STATE_ONE));
            if (State.valueOfThis(binaryValue).equals(State.STATE_ONE)) {
                // PREVIOUS STATE
                currentState = mapStateToClass(State.STATE_ZERO);
                System.out.println("1 -> " + binaryValue + " -> " + currentState.getValue());
            } else {
                // SET NEW CURRENT STATE
                currentState = mapStateToClass(State.STATE_TWO);
                System.out.println("1 -> " + binaryValue + " -> " + currentState.getValue());
            }
        }


        public int getValue() { return 1; }
    }

    public static class StateTwo implements MachineStateInterface {

        @Override
        public void doWork(StateInterface state, String binaryValue) {
            // if binary is 1 stay the same else go back?
            if (State.valueOfThis(binaryValue).equals(State.STATE_ONE)) {
                currentState = mapStateToClass(State.STATE_TWO);
                System.out.println("2 -> " + binaryValue + " -> " + currentState.getValue());
            } else {
                // SET NEW CURRENT STATE
                currentState = mapStateToClass(State.STATE_ONE);
                System.out.println("2 -> " + binaryValue + " -> " + currentState.getValue());
            }
        }
        public int getValue() { return 2; }
    }
}

