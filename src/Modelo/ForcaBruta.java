package Modelo;

//Padrão Decorator => Concrete Component
public class ForcaBruta extends AtaqueInimigo {

    public ForcaBruta() {
        super();
        setDano(1);
        setVelocidade(0.1);
    }
    
}
