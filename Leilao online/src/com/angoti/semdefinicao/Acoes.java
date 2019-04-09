package com.angoti.semdefinicao;

import java.util.HashMap;
import java.util.Map;

public class Acoes {

	public static Map<String, Acao> acoes;
	
	static {
	    acoes = new HashMap<String, Acao>();
	    acoes.put("cadastrar", new CadastroItemDeLeilao());
	    acoes.put("abrir_leilao", new AbreLeilao());
	    acoes.put("encerrar_leilao", new FechaLeilao());
	}

}
