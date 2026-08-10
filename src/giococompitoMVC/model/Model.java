package giococompitoMVC.model;
//import giococompitoMVC.vc.MainGameVC;
import java.util.Random;
/**
 *
 * @author Vittorio Privitera
 */
public class Model {
    private boolean inGioco;
    private int punti;
    private int round;
    private String sceltaUte; //pari=true e dispari false
    private String coloreUte; // 0 rosso 1 verde 2 blu
    private int sceltaPc;
    private String sceltaPc2;
    private String colorePC; // 0 rosso 1 verde 2 blu
    private final String coloriAmmessi[]={"Rosso","Verde","Blu"};
    
    public Model()
    {
        reset();
    }
    
    private void reset()
    {
        this.inGioco=true;
        this.sceltaUte="";
        this.punti=this.round=0;
        this.coloreUte="";
        this.sceltaPc=0;
        this.colorePC="";
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

    public String isSceltaUte() {
        return sceltaUte;
    }

    public String getColoreUte() {
        return coloreUte;
    }

    public int isSceltaPc() {
        return sceltaPc;
    }

    public String getColorePC() {
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
        this.coloreUte=colore;
        
        if(pariOdisp.equalsIgnoreCase("pari")) this.sceltaUte="pari";
        else if(pariOdisp.equalsIgnoreCase("dispari")) this.sceltaUte="dispari";
        else this.sceltaUte="pari";
        try
        {
            int r=Integer.parseInt(round);
            if(r>=1) this.round=r;
            else this.round=1;
        }
        catch(Exception e)
        {
            
        }
        this.inGioco=true;
        return true;
    }
    /**
     * fa un round
     * @return 
     * -9 se non siamo in gioco
     * -8 se i round sono finiti
     * 
     */
    public int gioco()
    {
       if(this.inGioco==false) return -9;
       if(this.round==0) return -8;
       this.round--;
       Random r=new Random();
       this.sceltaPc=r.nextInt(4)+1;
       if(sceltaPc==1||sceltaPc==3) this.sceltaPc2="dispari";
       else this.sceltaPc2="pari";
       int ind=r.nextInt(3);
       this.colorePC=coloriAmmessi[ind];
       if((this.colorePC!=this.coloreUte)&&(this.sceltaUte!=this.sceltaPc2)) 
       {
           return 0;
       }
       else if((this.colorePC!=this.coloreUte)&&(this.sceltaUte==this.sceltaPc2))
       {
           this.punti+=2;
           return 2;
       }
       else if((this.colorePC==this.coloreUte)&&(this.sceltaUte!=this.sceltaPc2))
       {
           this.punti+=5;
           return 5;
       }
       else 
       {
           this.punti+=10;
           return 10;   
       }
    }
    public static void main(String[] args)
    {
        //MainGameVC mg=new MainGameVC();
        Model model=new Model();
        System.out.println(model.toString());
        System.out.println(model.iniziaPartita("rosso","pari","4"));
        System.out.println(model.toString());
        System.out.println(model.gioco());
        System.out.println(model.toString());
        System.out.println(model.gioco());
        System.out.println(model.toString());
        System.out.println(model.gioco());
        System.out.println(model.toString());
        System.out.println(model.gioco());
        System.out.println(model.toString());
                
    }
}
