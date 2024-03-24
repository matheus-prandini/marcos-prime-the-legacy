package Modelo;

public class InimigozinhoFase3 extends Inimigo {
    
     public InimigozinhoFase3(int x, int y) {
        super("src\\sprites\\astronauta.png", 20);
        setX(x);
        setY(y);
        setTotalDuration(2000); //Duração Frames
        setVida(30);
        setAtaque(new ForcaBruta());
        setVelocidade(0.3);
    }   
    
}
