package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "SQ_T_FABRICANTE", name = "seqFab", allocationSize = 1)
public class Fabricante {

	@Id
	@GeneratedValue(generator = "seqFab", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "NM_FABRICANTE", nullable = false)
	private String nome;

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
}