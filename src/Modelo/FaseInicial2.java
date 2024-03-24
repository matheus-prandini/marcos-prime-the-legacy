package Modelo;

import jplay.Scene;
import jplay.Window;

public class FaseInicial2 extends Fase { //Fase do Bar
    
    public FaseInicial2(Window window, Personagem p) {
       
        setJanela(window);
        setCenario(new Scene());
        getCenario().loadFromFile("src\\sprites\\faseinicial2.scn");
        setPersonagem(p);
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        
    }
   
   public FaseInicial2(Window window, Personagem p, int x, int y) {
       
       setJanela(window);
       setCenario(new Scene());
       getCenario().loadFromFile("src\\sprites\\faseinicial2.scn");
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
            //getPersonagem().atacar(getJanela(), getCenario(), getTeclado());
            
            getPersonagem().draw();
            getJanela().update();
           
            mudarCenario();
           
        }
       
    }
    
   private void mudarCenario() {
       
       if((getPersonagem().getX() >= 470 && getPersonagem().getX() <= 500) && getPersonagem().getY() == 0) {
           getPersonagem().setX(480);
           getPersonagem().setY(700);
           setExecutando(false);
       }
       
   }
    
}
