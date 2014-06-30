/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agenda;

import conexao.Conexao;
import dao.ContatoDAO;
import entidades.contato.Contato;
import fachada.FachadaSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import negocio.GerenciadorContatos;

/**
 *
 * @author Bruno
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        GerenciadorContatos gerenciadorContatos = new GerenciadorContatos();
        List<Contato> contatosEncontrados = gerenciadorContatos.buscarContatoPorNome("si");
        System.out.println(contatosEncontrados.size());
        
    }    
    
}
