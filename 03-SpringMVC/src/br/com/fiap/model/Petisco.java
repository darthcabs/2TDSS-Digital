package br.com.fiap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="seqPet",sequenceName="SQ_PETISCO",allocationSize=1)
public class Petisco {

	@Id
	@GeneratedValue(generator="seqPet",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotBlank
	private String nome;
	
	@DecimalMin("0")
	private double valor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
