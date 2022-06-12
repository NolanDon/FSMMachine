package main.interfaces;

// PRIMARY INTERFACE FOR CLASSES TO CONFORM TO NEEDED METHODS
public interface StateInterface {
    default void doWork(StateInterface state, String binaryValue) {}
    default int getValue() { return 0; }
}