
package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
// Import model.Usuario;
// import utils.Utils;
/**
*
* @author iband
*/

public class UsuarioController {
    
public boolean autenticar(String usuario, String senha){
    // montar o comando a ser executado
    //os ? sao variaveis que sao preenchidas mais adiante
    String sql = "SELECT * from TBUSUARIO " + 
            " WHERE email = ? and senha = ? " + 
            " and ativo = true";
    
    // Crie uma instancia do gerenciador de conexao
    // conexao com o banco de dados
    
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    
    //declara as variaveis como nulas antes do try
    //para poder usar o finally
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    try{
        // prepara o sql, analisando o formato e as variaveis
        comando = gerenciador.prepararComando(sql);
       
        
        // define o valor de cada variavel(?) pela posicao em que aparece no sql
        comando.setString(1, usuario);
        comando.setString(2, senha);
        
        //executa o comando e guarda o resultado da consulta
        // o resultado e semelhante a uma grade
        resultado = comando.executeQuery();
        
        // resultado.next() tenta avancar para a proxima linha
        // caso consiga retorna true
        if(resultado.next()){
            // se conseguir avancar para a proxima linha e porque acha um usuario
            return true;
        }
        
    } catch (SQLException e) {
        // caso ocorra um erro relacionado ao banco de dados
        // exibe popup com o erro
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    
    finally {
        //depois de executar o try, dando erro ou nao executa o finally
        gerenciador.fecharConexao(comando, resultado);
    }
    return false;
    
}    
}
