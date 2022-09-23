package br.com.fiap.pacman;

public class GameObject {
    public int x;
    public int y;
    public int screensize;

    public GameObject() {

    }

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getScreenSize() {
        return screensize;
    }

    public void setScreenSize(int screensize) {
        this.screensize = screensize;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
