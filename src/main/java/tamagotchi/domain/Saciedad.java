package tamagotchi.domain;

public class Saciedad extends Estado{

    public Saciedad(int initial) {
        super(initial);
    }

    public void whenZero() {
        super.aumentar(4);
    }
    public void whenMax() {
        super.reducir(4);
    }
}
