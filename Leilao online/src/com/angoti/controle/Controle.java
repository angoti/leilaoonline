package com.angoti.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angoti.semdefinicao.Acao;
import com.angoti.semdefinicao.Acoes;
import com.angoti.semdefinicao.ItensDoLeilao;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Encaminha a requisição do cliente para a ação correspondente
		String view;
		String acao = request.getParameter("acao");
		if (acao != null) {
			Acao requisicaoDoCliente = Acoes.acoes.get(acao);
			view = requisicaoDoCliente.executa(request);
		} else {//requisição sem ação
			ItensDoLeilao carregaItens = new ItensDoLeilao();
			view = carregaItens.carregaItensDoLeilao(request);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
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
