package com.artcomsoft.sistemaloja.models.validacao;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.artcomsoft.sistemaloja.models.Funcao;

public class ValidarFuncao implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Funcao.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"descricao", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"criador", "field.required");
		Funcao funcao = (Funcao) target;

	}



}
