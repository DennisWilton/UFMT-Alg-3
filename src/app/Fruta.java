package app;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

public class Fruta {
	public int id;
	public String nome;
	public String cor;
	public String sabor;
	public int quantidade;
	public double preco;
	
	public static Fruta load(int id) {
		try {
			String sql = "SELECT * FROM frutas f WHERE f.FrutaID = ?";
			Connection conn = Database.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet res = stmt.executeQuery();
			
			res.first();

			Fruta fruta = new Fruta();
			fruta.nome = res.getString("FrutaNome");
			fruta.cor = res.getString("FrutaCor");
			fruta.sabor = res.getString("FrutaSabor");
			fruta.quantidade = res.getInt("FrutaQuantidade");
			fruta.preco = res.getDouble("FrutaPreco");
			
			return fruta;
			
			
		}catch(Throwable e) {
			System.out.println("Erro ao buscar a fruta");
			System.out.println(e);
			return null;
		}
	}

	public static ArrayList<Fruta> getAll() {
		try {
			String sql = "SELECT * FROM frutas";
			Connection conn = Database.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet res = stmt.executeQuery();
			
			ArrayList<Fruta> frutas = new ArrayList<Fruta>();
			
			while(res.next()) {
				Fruta fruta = new Fruta();
				fruta.id = res.getInt("FrutaID");
				fruta.nome = res.getString("FrutaNome");
				fruta.cor = res.getString("FrutaCor");
				fruta.sabor = res.getString("FrutaSabor");
				fruta.quantidade = res.getInt("FrutaQuantidade");
				fruta.preco = res.getDouble("FrutaPreco");
				
				frutas.add(fruta);
			}
			
			return frutas;			
			
		}catch(Throwable e) {
			System.out.println("Erro ao buscar a fruta");
			System.out.println(e);
			return null;
		}
	}

	public boolean create() {
		try {
			if(this.nome.isEmpty() || this.cor.isEmpty() || this.sabor.isEmpty() || this.quantidade <= 0 || this.preco <= 0) throw new RuntimeException("Dados inválidos.");
			
			String sql = "INSERT INTO frutas VALUES (?, ?, ?, ?, ?, ?)";
			Connection conn = Database.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, 0);
			stmt.setString(2, this.nome);
			stmt.setString(3, this.cor);
			stmt.setString(4, this.sabor);
			stmt.setInt(5, this.quantidade);
			stmt.setDouble(6, this.preco);
			
			stmt.execute();
			Relatorio.adicionaMensagem(this.nome + " adicionado(a) com sucesso!");
			return stmt.getUpdateCount() > 0;
		} catch( Throwable e ) {
			throw new RuntimeException(e);
		}
	}

	public boolean remove() {
		try {
			String sql = "DELETE FROM frutas WHERE FrutaID = ?";
			Connection conn = Database.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, this.id);
			
			stmt.execute();
			boolean result = stmt.getUpdateCount() > 0;
			Relatorio.adicionaMensagem(this.nome + " removido(a) com sucesso!");
			return result;
		} catch( Throwable e ) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean update() {
		try {
			if(this.nome.isEmpty() || this.cor.isEmpty() || this.sabor.isEmpty() || this.quantidade <= 0 || this.preco <= 0) throw new RuntimeException("Dados inválidos.");
			
			String sql = "UPDATE frutas "
					+ "		 SET FrutaNome = ?, "
					+ "			 FrutaCor = ?,"
					+ "			 FrutaSabor = ?, "
					+ "			 FrutaQuantidade = ?, "
					+ "			 FrutaPreco = ? "
					+ "	   WHERE FrutaID = ?";
			Connection conn = Database.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, this.nome);
			stmt.setString(2, this.cor);
			stmt.setString(3, this.sabor);
			stmt.setInt(4, this.quantidade);
			stmt.setDouble(5, this.preco);
			stmt.setInt(6, this.id);
			
			stmt.execute();
			Relatorio.adicionaMensagem(this.nome + " editado(a) com sucesso!");
			return stmt.getUpdateCount() > 0;
		} catch( Throwable e ) {
			throw new RuntimeException(e);
		}
	}
	
}
