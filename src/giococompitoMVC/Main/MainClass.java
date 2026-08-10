package giococompitoMVC.Main;
import giococompitoMVC.vc.MainGameVC;
/**
 *
 * @author Vittorio Privitera
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MainGameVC mg=new MainGameVC();
       mg.setVisible(true);
       mg.setLocationRelativeTo(null);
    }
    
}
