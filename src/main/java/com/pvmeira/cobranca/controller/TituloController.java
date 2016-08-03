package com.pvmeira.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pvmeira.cobranca.model.Titulo;
import com.pvmeira.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	@Autowired
	Titulos titulos;

	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView Salvar(Titulo titulo) {
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Titulo Salvo com sucesso");
		return mv;
	}
}