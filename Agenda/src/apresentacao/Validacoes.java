/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apresentacao;

import entidades.contato.Contato;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class Validacoes {

    public Validacoes() {
    }

    
    
    public Contato validarContato(Contato contato){
       if(null == contato.getNome()){
           JOptionPane.showMessageDialog(null, "O campo nome deve ser preenchido"); 
       } 
       if(contato.getTelefone1() == 0){
           JOptionPane.showMessageDialog(null, "O campo telefone 1 deve ser preenchido"); 
       }
       if(null == contato.getEmail()){
           contato.setEmail("");
       }
       
       if(null == contato.getObservacoes()){
           contato.setObservacoes("");
       }
       
       return contato;
    }
    
}
