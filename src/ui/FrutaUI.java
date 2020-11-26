package ui;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.SwingConstants;

import app.Fruta;
import app.Main;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrutaUI extends JPanel {
	
	public JLabel lblFrutaNome;
	
	/**
	 * Create the panel.
	 */
	public FrutaUI(Fruta fruta) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 30, 5, 30));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblQuantidade = new JLabel("Quantidade: " + fruta.quantidade);
		panel.add(lblQuantidade);
		
		JLabel lblSabor = new JLabel("Sabor " + fruta.sabor);
		lblSabor.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblSabor);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o: " + fruta.preco);
		lblPreo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblPreo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.GRAY);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		lblFrutaNome = new JLabel(fruta.nome + " " + fruta.cor);
		panel_3.add(lblFrutaNome);
		lblFrutaNome.setForeground(Color.WHITE);
		lblFrutaNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblFrutaNome.setBackground(Color.WHITE);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.frutaAEditar = fruta;
				FrutaUpdateUI.main(null);
			}
		});
		panel_2.add(btnEditar);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fruta.remove();
				Main.carregaFrutas();
			}
		});
		panel_2.add(btnNewButton);

	}
}
