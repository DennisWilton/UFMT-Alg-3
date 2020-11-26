package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import app.Fruta;
import app.Main;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;

public class FrutaUpdateUI {

	private JFrame frame;
	private JTextField txtFrutaNome;
	private JTextField txtFrutaCor;
	private JTextField txtFrutaSabor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrutaUpdateUI window = new FrutaUpdateUI();
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
	public FrutaUpdateUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Editar fruta");
		lblNewLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 30, 30, 30));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Nome da fruta:");
		panel_1.add(lblNewLabel_1);
		
		txtFrutaNome = new JTextField();
		txtFrutaNome.setText(Main.frutaAEditar.nome);
		panel_1.add(txtFrutaNome);
		txtFrutaNome.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Cor da fruta:");
		panel_1_1.add(lblNewLabel_1_1);
		
		txtFrutaCor = new JTextField();
		txtFrutaCor.setText(Main.frutaAEditar.cor);
		txtFrutaCor.setColumns(10);
		panel_1_1.add(txtFrutaCor);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1_3);
		panel_1_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1_3 = new JLabel("Sabor da fruta:");
		panel_1_3.add(lblNewLabel_1_3);
		
		txtFrutaSabor = new JTextField();
		txtFrutaSabor.setText(Main.frutaAEditar.sabor);
		txtFrutaSabor.setColumns(10);
		panel_1_3.add(txtFrutaSabor);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1_2);
		panel_1_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1_2 = new JLabel("Quantidade:");
		panel_1_2.add(lblNewLabel_1_2);
		
		JSpinner txtFrutaQuantidade = new JSpinner();
		txtFrutaQuantidade.setValue(Main.frutaAEditar.quantidade);
		panel_1_2.add(txtFrutaQuantidade);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1_4);
		panel_1_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1_4 = new JLabel("Pre\u00E7o:");
		panel_1_4.add(lblNewLabel_1_4);
		
		NumberFormat format = NumberFormat.getNumberInstance();
	    format.setGroupingUsed(false);

	    NumberFormatter numberFormatter = new NumberFormatter(format);
	    numberFormatter.setValueClass(Long.class); 
	    numberFormatter.setAllowsInvalid(true);
		
		JFormattedTextField txtFrutaPreco = new JFormattedTextField(numberFormatter);
		txtFrutaPreco.setText(String.valueOf(Main.frutaAEditar.preco));
		panel_1_4.add(txtFrutaPreco);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 2, 10, 0));
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Main.carregaFrutas();
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fruta fruta = new Fruta();
				try {
				fruta.id = Main.frutaAEditar.id;
				fruta.nome = txtFrutaNome.getText();
				fruta.cor = txtFrutaCor.getText();
				fruta.sabor = txtFrutaSabor.getText();
				fruta.quantidade = (int)txtFrutaQuantidade.getValue();
				fruta.preco = Double.parseDouble(txtFrutaPreco.getText());
				}catch(Throwable e) {
					
				}
				
				if(fruta.update()) {
					frame.dispose();
					Main.carregaFrutas();
				}else {
					throw new RuntimeException("Falha ao criar a fruta.");
				}
			}
		});
		panel_2.add(btnNewButton);
	}

}
