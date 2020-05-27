import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TetrisGUI extends JFrame implements ActionListener {
	JPanel menu = new JPanel();
	JButton playButton = new JButton();
	public TetrisGUI() {
		setTitle("Tetris Main Menu");
		setVisible(true);
		setSize(732, 732);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		BufferedImage image = null;
		try {
			image = ImageIO.read(TetrisGUI.class.getResource("/dims.jpg"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		playButton.setIcon(new ImageIcon(image));
		menu.add(playButton);
		add(menu);
		playButton.addActionListener(this);
		validate();
	}
	public static void main(String[]args) {
		new TetrisGUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==playButton) {
			JFrame window = new JFrame();
			TetrisGame game = new TetrisGame();
			window.setSize(800,800);
			window.setTitle("Tetris");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
			window.setResizable(false);
			window.add(game);
		}
	}
}
