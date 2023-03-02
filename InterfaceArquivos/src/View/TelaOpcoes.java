package View;

import GerenciadorArquivos.Gerenciador;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOpcoes {

	private JFrame frame;

	public TelaOpcoes() {
		initialize();
	}

	
	private void initialize() {
		Gerenciador g = new Gerenciador();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		
		JLabel txtArqSelecionado = new JLabel("Arquivo Selecionado: "+g.getNomeExtensao());
		txtArqSelecionado.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		txtArqSelecionado.setBounds(10, 11, 266, 23);

		frame.getContentPane().add(txtArqSelecionado);
		
		JButton btnMudar = new JButton("Mudar");
		btnMudar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal t = new TelaPrincipal();
				frame.setVisible(false);
			}
		});
		btnMudar.setBounds(10, 35, 89, 23);
		frame.getContentPane().add(btnMudar);
		
		JButton btnEscrever = new JButton("Escrever");
		btnEscrever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscrever t = new TelaEscrever();
				frame.setVisible(false);
                
                
			}
		});
		btnEscrever.setBounds(170, 174, 106, 23);
		frame.getContentPane().add(btnEscrever);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"CANCELAR", "APAGAR"};
		         
                int resp = JOptionPane.showOptionDialog(null,"Você deseja realmente apagar este arquivo?", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,  null, options, options[0]);
                if(resp != 0) {
                	JOptionPane.showMessageDialog(null, "Apagou");
                }
			}
		});
		btnApagar.setBounds(170, 208, 106, 23);
		frame.getContentPane().add(btnApagar);
		
		JButton btnLer = new JButton("Ler");
		btnLer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.lerArquivo();
			}
		});
		btnLer.setBounds(170, 140, 106, 23);
		frame.getContentPane().add(btnLer);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
