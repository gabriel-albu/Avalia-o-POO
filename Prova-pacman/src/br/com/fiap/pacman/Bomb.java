package br.com.fiap.pacman;

public class Bomb extends Item{

    private int damage;

    
    public Bomb (){
        
    }
    
    public Bomb (int x, int y, boolean visivel){
        super(x, y, visivel);
    }

    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
