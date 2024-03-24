package Modelo;

//Padrão Strategy => Concrete Strategy.

public class Boomerangue extends AtaquePersonagem {
    
    public Boomerangue(double x, double y, int caminho) {
        
        super(x, y, caminho, "src\\sprites\\bomerangue.png");
        setDano(10);
        setVelocidade(0.7);
        setId(1);
    }
    
}
