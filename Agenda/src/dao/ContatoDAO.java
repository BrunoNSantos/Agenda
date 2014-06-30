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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
   
    public void alterar(Contato contato) {
        
    StringBuilder query =new StringBuilder();
    query.append("UPDATE contato");
    query.append(" SET nome=?, tel_1=?, tel_2=?, tel_3=?, email=?, observacoes=?");
    query.append(" WHERE id=?;");   

     try {
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
         stmt.setInt(++i,contato.getId());
         
         //executa
         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
    }
    
    public void excluir(Contato contato) {
     try {
         PreparedStatement stmt = conexao.prepareStatement("delete from contato where id=?");
         stmt.setInt(1, contato.getId());
         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
    }
    
    public List<Contato> listarContatos() {
     try {
         List<Contato> contatos = new ArrayList<Contato>();
         PreparedStatement stmt = this.conexao.prepareStatement("select * from contato");
         ResultSet rs = stmt.executeQuery();
 
         while (rs.next()) {
             // criando o objeto Contato
             Contato contato = new Contato();
             contato.setId(rs.getInt("id"));
             contato.setNome(rs.getString("nome"));
             contato.setTelefone1(rs.getInt("tel_1"));
             contato.setTelefone2(rs.getInt("tel_2"));
             contato.setTelefone3(rs.getInt("tel_3"));
             contato.setEmail(rs.getString("email"));
             contato.setObservacoes(rs.getString("observacoes"));
 
             // adicionando o objeto à lista
             contatos.add(contato);
         }
         rs.close();
         stmt.close();
         return contatos;
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
    
}
