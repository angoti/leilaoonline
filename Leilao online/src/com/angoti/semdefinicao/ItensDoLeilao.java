package com.angoti.semdefinicao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.angoti.modelo.Leilao;
import com.angoti.util.ConexaoBancoDeDados;

public class ItensDoLeilao {
	protected ConexaoBancoDeDados con;

	public ItensDoLeilao() {
		super();
		con = new ConexaoBancoDeDados();
	}
	public String carregaItensDoLeilao(HttpServletRequest request) {
		// carregar objetos do banco de dados
		try {
			List<Leilao> lista = new ArrayList<Leilao>();
			PreparedStatement ps = con.getCon().prepareStatement("select * from item");
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
		return "/index.jsp";
	}
}