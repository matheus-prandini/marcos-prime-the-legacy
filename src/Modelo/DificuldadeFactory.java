package Modelo;

//Padrão Abstract Factory => ABSTRACT FACTORY.

//Os métodos da DificuldadeFactory são implementados como Factory Methods.

//Abstract Products => Personagem, Inimigo, Fase.

import java.util.ArrayList;
import jplay.Window;

public abstract class DificuldadeFactory {
    
    public abstract void setarFases();
    public abstract Chefao1 criarChefao1();
    public abstract Chefao2 criarChefao2();
    public abstract Chefao3 criarChefao3();
    public abstract ArrayList<Fase> criarFases(Window janela);
    public abstract ArrayList<Fase> criarFases2(Window janela);
    public abstract ArrayList<Fase> criarFases3(Window janela);
    public abstract Fase criarFase4(Window janela);
    
}