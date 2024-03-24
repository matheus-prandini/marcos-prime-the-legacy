package Modelo;

//Padrão State => Concrete State.

public class MortoState extends PersonagemState {
    
    public MortoState(Personagem p) {
        super(p);
        setDescricao("Dead");
    }

    protected void setVelocidade() {
        personagem.setVelocidade(0);
    }

    protected void verificarAlteracaoEstado() {
        
        if(personagem.getVida() <= 0) {
            personagem.setVida(0);
            System.exit(0); //FIM DE JOGO
        }
 
    }
    
}
