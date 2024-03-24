package Modelo;

import jplay.Scene;
import jplay.Window;

public class FaseInicial1 extends Fase { 
    
    public FaseInicial1(Window window, Personagem p) {
       
        setJanela(window);
        setCenario(new Scene());
        getCenario().loadFromFile("src\\sprites\\faseteste.scn");
        setPersonagem(p);
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        
    }
   
   public FaseInicial1(Window window, Personagem p, int x, int y) {
       
       setJanela(window);
       setCenario(new Scene());
       getCenario().loadFromFile("src\\sprites\\faseteste.scn");
       setPersonagem(p);
       getPersonagem().setX(x);
       getPersonagem().setY(y);
       setExecutando(true);
       getCenario().addOverlay(getPersonagem());
              
   }
   
    //Fase rodando:
    public void run() {
       
        while(isExecutando() == true) {
            
            getPersonagem().caminho(getCenario());
            getPersonagem().movimentar(getJanela());
      
            getCenario().moveScene(getPersonagem());
            
            getPersonagem().draw();
            getJanela().update();
           
            mudarCenario();
           
        }
       
    }
    
   private void mudarCenario() {
       
       if(colisaoTile(5, getPersonagem(), getCenario()) == true) {
           setExecutando(false);
       }
       
   }
    
}
