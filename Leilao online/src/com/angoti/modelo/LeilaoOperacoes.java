package com.angoti.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class LeilaoOperacoes {

	public void encerraLeilao(HttpServletRequest request) {
		// recebe dados do cliente
		int id_leilao = Integer.parseInt(request.getParameter("encerrar_leilao"));
	
		// altera status do leilão no banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao?useTimezone=true&serverTimezone=UTC", "root", "");
			PreparedStatement ps = con.prepareStatement("UPDATE item SET status = '0' WHERE item.id = ?");
			ps.setInt(1, id_leilao);
			int i = ps.executeUpdate();
			if (i > 0) {
				request.setAttribute("msg", "Leilão encerrado!");
			}
		} catch (Exception e2) {
			System.out.println(e2);
			request.setAttribute("msg", e2.getMessage());
		}
	}

	public void abreLeilao(HttpServletRequest request) {
		// recebe dados do cliente
		int id_leilao = Integer.parseInt(request.getParameter("abrir_leilao"));
	
		// altera status do leilão no banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao?useTimezone=true&serverTimezone=UTC", "root", "");
			PreparedStatement ps = con.prepareStatement("UPDATE item SET status = '1' WHERE item.id = ?");
			ps.setInt(1, id_leilao);
			int i = ps.executeUpdate();
			if (i > 0) {
				request.setAttribute("msg", "Leilão aberto!");
			}
		} catch (Exception e2) {
			System.out.println(e2);
			request.setAttribute("msg", e2.getMessage());
		}
	}

	public void cadastro(HttpServletRequest request) {
		// recebe dados do cliente
		String nome = request.getParameter("nome");
		int valor = Integer.parseInt(request.getParameter("valorMinimo"));
	
		// salva no banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao?useTimezone=true&serverTimezone=UTC", "root", "");
			PreparedStatement ps = con.prepareStatement("insert into item (nome, lance_minimo) values(?,?)");
			ps.setInt(2, valor);
			ps.setString(1, nome);
			int i = ps.executeUpdate();
			if (i > 0) {
				request.setAttribute("msg", "Dados cadastrados com sucesso!");
			}
		} catch (Exception e2) {
			System.out.println(e2);
			request.setAttribute("msg", e2.getMessage());
		}
	}
	
	public void carregaObjetos(HttpServletRequest request) {
		// carregar objetos do banco de dados
		try {
			List<Leilao> lista = new ArrayList<Leilao>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leilao?useTimezone=true&serverTimezone=UTC", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from item");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				String nome = result.getString("nome");
				boolean status = result.getBoolean("status");
				float valorMinimo = result.getFloat("lance_minimo");
				int id = result.getInt("id");
				Leilao leilao = new Leilao(nome, valorMinimo, status, id);
				lista.add(leilao);
			}
			request.setAttribute("lista", lista);
		} catch (Exception e2) {
			System.out.println(e2);
			request.setAttribute("msg", e2.getMessage());
		}
	}

}
