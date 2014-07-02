/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fachada;

import apresentacao.Validacoes;
import dao.ContatoDAO;
import entidades.contato.Contato;
import java.util.List;
import negocio.GerenciadorContatos;

/**
 *
 * @author Bruno
 */
public class FachadaSistema { 
    private static FachadaSistema fachada = new FachadaSistema();
    private ContatoDAO contatoDAO;
    private GerenciadorContatos gerenciador;
    private Validacoes validacoes;

    private FachadaSistema() {
        this.contatoDAO = new ContatoDAO();
        this.gerenciador = new GerenciadorContatos();
        this.validacoes = new Validacoes();
    }
    
    public static FachadaSistema getInstance() {  
        return fachada;  
    }  
    
    public void adicionarContato(Contato contato){
        this.contatoDAO.adicionar(contato);
    }
    
    public void alterarContato(Contato contato){
        this.contatoDAO.alterar(contato);
    }
    
    public void excluirContato(Contato contato){
        this.contatoDAO.excluir(contato);
    }
    
    public List<Contato> listarContatos(){
        return this.contatoDAO.listarContatos();
    }
    
    public void excluirContatoPorNome(String nomeContatoExcluir){
        this.gerenciador.excluirContatoPorNome(nomeContatoExcluir);
    }

    public Contato buscarContatoSelecionadoPorNome(String nomeContato) {
        return this.gerenciador.buscarContatoSelecionadoPorNome(nomeContato);
    }
    
}
