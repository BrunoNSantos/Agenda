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

/**
 *
 * @author Bruno
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato();
        contato.setNome("Humberto");
        contato.setTelefone1(88321232);
        //ContatoDAO contatoDAO = new ContatoDAO();
        //contatoDAO.adicionar(contato);
        
        FachadaSistema.getInstance().adicionarContato(contato);
        System.out.println("Adicionado");
    }
    
}
