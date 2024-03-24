package Modelo;

//Padrão Strategy => Concrete Strategy.

public class Celular extends AtaquePersonagem {
    
    public Celular(double x, double y, int caminho) {
        
        super(x, y, caminho, "src\\sprites\\celular.png");
        setDano(20);
        setVelocidade(0.7);
        setId(2);
    }
    
}
