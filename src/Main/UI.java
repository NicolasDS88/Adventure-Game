package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {
	GameManager gm;
	JFrame window;
	
	public JTextArea messageText;
	public JPanel bgPanel[]= new JPanel[10];
	public JLabel bgLabel[]= new JLabel[10];
	
	
	public UI(GameManager gm) {		
		this.gm=gm;
		
		createMainField();
		createBackground();
		
		window.setVisible(true);
	}
	
	public void createMainField() {
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		messageText = new JTextArea("a SamPle of tHe Text ArEa wO=O=O=o0o0o");
		messageText.setBounds(50,410,700,150);
		messageText.setBackground(Color.lightGray);
		messageText.setForeground(Color.red);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
	
		window.add(messageText);
		
				
	}
	
	public void createBackground() {
		
		bgPanel[1]=new JPanel();
		bgPanel[1].setBounds(50,50,700,350); //x y altur ancho
		bgPanel[1].setBackground(Color.BLUE);
		bgPanel[1].setLayout(null);
		window.add(bgPanel[1]);
		
		bgPanel[1]=new JPanel(); //lo vamos a usar para poner imagenes
		bgPanel[1].setBounds(0,0,700,350);
	}
	
	

}
