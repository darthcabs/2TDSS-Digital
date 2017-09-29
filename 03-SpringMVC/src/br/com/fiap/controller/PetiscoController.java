package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.PetiscoDAO;
import br.com.fiap.model.Petisco;

@Controller
@RequestMapping("/petisco")
public class PetiscoController {

	@Autowired
	private PetiscoDAO dao;
	
	@GetMapping("listar")
	public ModelAndView listagem(){
		ModelAndView retorno = new ModelAndView("petisco/lista");
		retorno.addObject("lista",dao.listar());
		return retorno;
	}
	
	@GetMapping("cadastrar")
	public  ModelAndView abrirForm(){
		return new ModelAndView("petisco/cadastro")
					.addObject("petisco", new Petisco());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processaForm(@Valid Petisco petisco,
			BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()){
			return new ModelAndView("petisco/cadastro");
		}else{
			dao.cadastrar(petisco);
			ModelAndView retorno = 
					new ModelAndView("redirect:/petisco/listar");
			redirect.addFlashAttribute("msg", "Cadastrado");
			return retorno;
		}
	}
	
}






