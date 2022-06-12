package sample;

interface MachineStateInterface extends StateInterface {
    private void doWork() {
        FSMMachineController.currentState.doWork();
    }
}
