package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.DescontoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoParaEstudantes;
import br.com.caelum.ingresso.model.descontos.Descontos;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

public enum TipoDeIngresso {

	INTEIRO(new SemDesconto()),
	ESTUDANTE(new DescontoParaEstudantes()),
	BANCO(new DescontoParaBancos());
	
	
	private final Descontos desconto;
	
	TipoDeIngresso(Descontos desconto)
	{
		this.desconto = desconto;
	}
	
	public BigDecimal aplicaDesconto(BigDecimal valor)
	{
		return desconto.aplicarDescontoSobre(valor);
	}
	
	
	public String getDescricao(){
		
		return desconto.getDescricao();
	}
	
}
