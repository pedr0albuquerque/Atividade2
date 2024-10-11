/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        try{
            String sql = "INSERT INTO produtos(nome,valor,status) VALUES (?,?,?)";
            
            conn = new conectaDAO().connectDB();
            
            prep = conn.prepareStatement(sql);
            prep.setString(1,produto.getNome());
            prep.setInt(2,produto.getValor());
            prep.setString(3,produto.getStatus());
            
            int rowsInserted = prep.executeUpdate();
            
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null,"Dados inseridos com sucesso!");
            }
        }catch(SQLException ex){
            ex.getMessage();
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        try{
            String sql = "SELECT * FROM produtos";
            
            conn = new conectaDAO().connectDB();
            Statement stmt = conn.createStatement();
            
            resultset = stmt.executeQuery(sql);
            
            while(resultset.next()){
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setValor(resultset.getInt("valor"));
                produto.setNome(resultset.getString("nome"));
                produto.setStatus(resultset.getString("status"));
                
                listagem.add(produto);
            }
                    
        }catch(SQLException ex){
            ex.getMessage();
        }
        
        
        
        return listagem;
    }   
}

