package tamagotchi.domain;

public abstract class Estado {
    private final int MAX = 100;
    private int initialState;
    private int currentState;
    private boolean isZero;

    public Estado(int intialState) {
        this.initialState = initialState;
    }

    abstract void aumentar();
    abstract void reducit();
    abstract void whenZero();
}

