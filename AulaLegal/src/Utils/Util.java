package Utils;

import java.awt.Image;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Util {

    public static Image getIcone() {
        URL caminhoImagem = Util.class.getResource("/images/4394198_accessible_logo_logos_icon (1).png");

        ImageIcon icon = new ImageIcon(caminhoImagem);

        return icon.getImage();
    }

    public static Date converterStringToDate(String texto) {
        // Construo o formato que quero transformar o texto
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        // Crio minha variavel data que sera o retorno do metodo
        Date data = null;

        try {
            // Tenta converter a String em Date baseado no formato
            // Construido anteriormente
            data = formato.parse(texto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");
        }
        // retorno a data convertida
        return data;
    }
    public static String calcularHash(String senha) {
        String hashSHA1= "";
        try{
        // crie uma instancia do MessageDigest
        // com o algoritmo SHA1
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        
        //Atualize o digest com os bytes do texto
        sha1.update(senha.getBytes());
        
        //calcule o hash SHA1
        byte[] digest = sha1.digest();
        
        // converta o hash de bytes para uma representacao hexadecimal
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        hashSHA1 = sb.toString();
        } catch (NoSuchAlgorithmException e){
            System.out.println("Algoritmo SHA1 nao encontrado");
        }
        return hashSHA1;
    }
}
