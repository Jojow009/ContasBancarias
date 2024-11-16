package Enums;

public enum TpOperacao {
	
	toDiminuiSaldo('-'),
	toAumentaSaldo('+'),
	toNaoAlteraSaldo('=');
	
	private char valor;

	TpOperacao(char valor) {
		this.valor = valor;
	}
	
	public char getValue(char valor) {
		return this.valor = valor;
	}

}