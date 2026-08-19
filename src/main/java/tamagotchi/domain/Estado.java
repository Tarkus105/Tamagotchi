package tamagotchi.domain;

public abstract class Estado {
    private final int MAX = 100;
    private int initialState;
    private int currentState;
    private boolean isZero;

    public Estado(int initial) {
        this.initialState = initial;
        this.currentState = this.initialState;
        this.isZero = false;
    }

    void aumentar(int aumento) {
            this.currentState += aumento;
   };

    void reducir(int reduccion) {
        this.currentState -= reduccion;
    };

    int getCurrentState() {
        return this.currentState;
    }

   void isZero() {
        if (this.currentState == 0) {
            this.isZero = true;
        }
    }

    abstract void whenZero();
    abstract void whenMax();
}

