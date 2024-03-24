package Modelo;

import Controle.ControlePersonagem;
import jplay.Scene;
import jplay.Window;

//Padrão State => State.

//Context => Personagem.

public abstract class PersonagemState {

    Personagem personagem;
    String descricao;
    
    public PersonagemState(Personagem p) {
        this.personagem = p;
        setVelocidade();
    }
    
    public void setPersonagem(Personagem p) {
        this.personagem = p;
    }
    
    public Personagem getPersonagem() {
        return personagem;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    //Ataque Player 1:
    public void atacar(Window janela, Scene cenario, ControlePersonagem controle, Inimigo ini, int n){
        
        if(controle.verificarAtaque() == true) {
            
            personagem.adicionaAtaque(personagem.getX()+13, personagem.getY()+16, personagem.getDirecao(), cenario, n);
         
        }
        
        personagem.run(ini, cenario, janela);
        
        this.verificarAlteracaoEstado();
    }
    
    //Ataque Player 2:
    public void atacar2(Window janela, Scene cenario, ControlePersonagem controle, Inimigo ini, int n){
        
        if(controle.verificarAtaque2() == true) {
            
            personagem.adicionaAtaque(personagem.getX()+13, personagem.getY()+16, personagem.getDirecao(), cenario, n);
         
        }
        
        personagem.run(ini, cenario, janela);
        
        this.verificarAlteracaoEstado();
    }
    
    protected abstract void setVelocidade(); //Seta velocidade.
    protected abstract void verificarAlteracaoEstado(); //Verifica alterçaões de State.
}
