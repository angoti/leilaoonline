package com.angoti.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angoti.modelo.LeilaoOperacoes;

/**
 * Servlet implementation class Controle
 */
@WebServlet(urlPatterns = { "/Controle", "" })
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LeilaoOperacoes operacao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controle() {
		super();
		operacao = new LeilaoOperacoes();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// comando cadastrar
		if (request.getParameter("acao") != null && request.getParameter("acao").equals("cadastrar")) {
			operacao.cadastro(request);
		} else if (request.getParameter("acao") != null && request.getParameter("acao").equals("abrir_leilao")) {// comando abrir leilão
			operacao.abreLeilao(request);
		} else if (request.getParameter("acao") != null && request.getParameter("acao").equals("encerrar_leilao")) {
			operacao.encerraLeilao(request);
		}
		operacao.carregaObjetos(request);

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
