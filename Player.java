package br.com.fiap.pacman;

public class Player extends GameObject {

    private boolean invencivel = false;
    private int life = 3;
    private int direction;
    private int screenSize;

    public Player() {

    }

    public Player(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }

    
    public boolean isInvencivel() {
        return invencivel;
    }
    
    public void setInvencivel(boolean invecivel) {
        this.invencivel = invecivel;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public void mover(int direction) {
        if (podeMover(direction)) {
            switch (direction){
                case 0:
                    this.setY(this.getY() -10);
                break;
                case 90:
                    this.setX(this.getX() +10);
                break;    
                case 180:
                    this.setY(this.getY() +10);
                break;
                case 270:
                    this.setX(this.getX() -10);
            } 
        }
        }
        
    public boolean podeMover(int direction) {
        if (direction == 0) {
            if (getY() - 10 > 0) {
                return true;
            }
        }
        if (direction == 90) {
            if (getX() + 10 < getScreenSize()) {
                return true;
            }
        }
        if (direction == 180) {
            if (getY() + 10 < getScreenSize()) {
                return true;
            }
        }
        if (direction == 270) {
            if (getX() - 10 > 0) {
                return true;
            }
        }
        return false;
    }
    
}