package Modelo;

public class InimigozinhoFase1 extends Inimigo {
    
    public InimigozinhoFase1(int x, int y) {
        super("src\\sprites\\bebado.png", 20);
        setX(x);
        setY(y);
        setTotalDuration(2000); //Duração Frames
        setVida(20);
        setAtaque(new ForcaBruta());
        setVelocidade(0.2);
    }   
    
    
}
