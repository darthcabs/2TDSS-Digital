package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.dao.CervejaDAO;
import br.com.fiap.model.Cerveja;

@Repository
public class CervejaDAOImpl 
				extends GenericDAOImpl<Cerveja, Integer>
										implements CervejaDAO{

}