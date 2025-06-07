package br.edu.unifametro.myproj.v1.produtos.exception;

import br.edu.unifametro.myproj.exception.NegocioGlobalException;

public class ProdutoInvalidoException extends NegocioGlobalException {

	private static final long serialVersionUID = 1L;

	public ProdutoInvalidoException() {
	}

	public ProdutoInvalidoException(String message) {
		super(message);
	}

	public ProdutoInvalidoException(Throwable cause) {
		super(cause);
	}

	public ProdutoInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProdutoInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
