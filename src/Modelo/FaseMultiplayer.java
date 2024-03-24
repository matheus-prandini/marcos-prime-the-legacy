package Modelo;

import java.util.ArrayList;
import jplay.Scene;
import jplay.Window;

public class FaseMultiplayer extends Fase { //Fase da Lua
    
    Personagem player2;
    
    private ArrayList<Inimigo> inimigos;
    private FabricaInimigo fac;
    
    public FaseMultiplayer(Window window, Scene cenario, Personagem p1, Personagem p2) {
       
        super();
        setJanela(window);
        setCenario(cenario);
        setPersonagem(p1);
        this.player2 = p2;
        this.inimigos = new ArrayList<Inimigo>();
        this.fac = new FabricaInimigo();
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        getCenario().addOverlay(p2);
       
    }
    
    
    public void inicializarInimigos() {
        
        for (int i = 0; i < Fase.getNum_ini(); i++) {
            
            double x = 1 + (Math.random()*100);
            
            if(x >= 1 && x < 25) //Inimigos de cima
                this.inimigos.add(fac.criarInimigo(i, -200 + (int)(Math.random()*1000), -1 - (int)(Math.random()*200)));
            else if(x >= 25 && x < 50) //Inimigos da direita
                this.inimigos.add(fac.criarInimigo(i, -800 - (int)(Math.random()*-300), 100 - (int)(Math.random()*700)));
            else if(x >= 50 && x < 75) //Inimigos de baixo
                this.inimigos.add(fac.criarInimigo(i, 0 + (int)(Math.random()*1000), 750 + (int)(Math.random()*800)));
            else
                this.inimigos.add(fac.criarInimigo(i, 1000 + (int)(Math.random()*1200), 100 + (int)(Math.random()*800)));
                    
            getPersonagem().adicionarObservador(this.inimigos.get(i));
            
        }
    }
    
   
    //Fase sendo executada:
    public void run() {

        inicializarInimigos();
        
        int n = Fase.getNum_ini();
        int num_ini_morto = 0;
        
        while(isExecutando() == true) {
           
            getPersonagem().caminho(getCenario());
            getPersonagem().movimentar2(getJanela());
            //getPersonagem().atacar1(getJanela(), getCenario(), getTeclado(), player2);
            getCenario().moveScene(getPersonagem());
            
           
           this.player2.movimentar1(getJanela());
           this.player2.caminho(getCenario());
           //this.player2.atacar2(getJanela(), getCenario(), getTeclado(), getPersonagem());
           
           for(int i = 0; i < inimigos.size(); i++) {
           
               Inimigo ini = inimigos.get(i);
               
               ini.draw();
               ini.atacar(getPersonagem());
               ini.atacar(this.player2);
               ini.verificaInimigo(inimigos,i);
               ini.caminho(getCenario());
               ini.verificaPersonagem(getPersonagem());
               ini.verificaPersonagem(this.player2);
               ini.morrer(getPersonagem());
               ini.morrer(this.player2);
               
               getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), ini);
               player2.atacar2(getJanela(), getCenario(), player2.getControle_pers(), ini);
               
               if(ini.getStatus() == false) {
                   
                   n--;
                   num_ini_morto++;
                   inimigos.remove(ini);
                   
                   if(n == 0) {

                        Fase.setNum_ini(Fase.getNum_ini()+10);
                        n = getNum_ini();
                        
                        inicializarInimigos();
                   }
                   
               }
           
           }
           
           info.mostrarInformacoes6(getJanela(), getPersonagem(), this.player2, num_ini_morto);
           
           getPersonagem().draw();
           this.player2.draw();
           getJanela().update();
           
       }
       
    }
    
}
