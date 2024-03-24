package Modelo;

//Padrão Simple Factory.

import java.util.ArrayList;
import java.util.List;


//Concrete Products => Inimigos (InimigozinhaFase1, InimigozinhaFase2, InimigozinhaFase3).

public class FabricaInimigo {
    
    public static Inimigo criarInimigo(int n, int x, int y) {
        
        if(n%3 == 0) {
            
            return new InimigozinhoFase1(x,y);
            
        }
        
        else if(n%3 == 1) {
            
            return new InimigozinhoFase2(x,y);
            
        }
        
        else {
            
            return new InimigozinhoFase3(x,y);
            
        }
        
    }
    
    public List<Inimigo> inicializarInimigos(Personagem p, int n) {
        
        ArrayList<Inimigo> ini = new ArrayList<Inimigo>();
        
        for (int i = 0; i < Fase.getNum_ini(); i++) {
            
            double x = 1 + (Math.random()*100);
            
            if(x >= 1 && x < 25) //Inimigos de cima
                ini.add(new InimigozinhoFase1(-200 + (int)(Math.random()*1000), -1 - (int)(Math.random()*200)));
            else if(x >= 25 && x < 50) //Inimigos da direita
                ini.add(new InimigozinhoFase1(-800 - (int)(Math.random()*-300), 100 - (int)(Math.random()*700)));
            else if(x >= 50 && x < 75) //Inimigos de baixo
                ini.add(new InimigozinhoFase1(0 + (int)(Math.random()*1000), 750 + (int)(Math.random()*800)));
            else
                ini.add(new InimigozinhoFase1(1000 + (int)(Math.random()*1200), 100 + (int)(Math.random()*800)));
                    
            p.adicionarObservador(ini.get(i));
            
        }
        
        return ini;
    }
    
    //Inicializa inimigos em posições aleatórias:
    
    public static ArrayList<Inimigo> inicializarInimigos(int n, Fase f) {
        
        ArrayList<Inimigo> ini = new ArrayList<Inimigo>();
        
        for (int i = 0; i < Fase.getNum_ini(); i++) {
            
            double x = 1 + (Math.random()*100);
            
            if(x >= 1 && x < 25) //Inimigos de cima
                ini.add(criarInimigo(n, -200 + (int)(Math.random()*1000), -1 - (int)(Math.random()*200)));
            else if(x >= 25 && x < 50) //Inimigos da direita
                ini.add(criarInimigo(n, -800 - (int)(Math.random()*-300), 100 - (int)(Math.random()*700)));
            else if(x >= 50 && x < 75) //Inimigos de baixo
                ini.add(criarInimigo(n, 0 + (int)(Math.random()*1000), 750 + (int)(Math.random()*800)));
            else
                ini.add(criarInimigo(n, 1000 + (int)(Math.random()*1200), 100 + (int)(Math.random()*800)));
                    
            f.getPersonagem().adicionarObservador(ini.get(i));
            
        }
        
        return ini;
    }
    
    public static List<Inimigo> inicializarInimigosSurvival(Fase f) {
        
        ArrayList<Inimigo> ini = new ArrayList<Inimigo>();
        
        for (int i = 0; i < Fase.getNum_ini(); i++) {
            
            double x = 1 + (Math.random()*100);
            
            if(x >= 1 && x < 25) //Inimigos de cima
                ini.add(criarInimigo(i, -200 + (int)(Math.random()*1000), -1 - (int)(Math.random()*200)));
            else if(x >= 25 && x < 50) //Inimigos da direita
                ini.add(criarInimigo(i, -800 - (int)(Math.random()*-300), 100 - (int)(Math.random()*700)));
            else if(x >= 50 && x < 75) //Inimigos de baixo
                ini.add(criarInimigo(i, 0 + (int)(Math.random()*1000), 750 + (int)(Math.random()*800)));
            else
                ini.add(criarInimigo(i, 1000 + (int)(Math.random()*1200), 100 + (int)(Math.random()*800)));
                    
            f.getPersonagem().adicionarObservador(ini.get(i));
            
        }
        
        return ini;
    }
    
}
