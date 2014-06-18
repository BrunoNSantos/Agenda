/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fachada;

import dao.ContatoDAO;
import entidades.contato.Contato;

/**
 *
 * @author Bruno
 */
public class FachadaSistema { 
    private static FachadaSistema fachada = new FachadaSistema();
    private ContatoDAO contatoDAO;

    private FachadaSistema() {
        this.contatoDAO = new ContatoDAO();
    }
    
    public static FachadaSistema getInstance() {  
        return fachada;  
    }  
    
    public void adicionarContato(Contato contato){
        this.contatoDAO.adicionar(contato);
    }
    
}
