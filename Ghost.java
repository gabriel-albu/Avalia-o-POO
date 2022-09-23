package br.com.fiap.pacman;

public class Ghost extends GameObject {
    private int direction;

    public Ghost() {

    }

    public Ghost(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }
    
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public void mover(){
        int random = (int) ((Math.random() * 4) + 1);

        //System.out.println(random);
        if (podeMover(random) == true) {
        if(random == 1){
            this.setY(this.getY() -10);
            this.setDirection(0);
        }
        if(random == 2){
            this.setX(this.getX() +10);
            this.setDirection(90);
        }
        if(random == 3){
            this.setY(this.getY() +10);
            this.setDirection(180);
        }
        if(random == 4){
            this.setX(this.getX() -10);
            this.setDirection(270);
        }
    }
    }

    public boolean podeMover(int random) {
        if (random == 1) {
            if (getY() - 10 > 0) {
                return true;
            }
        }
        if (random == 2) {
            if (getX() + 10 < getScreenSize()) {
                return true;
            }
        }
        if (random == 3) {
            if (getY() + 10 < getScreenSize()) {
                return true;
            }
        }
        if (random == 4) {
            if (getX() - 10 > 0) {
                return true;
            }
        }
        return false;
    }



}
