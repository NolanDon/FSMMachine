package main.interfaces;
import main.*;

public interface MachineStateInterface extends StateInterface {
    private void doWork() {
        FSMMachineController.currentState.doWork();
    }
}
