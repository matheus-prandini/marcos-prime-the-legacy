package Modelo;

import jplay.Scene;
import jplay.Window;

public class FaseChefao1 extends Fase { //Fase do Bar
    
    private Inimigo chefao;
    private int tele = 0; //Tempo para teletransporte do chefao.
    
    public FaseChefao1(Window window, Personagem p, Chefao1 chefao) {
       
        super();
        setJanela(window);
        setCenario(new Scene());
        getCenario().loadFromFile("src\\sprites\\faseBar.scn");
        setPersonagem(p);
        setExecutando(true);
        
        this.chefao = chefao;
        getPersonagem().adicionarObservador(this.chefao);
       
   }
   
    public void run() {
        
        getPersonagem().setX(100);
        getPersonagem().setY(450);
        
        while(isExecutando() == true) {
            
           getPersonagem().caminho(getCenario());
           getPersonagem().movimentar(getJanela());
           getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), this.chefao);
           
            if(this.tele == 1000) {
                this.chefao.teletransportar(getPersonagem());
                this.tele = 0;
            }
            
            this.chefao.atacar(getPersonagem());
            this.chefao.verificaPersonagem(getPersonagem());
            this.chefao.morrer(getPersonagem());
           
            if(chefao.getStatus()==false) {
                setExecutando(false);
            }
            
           getCenario().moveScene(getPersonagem());
           
           info.mostrarInformacoes1(getJanela(), getPersonagem(), this.chefao, this.tele);
           getPersonagem().draw();
           this.chefao.draw();
           getJanela().update();
           
           this.tele++;
       }
       
    }
    
}
