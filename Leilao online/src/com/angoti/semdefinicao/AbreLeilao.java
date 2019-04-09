package com.angoti.semdefinicao;

import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AbreLeilao extends Acao {

	@Override
	public String acao(HttpServletRequest request) {
		// recebe dados do cliente
		int id_leilao = Integer.parseInt(request.getParameter("abrir_leilao"));

		// altera status do leilão no banco de dados
		try {
			PreparedStatement ps = con.getCon().prepareStatement("UPDATE item SET status = '1' WHERE item.id = ?");
			ps.setInt(1, id_leilao);
			int i = ps.executeUpdate();
			if (i > 0) {
				request.setAttribute("msg", "Leilão aberto!");
			}
		} catch (Exception e2) {
			System.out.println(e2);
			request.setAttribute("msg", e2.getMessage());
		}

		return "/index.jsp";
	}

}
