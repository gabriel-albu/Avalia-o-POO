package br.com.fiap.pacman;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Game extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Player player = new Player(50, 50, 180);
	private Ghost ghost1 = new Ghost(0,0,0);
	private Ghost ghost2 = new Ghost(500,0,0);
	private Ghost ghost3 = new Ghost(0,500,0);
	private Ghost ghost4 = new Ghost(500,500,0);
	private Bomb bomb = new Bomb(100,100, true);
	private Booster booster = new Booster(200, 200, true);

	private JLabel imgPlayer = new JLabel(new ImageIcon("src/images/pacman.png"));
	private JLabel imgGhost1 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost2 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost3 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgGhost4 = new JLabel(new ImageIcon("src/images/ghost.png"));
	private JLabel imgBomb = new JLabel(new ImageIcon("src/images/bomb.png"));
	private JLabel imgBooster = new JLabel(new ImageIcon("src/images/booster.png"));

	private final int SCREENSIZE = 600;
	private int speed = 50;
	
	public static void main(String[] args) {
		new Game().init();
	}

	private void init() {
		setLayout(null);
		player.setScreenSize(SCREENSIZE);
		player.setLife(15);

		ghost1.setScreenSize(SCREENSIZE);
		ghost2.setScreenSize(SCREENSIZE);
		ghost3.setScreenSize(SCREENSIZE);
		ghost4.setScreenSize(SCREENSIZE);
		
		add(imgPlayer);
		add(imgGhost1);
		add(imgGhost2);
		add(imgGhost3);
		add(imgGhost4);
		add(imgBomb);
		add(imgBooster);

		render();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREENSIZE + 100, SCREENSIZE + 100);
		setVisible(true);
		addKeyListener(this);

		run();
	}

	private void render() {
		
		updateLocation(imgPlayer, player);
		updateLocation(imgGhost1, ghost1);
		updateLocation(imgGhost2, ghost2);
		updateLocation(imgGhost3, ghost3);
		updateLocation(imgGhost4, ghost4);
		updateLocation(imgBomb, bomb);
		updateLocation(imgBooster, booster);
		setTitle("Life: " + player.getLife());
		SwingUtilities.updateComponentTreeUI(this);

	}

	private void updateLocation(JLabel label, GameObject object) {
		label.setBounds(object.getX(), object.getY(), 50, 50);
		ImageIcon myImage = (ImageIcon) label.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        label.setIcon( new ImageIcon(newImg) );
	}

	private void run() {
		while (player.getLife() > 0) {
			
			//coloque aqui os métodos de movimentação e colisão 

			if(player.getX() == ghost1.getX() && player.getY() == ghost1.getY()){
				if(player.isInvencivel() == false){
				player.setLife(player.getLife() - 1);
				}
			}
			if(player.getX() == ghost2.getX() && player.getY() == ghost1.getY()){
				if(player.isInvencivel() == false){
				player.setLife(player.getLife() - 1);
				}
			}
			if(player.getX() == ghost3.getX() && player.getY() == ghost1.getY()){
				if(player.isInvencivel() == false){
				player.setLife(player.getLife() - 1);
				}
			}
			if(player.getX() == ghost4.getX() && player.getY() == ghost1.getY()){
				if(player.isInvencivel() == false){
				player.setLife(player.getLife() - 1);
				}
			}


			if(player.getX() == bomb.getX() && player.getY() == bomb.getY()){
				if(player.isInvencivel() == false){
				player.setLife(player.getLife() - 2);
			}
		}

				
			if(booster.getX() == player.getX() && booster.getY() == player.getY()){
				booster.playerInvencivel(player);
				booster.setVisivel(false);
			}
			
			if(player.getX() == booster.getX() && player.getY() == booster.getY()){
				player.setInvencivel(true);
				System.out.println("Está invencível");
			}


			try {
				ghost1.mover();
				ghost2.mover();
				ghost3.mover();
				ghost4.mover();
				
				player.mover(player.getDirection());
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == '8' || c == 'w') player.setDirection(0);	
		if (c == '6' || c == 'd') player.setDirection(90);	
		if (c == '2' || c == 's') player.setDirection(180);	
		if (c == '4' || c == 'a') player.setDirection(270);	
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	

	
}
