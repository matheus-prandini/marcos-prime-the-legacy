package Modelo;

//Padrão State => Concrete State.

public class PerigoState extends PersonagemState {
    
    public PerigoState(Personagem p) {
        super(p);
        setDescricao("Danger");
    }

    protected void setVelocidade() {
        personagem.setVelocidade(0.8);
    }

    protected void verificarAlteracaoEstado() {
        
        if(this.personagem.getVida() <= 0) {
            personagem.setEstado(new MortoState(getPersonagem()));
        }
        else if(this.personagem.getVida() >= 500) {
            personagem.setEstado(new NormalState(getPersonagem()));
        }
 
    }
    
}
