package Modelo;

import java.util.ArrayList;
import java.util.List;
import jplay.Scene;
import jplay.Window;

public class Fase2 extends Fase { //Fase da Cidade
    
    private List<Inimigo> ini2; //Lista de inimigos da fase 2.
    
    public Fase2(Window window, Scene cenario, Personagem p) {
       
        super();
        setJanela(window);
        setCenario(cenario);
        setPersonagem(p);
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        Fase.setId(2);
        this.ini2 = new ArrayList<Inimigo>();
       
    }
   
    //Fase sendo executada:
    public void run() {
        
        ini2 = FabricaInimigo.inicializarInimigos(4,this);
        
        int n = Fase.getNum_ini();
        int wave = 0;
        
        while(isExecutando() == true) {
           
            getPersonagem().caminho(getCenario());
            getPersonagem().movimentar(getJanela());
            getCenario().moveScene(getPersonagem());
            
           for(int i = 0; i < ini2.size(); i++) {
           
               Inimigo ini = ini2.get(i);
               
               ini.draw();
               ini.atacar(getPersonagem());
               ini.verificaInimigo(ini2,i);
               ini.caminho(getCenario());
               ini.verificaPersonagem(getPersonagem());
               ini.morrer(getPersonagem());
               
               getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), ini);
               
               if(ini.getStatus() == false) {
                   
                   n--;
                   ini2.remove(ini);
                   
                   if(n == 0) {

                        n = getNum_ini();
                        wave++;
                        
                        if(wave == Fase.getCont())
                            setExecutando(false);
                        else
                            ini2 = FabricaInimigo.inicializarInimigos(4,this);
                   }
                   
               }
           
           }
           
           
           info.mostrarInformacoes(getJanela(), getPersonagem(), n, (wave+1));
           getPersonagem().draw();
           
           getJanela().update();
   
       }
       
   }
    
}
