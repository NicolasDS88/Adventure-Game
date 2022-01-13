package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
	GameManager gm;
	JFrame window;

	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];

	public UI(GameManager gm) {
		this.gm = gm;

		createMainField();
		generateScreen();

		window.setVisible(true);
	}

	public void createMainField() {

		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		messageText = new JTextArea("Hola Catalina, vamos a jugar!!");
		messageText.setBounds(50, 410, 700, 140);
		messageText.setBackground(Color.lightGray);
		messageText.setForeground(Color.red);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));

		window.add(messageText);

	}

	public void createBackground(int bgNum, String bgFileName) {

		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50, 50, 700, 350); // x y altur ancho
		bgPanel[bgNum].setBackground(Color.BLUE);
		bgPanel[bgNum].setLayout(null);
		window.add(bgPanel[1]);

		bgLabel[bgNum] = new JLabel(); // lo vamos a usar para poner imagenes
		bgLabel[bgNum].setBounds(0, 0, 700, 350);

		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);

	}

	public void createObject(int bgNum, int objX, int objY, int objWidth, int objHeight, String fileName, String opt1,
			String opt2, String opt3) {
		// Pop menu
		JPopupMenu popMenu = new JPopupMenu();
		// create item pop menu items
		JMenuItem menuItem[] = new JMenuItem[4]; // obviamos usar el 0
		menuItem[1] = new JMenuItem(opt1);
		popMenu.add(menuItem[1]);
		menuItem[2] = new JMenuItem(opt2);
		popMenu.add(menuItem[2]);
		menuItem[3] = new JMenuItem(opt3);
		popMenu.add(menuItem[3]);

		// create objects
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objX, objY, objWidth, objHeight);
		ImageIcon obejectIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));
		objectLabel.setIcon(obejectIcon);

		// mouse listener
		objectLabel.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					popMenu.show(objectLabel, e.getX(), e.getY()); //seteamos para que tome el tamaño de la imagen object
				}
			}

			public void mouseReleased(MouseEvent e) {
			}

		});

		bgPanel[bgNum].add(objectLabel); // personaje
		bgPanel[bgNum].add(bgLabel[bgNum]); // fondo se agregan al revez y el fondo tapa la imagen sino
	}

	public void generateScreen() {
		// pantalla
		// createBackground(int bgNum, String bgFileName) ///enviar esos atributos
		createBackground(1, "casaBob.jpg");
		createObject(1, 500, 180, 200, 166, "bobprincipal.png", "Tocame aca", "tocame esta", "Goloza");
		createObject(1, 400, 170, 212, 212, "patrici.png", "Tocame aca", "tocame esta", "Goloza");
		createObject(1, 100, 100, 144, 344, "calamardo.png", "Tocame aca", "tocame esta", "Goloza");
		//donde me quede
		//https://www.youtube.com/watch?v=Rdm_iMQh9G8&list=PL_QPQmz5C6WVLQ2_yYpN5BjEaS9uLRGbD&index=3
		
	}
}
