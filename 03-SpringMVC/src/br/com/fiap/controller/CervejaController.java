package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.CervejaDAO;
import br.com.fiap.dao.FabricanteDAO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.model.Cerveja;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {
	
	@Autowired //Injeção de dependencia
	private CervejaDAO dao;
	
	@Autowired
	private FabricanteDAO fDao;
	
	@Transactional
	@PostMapping("excluir")
	public ModelAndView remover(int codigo,
				RedirectAttributes redirect){
		try {
			dao.remover(codigo);
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		redirect.addFlashAttribute("msg", "Excluido");
		ModelAndView retorno = 
			new ModelAndView("redirect:/cerveja/listar");
		return retorno;
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView editar(Cerveja cerveja,
			RedirectAttributes redirect){
		dao.alterar(cerveja);
		ModelAndView retorno = 
			new ModelAndView("redirect:/cerveja/listar");
		redirect.addFlashAttribute("msg", "Atualizado");
		return retorno;
	}

	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(
			@PathVariable("id") int id){
		Cerveja cerveja = dao.pesquisar(id);
		ModelAndView retorno = 
				new ModelAndView("cerveja/edicao");
		retorno.addObject("cerveja",cerveja);
		return retorno;
	}
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm(){
		return new ModelAndView("cerveja/cadastro")
						.addObject("cerveja", new Cerveja());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(@Valid Cerveja cerveja,
			BindingResult result,
			RedirectAttributes redirect){
		
		if (result.hasErrors()){
			return new ModelAndView("cerveja/cadastro");
		}else{
			dao.cadastrar(cerveja);
			ModelAndView retorno = new ModelAndView("redirect:/cerveja/listar");
			
			redirect.addFlashAttribute("msg", "Cadastrado!");
			return retorno;
		}
	}
	
	@GetMapping("listar")
	public ModelAndView listagem(){
		ModelAndView retorno = 
				new ModelAndView("cerveja/lista");
		retorno.addObject("lista",dao.listar());
		retorno.addObject("fabricantes", fDao.listar());
		return retorno;
	}
}