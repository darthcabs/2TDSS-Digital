package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.AtletaBO;
import br.com.fiap.entity.Atleta;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

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
	
	public String deletar(int codigo){
		FacesMessage msg;
		try {
			bo.remover(codigo);
			msg = new FacesMessage("Atleta removido");
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			return "lista-atleta";
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
			return "lista-atleta";
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem após um redirect
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		return "lista-atleta?faces-redirect=true";
	}
}