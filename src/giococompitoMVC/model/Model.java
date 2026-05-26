package giococompitoMVC.model;
import java.util.Random;
/**
 *
 * @author Vittorio Privitera
 */
public class Model {
     private boolean inGioco;
    private int punti;
    private int round;
    private boolean sceltaUte; //pari=true e dispari false
    private int coloreUte; // 0 rosso 1 verde 2 blu
    private int sceltaPc;
    private boolean sceltaPc2;
    private int colorePC; // 0 rosso 1 verde 2 blu
    private final String coloriAmmessi[]={"Rosso","Verde","Blu"};
    
    public Model()
    {
        reset();
    }
    
    private void reset()
    {
        this.inGioco=this.sceltaUte=false;
        this.punti=this.round=0;
        this.coloreUte=0;
        this.sceltaPc=0;
        this.colorePC=0;
    }

    public boolean isInGioco() {
        return inGioco;
    }

    public int getPunti() {
        return punti;
    }

    public int getRound() {
        return round;
    }

    public boolean isSceltaUte() {
        return sceltaUte;
    }

    public int getColoreUte() {
        return coloreUte;
    }

    public int isSceltaPc() {
        return sceltaPc;
    }

    public int getColorePC() {
        return colorePC;
    }

    @Override
    public String toString() {
        return "Model{" + "inGioco=" + inGioco + ", punti=" + punti + ", round=" + round + ", sceltaUte=" + sceltaUte + ", coloreUte=" + coloreUte + ", sceltaPc=" + sceltaPc + ", colorePC=" + colorePC + '}';
    }
    
    public boolean terminaPartita()
    {
        if(!this.inGioco)return false;
        this.inGioco=false;
        return true;
    }
    
    public boolean iniziaPartita(String colore, String pariOdisp, String round)
    {
        if(!this.inGioco) return false;
        reset();
        for(int i=0;i<this.coloriAmmessi.length;i++)
        {
            if(this.coloriAmmessi[i].equalsIgnoreCase(colore))
            {
                this.coloreUte=i;
                break;
            }
        }
        
        if(pariOdisp.equalsIgnoreCase("pari")) this.sceltaUte=true;
        else if(pariOdisp.equalsIgnoreCase("dispari")) this.sceltaUte=false;
        else this.sceltaUte=true;
        try
        {
            int r=Integer.parseInt(round);
            if(r>=1) this.round=r;
            else this.round=1;
        }
        catch(Exception e)
        {
            
        }
        return true;
    }
}
