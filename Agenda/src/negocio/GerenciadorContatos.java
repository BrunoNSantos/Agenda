/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dao.ContatoDAO;
import entidades.contato.Contato;
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
    
}
