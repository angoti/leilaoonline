package com.angoti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controle
 */
@WebServlet(urlPatterns = { "/Controle", "" })
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// comando cadastrar
		if (request.getParameter("command") != null && request.getParameter("command").equals("cadastrar")) {
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
		} else if (request.getParameter("command") != null && request.getParameter("command").equals("abrir_leilao")) {// comando abrir leilão
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
		} else if (request.getParameter("command") != null && request.getParameter("command").equals("encerrar_leilao")) {
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
					request.setAttribute("msg", "Leilão aberto!");
				}
			} catch (Exception e2) {
				System.out.println(e2);
				request.setAttribute("msg", e2.getMessage());
			}

		}
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
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
