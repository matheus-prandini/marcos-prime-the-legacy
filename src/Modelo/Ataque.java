package Modelo;

import jplay.Sprite;

public abstract class Ataque extends Sprite {
    
    private int dano; //Dano ataque
    private double velocidade; //Velocidade Ataque
    
    public Ataque(String imagem) {
        
        super(imagem, 11);
        
    }
    
    /*******************************Setters e Getters**************************/
    
    public void setDano(int dano) {
        this.dano = dano;
    }
    
    public int getDano() {
        return dano;
    }
    
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    
    public double getVelocidade() {
        return velocidade;
    }
    
}
