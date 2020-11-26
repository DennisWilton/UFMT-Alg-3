package ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Principal {

	private JFrame frmTrabalhoFinal;
	private JTextArea lblConnectionStatus;
	public JPanel panel_1;
	private final Action action = new SwingAction();

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		frmTrabalhoFinal.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmTrabalhoFinal = new JFrame();
		frmTrabalhoFinal.setTitle("Trabalho final - Algoritmos III - FRUTARIA");
		frmTrabalhoFinal.setBounds(100, 100, 659, 683);
		frmTrabalhoFinal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmTrabalhoFinal.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Adicionar nova fruta");
		mntmNewMenuItem.setAction(action);
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cancelar");
		mnNewMenu.add(mntmNewMenuItem_1);

		JPanel panel = new JPanel();
		frmTrabalhoFinal.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Status da conex\u00E3o com o banco de dados:");
		lblNewLabel.setBounds(10, 471, 623, 14);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_1.setBounds(10, 82, 623, 378);
		panel.add(panel_1);
		
		JScrollPane panelScroll = new JScrollPane(panel_1);
		panel_1.setLayout(new GridLayout(500, 0, 0, 0));
		panelScroll.setBounds(panel_1.getBounds());
		panel.add(panelScroll);
		
		lblConnectionStatus = new JTextArea();
		lblConnectionStatus.setLineWrap(true);
		lblConnectionStatus.setBounds(10, 492, 623, 119);
		lblConnectionStatus.setEditable(false);
		lblConnectionStatus.setForeground(new Color(250,0,0));
		lblConnectionStatus.setBackground(Color.WHITE);
		lblConnectionStatus.setBorder(new EmptyBorder(10,10,10,10));
		panel.add(lblConnectionStatus);
		
		JScrollPane panelScroll2 = new JScrollPane(lblConnectionStatus);
		panel_1.setLayout(new GridLayout(500, 0, 0, 0));
		panelScroll2.setBounds(lblConnectionStatus.getBounds());
		panel.add(panelScroll2);
		
		JLabel lblNewLabel_1 = new JLabel("Denis Wilton de Paula Azevedo (RA 201811316060)\r TRABALHO FINAL - ALG III");
		lblNewLabel_1.setBounds(10, 11, 623, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Frutaria");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 57, 623, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Delfio (RA 201811316060)\r TRABALHO FINAL - ALG III");
		lblNewLabel_3.setBounds(10, 31, 623, 29);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
	
	public void setStatusConexao(Boolean success, String status) {
		lblConnectionStatus.setText(status);
		if(success) {
			lblConnectionStatus.setForeground(new Color(0,125,0));
		}
	}
	

	public String getStatusConexao() {
		return lblConnectionStatus.getText();
	}
	
	public void atualizaTela() {
		frmTrabalhoFinal.validate();
		frmTrabalhoFinal.repaint();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Adicionar nova fruta");
			putValue(SHORT_DESCRIPTION, "Adiciona uma nova fruta ao cadastro principal.");
		}
		public void actionPerformed(ActionEvent e) {
			FrutaNewUI.main(null);
		}
	}
}
