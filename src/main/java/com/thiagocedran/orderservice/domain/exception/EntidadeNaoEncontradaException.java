package com.thiagocedran.orderservice.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = -5362839322503953485L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}

}
