package tamagotchi.domain;

public abstract class Caracteristica {
    private final int MAX = 100;
    private int initialState;
    private int currentState;

    public Caracteristica(int initial) {
        this.initialState = initial;
        this.currentState = this.initialState;
    }

    public void aumentar(int aumento) {
        if (this.currentState + aumento <= this.MAX) {
            this.currentState += aumento;
        } else {
            this.currentState = 100;
        }

    }

    public void reducir(int reduccion) {
        if (this.currentState - reduccion >= 0) {
            this.currentState -= reduccion;
        } else {
            this.currentState = 0;
        }

    }

    public int getCurrentState() {
        return this.currentState;
    }

    public boolean isZero() {
        if (this.currentState == 0) {
            return true;
        }

        return false;
    }

    public String toString() {
        return this.currentState + "/" + this.MAX;
    }
}

