package Modelo;

import java.util.ArrayList;
import java.util.List;
import jplay.Scene;
import jplay.Window;

public class FaseSurvival extends Fase { //Fase da Lua
    
    private List<Inimigo> ini3; //Lista de inimigos da fase 3.
    
    public FaseSurvival(Window window, Scene cenario, Personagem p) {
       
        super();
        setJanela(window);
        setCenario(cenario);
        setPersonagem(p);
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        
        this.ini3 = new ArrayList<Inimigo>();
       
    }
   
   
    //Fase sendo executada:
    public void run() {
        
        ini3 = FabricaInimigo.inicializarInimigosSurvival(this);
        
        int n = Fase.getNum_ini();
        int num_ini_morto = 0;
        int wave = 0;
        
        while(isExecutando() == true) {
           
            getPersonagem().caminho(getCenario());
            getPersonagem().movimentar(getJanela());
            getCenario().moveScene(getPersonagem());
           
           for(int i = 0; i < ini3.size(); i++) {
           
               Inimigo ini = ini3.get(i);
               
               info.drawInimigo(ini);
               ini.atacar(getPersonagem());
               ini.verificaInimigo(ini3,i);
               ini.caminho(getCenario());
               ini.verificaPersonagem(getPersonagem());
               ini.morrer(getPersonagem());
               
               getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), ini);
               
                if(ini.getStatus() == false) {
                   
                   n--;
                   num_ini_morto++;
                   ini3.remove(ini);
                   
                    if(n == 0) {
                        
                        Fase.setNum_ini(Fase.getNum_ini()+10);
                        ini3 = FabricaInimigo.inicializarInimigosSurvival(this);
                        
                       n = getNum_ini();
                       wave++;
                        
                       
                   }
                   
               }
           
           }
           
           
           info.mostrarInformacoes5(getJanela(), getPersonagem(), num_ini_morto, (wave+1));
           info.updateFasesNormais(getJanela(), getPersonagem());
           
       }
       
    }
    
    
}
