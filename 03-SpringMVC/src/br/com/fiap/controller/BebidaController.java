package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dao.BebidaDAO;
import br.com.fiap.model.Bebida;

@Controller
@RequestMapping("/bebida")
public class BebidaController {
	
	@Autowired
	BebidaDAO dao;
	
	@GetMapping("cadastrar")
	public String abrirForm() {
		return "bebida/cadastro";
	}

	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView processarForm(Bebida bebida) {
		dao.cadastrar(bebida);
		ModelAndView retorno = new ModelAndView("bebida/sucesso");
		retorno.addObject("p", bebida);
		return retorno;
	}

	// Nova ação para listar...
	@GetMapping("listar")
	public ModelAndView listagem() {
		ModelAndView retorno = new ModelAndView("bebida/lista");
		retorno.addObject("lista", dao.listar());
		return retorno;
	}
}