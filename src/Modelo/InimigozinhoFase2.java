package Modelo;

public class InimigozinhoFase2 extends Inimigo {
    
     public InimigozinhoFase2(int x, int y) {
        super("src\\sprites\\punk.png", 20);
        setX(x);
        setY(y);
        setTotalDuration(2000); //Duração Frames
        setVida(30);
        setAtaque(new ForcaBruta());
        setVelocidade(0.2);
    }   
    
}
