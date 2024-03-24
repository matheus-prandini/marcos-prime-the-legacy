package Modelo;

import java.util.ArrayList;
import java.util.List;
import jplay.Scene;
import jplay.Window;

public class Fase1 extends Fase { //Fase do Bar
    
    private List<Inimigo> ini1; //Lista de inimigos da fase 1.
    
    public Fase1(Window window, Scene cenario, Personagem p) {
       
        super();
        setJanela(window);
        setCenario(cenario);
        setPersonagem(p);
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        Fase.setId(1);
        this.ini1 = new ArrayList<Inimigo>();
       
    }
   
    //Fase sendo executada:
    public void run() {
        
        ini1 = FabricaInimigo.inicializarInimigos(3,this);
        
        int n = Fase.getNum_ini();
        int wave = 0;
        
        while(isExecutando() == true) {
           
            getPersonagem().caminho(getCenario());
            getPersonagem().movimentar(getJanela());
            //getPersonagem().movimentar1(getJanela(),getTeclado());
            getCenario().moveScene(getPersonagem());
            
           for(int i = 0; i < ini1.size(); i++) {
           
               Inimigo ini = ini1.get(i);
               
               info.drawInimigo(ini);
               ini.atacar(getPersonagem());
               ini.verificaInimigo(ini1,i);
               ini.caminho(getCenario());
               ini.verificaPersonagem(getPersonagem());
               ini.morrer(getPersonagem());
               
               getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), ini);
               
               if(ini.getStatus() == false) {
                   
                   n--;
                   ini1.remove(ini);
                   
                   if(n == 0) {

                        n = getNum_ini();
                        wave++;
                        
                        if(wave == Fase.getCont())
                            setExecutando(false);
                        else
                            ini1 = FabricaInimigo.inicializarInimigos(3,this);
                   }
                   
               }
           
           }
           
           
           info.mostrarInformacoes(getJanela(), getPersonagem(), n, (wave+1));
           info.updateFasesNormais(getJanela(), getPersonagem());
           
       }
       
   }
    
}
