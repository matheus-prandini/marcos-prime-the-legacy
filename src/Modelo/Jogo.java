package Modelo;

import Visao.TelaInicial;
import java.util.ArrayList;
import jplay.GameImage;
import jplay.Window;

public class Jogo {
    
    GameImage plano;
    DificuldadeFactory fac;
    ArrayList<Fase> fases;
   
    public Jogo(Window window, GameImage plano, int dif, Personagem p) {
       
        this.plano = plano;
        
        if(dif == 0) {
            dificuldadeFacil();
            jogar(window);
        }
        
        if(dif == 1) {
            dificuldadeMedio();
            jogar(window);
        }
        
        if(dif == 2) {
            dificuldadeDificil();
            jogar(window);
        }
        
        if(dif == 3) {
            multiplayer(window);
        }
        
        if(dif == 4) {
            dificuldadeSurvival(window, p);
        }
        
    }
   
    
    public void dificuldadeFacil(){
        
        //DIFICULDADE FÁCIL
        fac = DificuldadeFacil.getInstancia();
        
    }

    public void dificuldadeMedio() {
       
        //DIFICULDADE MÉDIO
        fac = DificuldadeMedio.getInstancia();
        
    }

    public void dificuldadeDificil() {
     
        //DIFICULDADE DIFÍCIL
        fac = DificuldadeDificil.getInstancia();
        
    }
    
    public void jogar(Window window) {
        
        fac.setarFases();
  
        fases = fac.criarFases(window);
        
        for(Fase f : fases) {
            
            f.run();
        }
        
        fases = fac.criarFases2(window);
        
        for(Fase f : fases) {
            
            f.run();
        }
        
        fases = fac.criarFases3(window);
        
        for(Fase f : fases) {
            
            f.run();
            
        }
        
   
        Fase faseFinal = fac.criarFase4(window);
        
        faseFinal.run();
        
        novoJogo(window);
        
    }
    
    public void dificuldadeSurvival(Window window, Personagem p) {
        
        Fase f = FabricaFase.gerarFaseSurvival(window, p);
        
        f.run();
        
    }
    
    public void multiplayer(Window window){
        
        Personagem p1 = FabricaPersonagem.criarPersonagem(window,1);
        Personagem p2 = FabricaPersonagem.criarPersonagem(window,2);
        
        Fase f = FabricaFase.gerarFaseMultiplayer(window, p1, p2);
        
        f.run();
    }
    
    public static void novoJogo(Window window) {
        
        new TelaInicial(window);
        
    }
    
}
