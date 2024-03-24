package Modelo;

import java.util.ArrayList;
import java.util.List;
import jplay.Scene;
import jplay.Window;

public class Fase3 extends Fase { //Fase da Lua
    
    private List<Inimigo> ini3; //Lista de inimigos da fase 3.
    
    public Fase3(Window window, Scene cenario, Personagem p) {
       
        super();
        setJanela(window);
        setCenario(cenario);
        setPersonagem(p);
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        Fase.setId(3);
        this.ini3 = new ArrayList<Inimigo>();
       
    }
   
   
    //Fase sendo executada:
    public void run() {
        
        ini3 = FabricaInimigo.inicializarInimigos(5,this);
        
        int n = Fase.getNum_ini();
        int wave = 0;
        
        while(isExecutando() == true) {
           
            getPersonagem().caminho(getCenario());
            getPersonagem().movimentar(getJanela());
            getCenario().moveScene(getPersonagem());
            
           for(int i = 0; i < ini3.size(); i++) {
           
               Inimigo ini = ini3.get(i);
               
               ini.draw();
               ini.atacar(getPersonagem());
               ini.verificaInimigo(ini3,i);
               ini.caminho(getCenario());
               ini.verificaPersonagem(getPersonagem());
               ini.morrer(getPersonagem());
               
               getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), ini);
               
               if(ini.getStatus() == false) {
                   
                   n--;
                   ini3.remove(ini);
                   
                   if(n == 0) {

                        n = getNum_ini();
                        wave++;
                        
                        if(wave == Fase.getCont())
                            setExecutando(false);
                        else
                            ini3 = FabricaInimigo.inicializarInimigos(5,this);
                   }
                   
               }
           
           }
           
           
           info.mostrarInformacoes(getJanela(), getPersonagem(), n, (wave+1));
           getPersonagem().draw();
           
           getJanela().update();
           
       }
       
   }
    
}
