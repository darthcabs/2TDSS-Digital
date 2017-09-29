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
import br.com.fiap.dao.FabricanteDAO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.model.Cerveja;
import br.com.fiap.model.Fabricante;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteDAO dao;

	@Transactional
	@PostMapping("excluir")
	public ModelAndView remover(int codigo, RedirectAttributes redirect) {
		try {
			dao.remover(codigo);
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		redirect.addFlashAttribute("msg", "Excluido");
		ModelAndView retorno = new ModelAndView("redirect:/fabricante/listar");
		return retorno;
	}

	@Transactional
	@PostMapping("editar")
	public ModelAndView editar(Fabricante fabricante, RedirectAttributes redirect) {
		dao.alterar(fabricante);
		ModelAndView retorno = new ModelAndView("redirect:/fabricante/listar");
		redirect.addFlashAttribute("msg", "Atualizado");
		return retorno;
	}

	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int id) {
		Fabricante fabricante = dao.pesquisar(id);
		ModelAndView retorno = new ModelAndView("fabricante/edicao");
		retorno.addObject("fabricante", fabricante);
		return retorno;
	}

	@GetMapping("cadastrar")
	public ModelAndView abrirForm() {
		return new ModelAndView("fabricante/cadastro").addObject("fabricante", new Fabricante());
	}

	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(@Valid Fabricante fabricante, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return new ModelAndView("fabricante/cadastro");
		} else {
			dao.cadastrar(fabricante);
			ModelAndView retorno = new ModelAndView("redirect:/fabricante/listar");

			redirect.addFlashAttribute("msg", "Cadastrado!");
			return retorno;
		}
	}

	@GetMapping("listar")
	public ModelAndView listagem() {
		ModelAndView retorno = new ModelAndView("fabricante/lista");
		retorno.addObject("lista", dao.listar());
		return retorno;
	}
}