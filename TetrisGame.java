import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class TetrisGame extends JPanel implements ActionListener, KeyListener{
	private final int WIDTH = 10;
	private final int HEIGHT = 20;
	public int speed = 500;
	Timer t = new Timer(speed, this);
	Shape shape = new Shape();
	Color c;
	boolean isEmpty = true;
	boolean first = true;
	boolean full = true;
	boolean paused = false;
	//Creating a grid to keep track of which squares are open
	public int [][]grid = new int[HEIGHT][WIDTH];
	public int [][]temp;
	public TetrisGame() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//These lines are just to draw the grid of the tetris game
		g.setColor(Color.WHITE);
		g.fillRect(0,0,800,800);
		g.setColor(Color.GRAY);
		for(int i = 70; i < 371; i += 30) {
			g.drawLine(i, 70, i, 670);
		}
		for(int i = 70; i < 700; i += 30) {
			g.drawLine(70, i, 370, i);
		}
		for(int i = 0; i < WIDTH; i++) {
			if(grid[0][i] != 0 && grid[0][i] != shape.current) {
				System.out.println("Game Over");
				t.stop();
			}
		}
		t.start();
		if(shape.dropped || first){
			for(int i = HEIGHT-1; i >= 0; i--) {
				full = true;
				for(int j = 0; j < WIDTH; j++) {
					if(grid[i][j] == 0) {
						//System.out.println("Here");
						full = false;
					}
				}
				if(full) {
					speedInc();
					//System.out.println("FULL");
					full = true;
					for(int k = i; k >= 1; k--) {
						for(int j = 0; j < WIDTH; j++) {
							grid[k][j] = grid[k-1][j];
						}
					}
					i++;
				}
			}
			first = false;
			shape = new Shape();
			switch(shape.num) {
				case 1:
					drawI(g2);
					break;
				case 2:
					drawS(g2);
					break;
				case 3:
					drawL(g2);
					break;
				case 4:
					drawT(g2);
					break;
				case 5:
					drawB(g2);
					break;
					
			}
		}
		for(int i = 0; i < HEIGHT; i++){
			for(int k = 0; k < WIDTH; k++) {
				if(grid[i][k] == 1 || grid[i][k] == 11) {
					c = new Color(102, 204, 255);
					isEmpty = false;
				}else if(grid[i][k] == 2 || grid[i][k] == 12) {
					c = new Color(242, 0, 86);
					isEmpty = false;
				}else if(grid[i][k] == 3 || grid[i][k] == 13) {
					c = new Color(176, 196, 222);
					isEmpty = false;
				}else if(grid[i][k] == 4 || grid[i][k] == 14) {
					c = new Color(140, 72, 159);
					isEmpty = false;
				}else if(grid[i][k] == 5 || grid[i][k] == 15) {
					c = new Color(255, 204, 0);
					isEmpty = false;
				}
				if(!isEmpty) {
					g.setColor(c);
					g2.fillRect((k+1)*30 + 40,(i+1)*30 + 40, 30, 30);
					g.setColor(Color.BLACK);
					g2.drawRect((k+1)*30 + 40,(i+1)*30 + 40, 30, 30);
					isEmpty = true;
				}
			}
		}
		shape.speedUp(grid);
	}	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	public void speedInc() {
		speed+= 5;
		t.stop();
		t = new Timer(speed, this);
		t.restart();
	}
	public void drawI(Graphics2D g){
		grid[0][3] = 11;
		grid[0][4] = 11;
		grid[0][5] = 11;
		grid[0][6] = 11;
	}
	public void drawS(Graphics2D g) {
		grid[0][4] = 12;
		grid[0][5] = 12;
		grid[1][3] = 12;
		grid[1][4] = 12;
	}
	public void drawL(Graphics2D g) {
		grid[0][3] = 13;
		grid[1][3] = 13;
		grid[1][4] = 13;
		grid[1][5] = 13;
	}
	public void drawT(Graphics2D g) {
		grid[0][5] = 14;
		grid[1][4] = 14;
		grid[1][5] = 14;
		grid[1][6] = 14;
	}
	public void drawB(Graphics2D g) {
		grid[0][4] = 15;
		grid[0][5] = 15;
		grid[1][4] = 15;
		grid[1][5] = 15;
	}
	public void pause() {
		t.stop();
	}
	public void resume() {
		t = new Timer(speed,this);
		t.restart();
	}
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP) {
			if(shape.num == 1 ) {	
				shape.rotateI(grid);
			}else if(shape.num == 2) {
				shape.rotateS(grid);
			}else if(shape.num == 3) {
				shape.rotateL(grid);
			}else if(shape.num == 4) {
				shape.rotateT(grid);
			}
				
		}else if(code == KeyEvent.VK_DOWN) {
			shape.speedUp(grid);
		}else if(code == KeyEvent.VK_LEFT) {
			shape.moveLeft(grid);
		}else if(code == KeyEvent.VK_RIGHT) {
			shape.moveRight(grid);
		}else if(code == KeyEvent.VK_SPACE) {
			//shape.drop(grid);
//			for(int i = 0; i < HEIGHT; i++) {
//				System.out.println();
//				for(int j = 0; j < WIDTH; j++) {
//					System.out.print(grid[i][j] + " ");
//				}
//			}
//			System.out.println();
		}else if(code == KeyEvent.VK_ESCAPE) {
			if(!paused) {
				pause();
				paused = true;
			}else {
				resume();
				paused = false;
			}
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

}
