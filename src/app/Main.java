package app;

import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JLabel;

import ui.FrutaUI;
import ui.Principal;

public class Main {
	public static Principal principal;
	public static Fruta frutaAEditar;
	public static void main(String[] args) {
		principal = new Principal();
		Relatorio.inicializa(principal);
		try {
			Database.getConnection();
			if(Database.isConectado) Relatorio.adicionaMensagem("Conectado ao banco de dados com sucesso!");
		}catch(Throwable e) {
			principal.setStatusConexao(false, "Falha ao tentar conectar!\n" + e.getMessage());
			throw new RuntimeException(e);
		}
		
		Relatorio.adicionaMensagem("Carregando frutas..." );	
		carregaFrutas();
		ArrayList<Fruta> frutas = Fruta.getAll();
		frutas.forEach( fruta -> {
			Relatorio.adicionaMensagem(fruta.nome + " carregado(a) com sucesso!");
		});
	}
	
	public static void addFruta(Principal principal, Fruta fruta, int newlen) {
		FrutaUI frutaUi = new FrutaUI(fruta);
		frutaUi.setSize(principal.panel_1.getWidth(), 90);
		frutaUi.setVisible(true);
		principal.panel_1.add(frutaUi);
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.setRows(newlen);
	    principal.panel_1.setLayout(gridLayout);
		
		principal.atualizaTela();
		//Relatorio.adicionaMensagem(fruta.nome + " carregado(a) com sucesso!");
	}
	
	public static void carregaFrutas() {
		principal.panel_1.removeAll();
		//Relatorio.novaLinha();
		ArrayList<Fruta> frutas = Fruta.getAll();
		frutas.forEach( fruta -> {
			addFruta(principal, fruta, frutas.size());
		});
	}
}