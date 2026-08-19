package tamagotchi.domain;

public class Character {

    final int MAX = 100;
    private int vida;
    private int edad;
    private Saciedad saciedad;
    private Diversion diversion;
    private boolean alive;

    public Character() {
        this.vida = 50;
        this.saciedad = new Saciedad(50);
        this.diversion = new Diversion(80);
        this.edad = 0;
        this.alive = true;
    }

    public int getMAX() {
        return MAX;
    }

    public int getVida() {
        return this.vida;
    }

    public int getEdad() {
        return this.edad;
    }

    public Saciedad getSaciedad() {

        return this.saciedad;
    }

    public Diversion getDiversion() {

        return this.diversion;
    }

    public void setEdad(int minutos) {
        this.edad = minutos;
    }

    public void reducirVida(int reduccion) {
        this.vida = this.vida - reduccion;
    }

    public void aumentarVida(int aumento) {
        this.vida = this.vida + aumento;
    }

    public boolean isAlive() {
        if (this.vida == 0) {
            this.alive = false;
        }

        return this.alive;
    }

    public boolean isHungry() {
        return this.saciedad.getCurrentState() == 0;
    }

    public boolean isBored() {
        return this.diversion.getCurrentState() == 0;
    }
}
