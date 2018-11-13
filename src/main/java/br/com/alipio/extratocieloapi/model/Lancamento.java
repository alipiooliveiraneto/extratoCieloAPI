package br.com.alipio.extratocieloapi.model;

public class Lancamento {
	private String id;
	private String dataLancamento;
	private String descricao;
	private String numero;
	private String situacao;
	private String dataConfirmacao;
	private String nomeBanco;
	private String numAgencia;
	private String numContaCorrente;
	private String valorFinal;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(String dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}
	public String getNumContaCorrente() {
		return numContaCorrente;
	}
	public void setNumContaCorrente(String numContaCorrente) {
		this.numContaCorrente = numContaCorrente;
	}
	public String getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}
	

}
