package Modelo;

//Padrão Decorator => COMPONENT
//Específica para os inimigos das fases que atacam somente de perto.
public abstract class AtaqueInimigo extends Ataque {
 
    public AtaqueInimigo() {
        
        super("");
        
    }
    
    public void atacar(Personagem personagem) {
        
        personagem.setVida(personagem.getVida() - ((getDano())*(getVelocidade())));
        
    }
    
}
