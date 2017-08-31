package br.com.fiap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqPrato", sequenceName="SQ_PRATO", allocationSize=1)
public class Prato {

	@Id
	@GeneratedValue(generator="seqPrato", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	private String nome;
	
	private double preco;
	
	private float peso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
}
