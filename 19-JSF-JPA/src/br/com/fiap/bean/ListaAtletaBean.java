package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.AtletaBO;
import br.com.fiap.entity.Atleta;

@ManagedBean
public class ListaAtletaBean {
	private List<Atleta> atletas;
	private AtletaBO bo;

	@PostConstruct
	public void init(){
		bo = new AtletaBO();
		atletas = bo.listar();
	}
	
	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}
}
