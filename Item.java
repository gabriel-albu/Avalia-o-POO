package br.com.fiap.pacman;

public class Item  extends GameObject{
    
    private boolean visivel;

    public Item(){

    }

    public Item(int x, int y, boolean visivel){
        super(x, y);
        this.visivel = visivel;
    }

    public boolean Visivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
    
}
