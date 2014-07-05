/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apresentacao;

import entidades.contato.Contato;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class Validacoes {

    public Validacoes() {
    }

    
    
    public boolean validarContato(Contato contato){
       List<Contato> listaContatos = fachada.FachadaSistema.getInstance().listarContatos();
       
        for (Contato contatoBusca : listaContatos) {
            if(contatoBusca.getNome().equals(contato.getNome())){
                JOptionPane.showMessageDialog(null, "Já existe um contato com o nome: " + contato.getNome()); 
                return false;                
            }
        }
        
       if(contato.getNome().isEmpty()){
           JOptionPane.showMessageDialog(null, "O campo nome deve ser preenchido"); 
           return false;
       } 
       if(contato.getTelefone1() == 0){
           JOptionPane.showMessageDialog(null, "O campo telefone 1 deve ser preenchido");
           return false;
       }
       
//       if(!soContemNumeros(String.valueOf(contato.getTelefone1()))){
//           JOptionPane.showMessageDialog(null, "O campo telefone 1 deve ser preenchido apenas com numeros");
//           return false;          
//       }
//       
//       if(!soContemNumeros(String.valueOf(contato.getTelefone3()))){
//           JOptionPane.showMessageDialog(null, "O campo telefone 3 deve ser preenchido apenas com numeros");
//           return false;          
//       }
//              
//       if(!soContemNumeros(String.valueOf(contato.getTelefone2()))){
//           JOptionPane.showMessageDialog(null, "O campo telefone 2 deve ser preenchido apenas com numeros");
//           return false;          
//       }       
       
       if(String.valueOf(contato.getTelefone1()).length() > 9){
           JOptionPane.showMessageDialog(null, "O telefone de conter no máximo 9 dígitos");
           return false;
       }
       if(String.valueOf(contato.getTelefone2()).length() > 9){
           JOptionPane.showMessageDialog(null, "O telefone de conter no máximo 9 dígitos");
           return false;
       }
       if(String.valueOf(contato.getTelefone3()).length() > 9){
           JOptionPane.showMessageDialog(null, "O telefone de conter no máximo 9 dígitos");
           return false;
       }
       if(!contato.getEmail().isEmpty()){
            if(!contato.getEmail().contains("@")){
                JOptionPane.showMessageDialog(null, "Este não é um email válido");
                return false;
            }
       }

       return true;
    }
    
    public  boolean soContemNumeros(String texto) {    
        return texto.matches("[0-9]");  
    }  
    
}
