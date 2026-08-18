package tamagotchi.domain;

public class Character {

    final int MAX = 100;
    private int vida;
    private int edad;
    private int saciedad;
    private int diversion;
    private boolean alive;

    public Character() {
        this.vida = 50;
        this.saciedad = 50;
        this.diversion = 50;
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

    public int getSaciedad() {
        return this.saciedad;
    }

    public int getDiversion() {
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

    public void reducirSaciedad(int reduccion) {
        this.saciedad = this.saciedad - reduccion;
    }

    public void aumentarSaciedad(int aumento) {
        this.saciedad = this.saciedad + aumento;
    }

    public void reducirDiversion(int reduccion) {
        this.diversion = this.diversion - reduccion;
    }

    public void aumentarDiversion(int aumento) {
        this.diversion = this.diversion + aumento;
    }

    public boolean isAlive() {
        if (this.vida == 0) {
            this.alive = false;
        }

        return this.alive;
    }
}
