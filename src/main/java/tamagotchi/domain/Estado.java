package tamagotchi.domain;

public abstract class Estado {
    private final int MAX = 100;
    private int initialState;
    private int currentState;

    public Estado(int initial) {
        this.initialState = initial;
        this.currentState = this.initialState;
    }

    public void aumentar(int aumento) {
        if (this.currentState < this.MAX) {
            this.currentState += aumento;
        }

    }

    public void reducir(int reduccion) {
        if (this.currentState > 0) {
            this.currentState -= reduccion;
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

