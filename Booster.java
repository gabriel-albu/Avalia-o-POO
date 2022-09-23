package br.com.fiap.pacman;

public class Booster extends Item{

    private int invencivel;

    
    public Booster (){
        
    }
    
    public Booster (int x, int y, Boolean visivel){
        super(x, y, visivel);
    }
    
    
    public int getInvencivel() {
        return invencivel;
    }
    
    public void setInvencivel(int invencivel) {
        this.invencivel = invencivel;
    }
    
    public void playerInvencivel(Player player){
        if(invencivel > 0)
        player.setInvencivel(true);
        else
        player.setInvencivel(false);
    }
}
    