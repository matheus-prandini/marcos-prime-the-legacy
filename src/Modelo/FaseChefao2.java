package Modelo;

import jplay.Scene;
import jplay.Window;

public class FaseChefao2 extends Fase { //Fase do Bar
    
    private Inimigo chefao;
    private int tele = 0; //Tempo para teletransporte do chefao.
    
    public FaseChefao2(Window window, Personagem p, Inimigo chefao) {
       
        super();
        setJanela(window);
        setCenario(new Scene());
        getCenario().loadFromFile("src\\sprites\\faseCidade.scn");
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
           
            if(this.tele == 2000) {
                this.chefao.superForca();
                this.tele = 0;
            }
            
            this.chefao.atacar(getPersonagem());
            this.chefao.verificaPersonagem(getPersonagem());
            this.chefao.morrer(getPersonagem());
           
            if(chefao.getStatus()==false) {
                setExecutando(false);
            }
            
           getCenario().moveScene(getPersonagem());
           
           info.mostrarInformacoes2(getJanela(), getPersonagem(), this.chefao);
           getPersonagem().draw();
           this.chefao.draw();
           getJanela().update();
           
           this.tele++;
       }
       
    }
    
}
