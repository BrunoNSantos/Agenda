/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.Conexao;
import entidades.contato.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bruno
 */
public class ContatoDAO {
    
   private Connection conexao;
   
   public ContatoDAO() {
     this.conexao = new Conexao().getConexao();
   }
   
   public void adicionar(Contato contato) {
    StringBuilder query =new StringBuilder();
    query.append("INSERT INTO contato ");
    query.append(" (nome,tel_1,tel_2,tel_3,email,observacoes)");
    query.append(" VALUES(?,?,?,?,?,?);");

     try {
         // prepared statement para inserção
         PreparedStatement stmt = conexao.prepareStatement(query.toString());
 
         //indice
         int i = 0;
         
         // seta os valores
         stmt.setString(++i,contato.getNome());
         stmt.setInt(++i,contato.getTelefone1());
         stmt.setInt(++i,contato.getTelefone2());
         stmt.setInt(++i,contato.getTelefone3());
         stmt.setString(++i,contato.getEmail());
         stmt.setString(++i,contato.getObservacoes());
         
 
         // executa
         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
    
}
