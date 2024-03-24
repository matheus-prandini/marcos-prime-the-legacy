package Modelo;

//Chefão Monstro.

public class Chefao2 extends Inimigo {

    //Construtor:
    public Chefao2(int x, int y) {
        super("src\\sprites\\monstro.png", 20); //Imagem do sprite e número de frames da imagem.
        setX(x);
        setY(y);
        setTotalDuration(2000); //Duração ds frames
        setAtaque(new SuperForca(new ForcaBruta())); //Usa o Concrete Decorator SuperForca.
    }
    
    //SuperForça (Ataque incrementa com o tempo).
    public void superForca() {
        
       getAtaque().setDano(getAtaque().getDano()+2);
        
    }
    
}
