package Utils;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Util {

    public static Image getIcone() {
        URL caminhoImagem = Util.class.getResource("/images/4394198_accessible_logo_logos_icon (1).png");

        ImageIcon icon = new ImageIcon(caminhoImagem);

        return icon.getImage();
    }

}
