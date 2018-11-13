package br.com.alipio.extratocieloapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import br.com.alipio.extratocieloapi.model.Lancamento;

@Repository
public class LancamentoRepository {
	
	private List<Lancamento> todosLancamentos;
	
    @SuppressWarnings("deprecation")
	@Autowired
    public LancamentoRepository(ResourceLoader resourceLoader) {

		todosLancamentos = new ArrayList<Lancamento>();
		JSONParser parser = new JSONParser();
		 
        try {

        	Resource res = resourceLoader.getResource("classpath:lancamento-conta-legado.json"); 
        	String text = IOUtils.toString(res.getInputStream());
            Object obj = parser.parse(text);
            
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray listaControleLancamento = (JSONArray) jsonObject.get("listaControleLancamento");
            
            for (Object controleLancamento : listaControleLancamento){
            	Lancamento lancamento = new Lancamento();
            	lancamento.setId(((JSONObject)controleLancamento).get("codigoIdentificadorUnico").toString().trim());
            	lancamento.setDataLancamento(((JSONObject)controleLancamento).get("dataLancamentoContaCorrenteCliente").toString().trim());
            	lancamento.setDescricao(((JSONObject)controleLancamento).get("descricaoGrupoPagamento").toString().trim());
            	lancamento.setNumero(((JSONObject)controleLancamento).get("numeroEvento").toString().trim());
            	lancamento.setDataConfirmacao(((JSONObject)controleLancamento).get("dataEfetivaLancamento").toString().trim());
            	lancamento.setNomeBanco(((JSONObject)controleLancamento).get("nomeBanco").toString().trim());
            	lancamento.setValorFinal(((JSONObject)controleLancamento).get("valorLancamentoRemessa").toString().trim());

            	JSONObject lancamentoContaCorrenteCliente = (JSONObject)((JSONObject)controleLancamento).get("lancamentoContaCorrenteCliente");
            	lancamento.setSituacao(lancamentoContaCorrenteCliente.get("nomeSituacaoRemessa").toString().trim());       	
            	
            	JSONObject dadosDomicilioBancario = (JSONObject)lancamentoContaCorrenteCliente.get("dadosDomicilioBancario");
            	lancamento.setNumAgencia(dadosDomicilioBancario.get("numeroAgencia").toString().trim());
            	lancamento.setNumContaCorrente(dadosDomicilioBancario.get("numeroContaCorrente").toString().trim());      
            	
            	todosLancamentos.add(lancamento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public List<Lancamento> findAll(){
		return todosLancamentos;
	}
	
	public Lancamento findByID(String id){
		for (Lancamento lanc : todosLancamentos){
			if(lanc.getId().equals(id)){
				return lanc;
			}
		}
		return null;
	}
}
