package com.pvmeira.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pvmeira.cobranca.model.StatusTitulo;
import com.pvmeira.cobranca.model.Titulo;
import com.pvmeira.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	@Autowired
	Titulos titulos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView Salvar(Titulo titulo) {
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Titulo Salvo com sucesso");
		return mv;
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
}