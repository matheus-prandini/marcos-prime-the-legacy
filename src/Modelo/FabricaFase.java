package Modelo;

import jplay.Scene;
import jplay.Window;

public class FabricaFase {
    
    public static Fase gerarFase(Window window, Personagem p, int x) {
        
        Scene cenario = new Scene();
        Fase f;
        
        if(x == 1) {
            
            cenario.loadFromFile("src/sprites/faseBar.scn");
            Fase.setId(1);
            f = new Fase1(window, cenario, p);
            
        }
        
        else if(x == 2) {
            
            cenario.loadFromFile("src/sprites/faseCidade.scn");
            Fase.setId(2);
            f = new Fase2(window, cenario, p);
 
            
        }
        
        else {
            
            cenario.loadFromFile("src/sprites/faseLua.scn");
            
            f = new Fase3(window, cenario, p);
            Fase.setId(3);
            
        }
        
        return f;
        
    }
    
    public static Fase gerarFaseSurvival(Window window, Personagem p) {
        
        Scene cenario = new Scene();
        
        Fase.setNum_ini(10);
        
        double x = 1 + Math.random()%100;
       
        if(x <= 1.2) {
            
            cenario.loadFromFile("src/sprites/faseBar.scn");

            Fase.setId(1);
            
        }
        
        else if(x <= 1.5) {
            
            cenario.loadFromFile("src/sprites/faseCidade.scn");

            Fase.setId(2);
            
        }
        
        else if(x <= 1.8) {
            
            cenario.loadFromFile("src/sprites/faseLua.scn");

            Fase.setId(3);
            
        }
        
        else {
               
            cenario.loadFromFile("src/sprites/faseEspaco.scn");

            Fase.setId(4);
            
        }
        
        return new FaseSurvival(window, cenario, p);
        
    }
    
    public static Fase gerarFaseMultiplayer(Window window, Personagem p1, Personagem p2) {
        
        Scene cenario = new Scene();
        
        Fase.setNum_ini(10);
        
        double x = 1 + Math.random()%100;
       
        if(x <= 1.2) {
            
            cenario.loadFromFile("src/sprites/faseBar.scn");
            Fase.setId(1);
            
        }
        
        else if(x <= 1.5) {
            
            cenario.loadFromFile("src/sprites/faseCidade.scn");

            Fase.setId(2);
            
        }
        
        else if(x <= 1.8) {
            
            cenario.loadFromFile("src/sprites/faseLua.scn");

            Fase.setId(3);
            
        }
        
        else {
               
            cenario.loadFromFile("src/sprites/faseEspaco.scn");
            
            Fase.setId(4);
            
        }
        
        return new FaseMultiplayer(window, cenario, p1, p2);
        
    }
    
    public static Fase gerarFaseChefao(Window window, Personagem p, DificuldadeFactory fac, int x) {
        
        Fase f;
        
        if(x == 1) {
            
            f = new FaseChefao1(window, p, fac.criarChefao1());
            Fase.setId(1);
            
        }
        
        else if(x == 2) {
            
            
            f = new FaseChefao2(window, p, fac.criarChefao2());
            Fase.setId(2);
            
        }
        
        else {
            
            f = new FaseChefao3(window, p, fac.criarChefao3());
            Fase.setId(3);
            
        }

        
        return f;
        
    }
    
}
