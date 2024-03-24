package Modelo;

public class RaioLaser extends AtaquePersonagem {
    
    public RaioLaser(double x, double y, int caminho) {
        
        super(x, y, caminho, "src\\sprites\\laser.png");
        setDano(40);
        setVelocidade(0.7);
        setId(3);
    }
    
}
