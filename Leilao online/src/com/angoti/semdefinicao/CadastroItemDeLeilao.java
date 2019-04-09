package com.angoti.semdefinicao;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class CadastroItemDeLeilao extends Acao {
	
	public CadastroItemDeLeilao() {
		super();
	}

	@Override
	public String acao(HttpServletRequest request) {
		// recebe dados do cliente
		String nome = request.getParameter("nome");
		int valor = Integer.parseInt(request.getParameter("valorMinimo"));

		// salva no banco de dados
		try {
			PreparedStatement ps = con.getCon().prepareStatement("insert into item (nome, lance_minimo) values(?,?)");
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
		return "/index.jsp";
	}

}
