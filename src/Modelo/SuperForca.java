package Modelo;

//Padrão Decorator => Concrete Decorator
public class SuperForca extends AtaqueInimigoDecorado {
    
    public SuperForca(AtaqueInimigo ataque) {
        
        super(ataque);
        setDano(2);
        setVelocidade(0.1);
    }
    
}
