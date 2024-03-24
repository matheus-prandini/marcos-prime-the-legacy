package Modelo;

//Padrão State => Concrete State.

public class NormalState extends PersonagemState {
    
    public NormalState(Personagem p) {
        super(p);
        setDescricao("Normal");
    }

    protected void setVelocidade() {
        personagem.setVelocidade(personagem.getVelocidade());
    }

    protected void verificarAlteracaoEstado() {
        
        if(this.personagem.getVida() <= 0) {
            personagem.setEstado(new MortoState(this.getPersonagem()));
        }
        else if(this.personagem.getVida() <= 500) {
            personagem.setEstado(new PerigoState(this.getPersonagem()));
        }
 
    }
    
}
