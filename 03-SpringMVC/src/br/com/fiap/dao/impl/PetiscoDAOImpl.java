package br.com.fiap.dao.impl;

import br.com.fiap.model.Petisco;
import org.springframework.stereotype.Repository;
import br.com.fiap.dao.PetiscoDAO;

@Repository
public class PetiscoDAOImpl 
				extends GenericDAOImpl<Petisco, Integer>
									implements PetiscoDAO{

}
