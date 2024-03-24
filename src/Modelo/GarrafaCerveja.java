package Modelo;

//Padrão Strategy => Concrete Strategy.

public class GarrafaCerveja extends AtaquePersonagem {
    
    public GarrafaCerveja(double x, double y, int caminho) {
        
        super(x, y, caminho, "src\\sprites\\garrafa.png");
        setDano(10);
        setVelocidade(0.7);
        setId(1);
    }
    
}
