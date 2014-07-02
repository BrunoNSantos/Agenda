/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.ContatoDAO;
import entidades.contato.Contato;
import fachada.FachadaSistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class GerenciadorContatos {
    private ContatoDAO contatoDAO = new ContatoDAO();
    
    public List<Contato> buscarContatoPorNome(String nomeBusca){
        List<Contato> contatosEncontrados = new ArrayList<Contato>();
        List<Contato> contatosBusca = contatoDAO.listarContatos();
        for (Contato contato : contatosBusca) {
            if(contato.getNome().toLowerCase().contains(nomeBusca.toLowerCase())){
                contatosEncontrados.add(contato);
            }
        }
        return contatosEncontrados;
    }
    
    public void excluirContatoPorNome(String nomeContatoExcluir){
        List<Contato> contatosBusca = FachadaSistema.getInstance().listarContatos();
        
        for (Contato contato : contatosBusca) {
            if(contato.getNome().equals(nomeContatoExcluir)){
                contatoDAO.excluir(contato);
            }
        }
    }

    public Contato buscarContatoSelecionadoPorNome(String nomeContato) {
        List<Contato> contatosBusca = FachadaSistema.getInstance().listarContatos();
        Contato contatoRetorno = new Contato();
        
        for (Contato contato : contatosBusca) {
            if(contato.getNome().equals(nomeContato)){
                contatoRetorno = contato;
            }
        }
        return contatoRetorno;
    }
    
}
