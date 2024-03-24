package Modelo;

//Padrão Decorator => Decorator
public class AtaqueInimigoDecorado extends AtaqueInimigo {
    
    private AtaqueInimigo ataqueInimigoDecorado;
    
    public AtaqueInimigoDecorado(AtaqueInimigo ataqueInimigoDecorado) {
        this.ataqueInimigoDecorado = ataqueInimigoDecorado;
    }
    
    public int getDano_Ataque() {
        return ataqueInimigoDecorado.getDano() + this.getDano() ;
    }
    
    public double getVelocidade_Ataque() {
        return ataqueInimigoDecorado.getVelocidade() + this.getVelocidade() ;
    }
    
    public void atacar(Personagem personagem) {
        
        personagem.setVida(personagem.getVida() - ((getDano_Ataque())*(getVelocidade_Ataque())));
        
    }
    
}
