package Modelo;

import jplay.Window;

//Padrão Simple Factory.

//Concrete Products => Personagens (Marquin, MarcosPrime, Superman, Zordon).

public class FabricaPersonagem {

    public static Personagem criarPersonagem(Window window, int i) {
        
        Personagem p;
        
        if(i == 1) {
            
            p = new Marquin(0,450,window);
            p.setVelocidade(0.7);
            
        }
        else if(i == 2) {
            
            p = new MarcosPrime(0,450,window);
            p.setVelocidade(0.5);
            
        }
        else if(i == 3) {
            
            p = new SuperMan(0,450,window);
            p.setVelocidade(0.6);
            
        }
        else {
            
            p = new Zordon(0,450,window);
            p.setVelocidade(0.5);
            
        }
        
        return p;
        
    }
    
}
