package main.enums;

public enum State {
    STATE_ZERO("0"), STATE_ONE("1"), STATE_TWO("2");

    String key;

    State(String key) { this.key = key; }

    // RETURNS ENUM REPRESENTING BINARY VALUE
    public static State valueOfThis(String x) {
        if ("0".equals(x)) { return STATE_ZERO; }
        else if ("1".equals(x)) { return STATE_ONE; }
        else if ("2".equals(x)) { return STATE_TWO; }
        else { throw new IllegalArgumentException(); }
    }
}