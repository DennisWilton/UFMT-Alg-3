package app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import ui.Principal;

public class Relatorio {
	public static ArrayList<String> mensagens = new ArrayList<String>();
	public static Principal principal;
	
	public static void inicializa(Principal _principal) {
		principal = _principal;
	}
	
	public static void adicionaMensagem(String mensagem) {
		LocalDateTime momento = LocalDateTime.now();
		mensagens.add(0, String.format("%02d:%02d:%02d", momento.getHour(), momento.getMinute(), momento.getSecond()) + ": " + mensagem);
		principal.setStatusConexao(true, String.join("\n", mensagens));
	}
	

	public static void adicionaErro(String mensagem) {
		LocalDateTime momento = LocalDateTime.now();
		mensagens.add(0, String.format("%02d:%02d:%02d", momento.getHour(), momento.getMinute(), momento.getSecond()) + ": " + mensagem);
		principal.setStatusConexao(false, String.join("\n", mensagens));
	}
	
	public static void novaLinha() {
		mensagens.add(0, " ");
	}
	
	public static void limpa() {
		mensagens.clear();
	}
}
