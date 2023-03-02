package View;

import GerenciadorArquivos.Gerenciador;

import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;
	public JTextField campoNomeArq;
	public JComboBox combobox;


	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
		
		JLabel txtTitulo = new JLabel("Gerenciador de arquivos");
		txtTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		txtTitulo.setBounds(120, 11, 192, 22);
		frame.getContentPane().add(txtTitulo);
		
		campoNomeArq = new JTextField();
		campoNomeArq.setBounds(155, 61, 209, 20);
		frame.getContentPane().add(campoNomeArq);
		campoNomeArq.setColumns(10);
		
		String[] formatosArquivo = {"TXT", "CSV", "JAVA"};
		JComboBox<String> comboBox = new JComboBox<String>(formatosArquivo);
		comboBox.setBounds(155, 104, 79, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel txtExtensao = new JLabel("Extensão:");
		txtExtensao.setBounds(56, 104, 101, 14);
		frame.getContentPane().add(txtExtensao);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = campoNomeArq.getText();
				String campoSelecionado = (String) comboBox.getSelectedItem();
				Gerenciador g = new Gerenciador(txt, campoSelecionado);
				
				if(txt.equals(""))
					JOptionPane.showMessageDialog(null, "A caixa de texto está em branco! \nDigite o nome do arquivo\n e tente novamente.", "Caixa de texto vazia", JOptionPane.ERROR_MESSAGE);
				else {
					
					if(g.verificaSeExiste()) {
						JOptionPane.showMessageDialog(null, "Arquivo encontrado.");
						TelaOpcoes t = new TelaOpcoes();
						frame.setVisible(false);
					}else {
						Object[] options = {"SIM", "NÃO"};
				         
		                int resp = JOptionPane.showOptionDialog(null,"O arquivo não existe. Você deseja criar um novo?", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,  null, options, options[0]);
		                if(resp== 0){
		                		if(g.criarArquivo()) {
		                			JOptionPane.showMessageDialog(null, "O arquivo foi criado com sucesso!");
		                			TelaOpcoes t = new TelaOpcoes();
		                			frame.setVisible(false);
		                		} else {
		                			JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo. Verifique o terminal.", "Erro ao criar o arquivo", JOptionPane.ERROR_MESSAGE);
		                		}
		                     }
					}
				}
			}
		});
		btnBuscar.setBounds(167, 210, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JLabel txtNomeArquivo = new JLabel("Nome do arquivo:");
		txtNomeArquivo.setBounds(21, 64, 134, 14);
		frame.getContentPane().add(txtNomeArquivo);
		
		frame.setVisible(true);
		
		
	}
}
