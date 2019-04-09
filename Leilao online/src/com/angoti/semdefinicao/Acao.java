package com.angoti.semdefinicao;

import javax.servlet.http.HttpServletRequest;

import com.angoti.util.ConexaoBancoDeDados;

public abstract class Acao {
	protected ConexaoBancoDeDados con;
	private ItensDoLeilao itensDoLeilao;

	public Acao() {
		super();
		con = new ConexaoBancoDeDados();
		itensDoLeilao = new ItensDoLeilao();
	}

	public abstract String acao(HttpServletRequest request);

	public String executa(HttpServletRequest request) {
		String view = acao(request);
		itensDoLeilao.carregaItensDoLeilao(request);
		return view;
	}
}
