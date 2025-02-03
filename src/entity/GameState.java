package entity;

public enum GameState {
    titleState(0),
    playState(1),
    pauseState(2),
    dialogueState(3),
    statsState(4),
    optionsState(5),
    tradeState(6),
    creditsState(7),
    introductionState(8),
    mapState(9),
    thumbState(10);


    private final int value;

    GameState(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}