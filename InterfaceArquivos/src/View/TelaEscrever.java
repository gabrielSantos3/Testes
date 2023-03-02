package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEscrever {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEscrever window = new TelaEscrever();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEscrever() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
		
		JLabel txtEscrever = new JLabel("Digite o conteúdo a ser escrito no arquivo:");
		txtEscrever.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		txtEscrever.setBounds(51, 11, 352, 23);

		frame.getContentPane().add(txtEscrever);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 45, 414, 160);
		frame.getContentPane().add(textPane);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JRadioButton radioSobrescrever = new JRadioButton("Sobrescrever");
		radioSobrescrever.setBounds(217, 227, 112, 23);
		frame.getContentPane().add(radioSobrescrever);
		
		JRadioButton radioEscrever = new JRadioButton("Escrever");
		radioEscrever.setBounds(138, 227, 77, 23);
		radioEscrever.setSelected(true);
		frame.getContentPane().add(radioEscrever);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioSobrescrever);
		group.add(radioEscrever);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcoes t = new TelaOpcoes();
				frame.setVisible(false);
			}
		});
		btnCancelar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		frame.setVisible(true);
	}
}
