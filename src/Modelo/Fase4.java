package Modelo;

import java.util.ArrayList;
import jplay.Scene;
import jplay.Window;

public class Fase4 extends Fase { //Fase do Bar
    
    private Inimigo chefao1, chefao2, chefao3;
    private int temp1=0, temp2=0;
    
    public Fase4(Window window, Personagem p, ArrayList<Inimigo> inimigos) {
       
        super();
        setJanela(window);
        setCenario(new Scene());
        getCenario().loadFromFile("src\\sprites\\faseEspaco.scn");
        setPersonagem(p);
        setExecutando(true);
        getCenario().addOverlay(getPersonagem());
        Fase.setId(4);
        this.chefao1 = inimigos.get(0);
        this.chefao2 = inimigos.get(1);
        this.chefao3 = inimigos.get(2);
        getPersonagem().adicionarObservador(this.chefao1);
        getPersonagem().adicionarObservador(this.chefao2);
        getPersonagem().adicionarObservador(this.chefao3);
        
   }
   
    public void run() {
        
        getPersonagem().setX(100);
        getPersonagem().setY(450);
        this.chefao1.setX(300);
        this.chefao1.setY(100);
        this.chefao2.setX(500);
        this.chefao2.setY(100);
        this.chefao3.setX(700);
        this.chefao3.setY(100);
        
        while(isExecutando() == true) {
            
           getPersonagem().caminho(getCenario());
           getPersonagem().movimentar(getJanela());
           getCenario().moveScene(getPersonagem());
           
           getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), this.chefao1);
           getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), this.chefao2);
           getPersonagem().atacar(getJanela(), getCenario(), getPersonagem().getControle_pers(), this.chefao3);
           
            if(this.temp1 == 2000) {
                this.chefao1.teletransportar(getPersonagem());
                this.chefao2.superForca();
                this.temp1 = 0;
            }
            
            if(this.temp2 == 500) {
                this.chefao3.atacar1(getJanela(), getCenario(), getPersonagem());
                this.temp2 = 0;
            }
            
            if(this.chefao3.getAtaques().size() > 0) {
                this.chefao3.run(getPersonagem(), getCenario(), getJanela());
            }
            
            this.chefao1.atacar(getPersonagem());
            this.chefao2.atacar(getPersonagem());
            this.chefao1.verificaPersonagem(getPersonagem());
            this.chefao2.verificaPersonagem(getPersonagem());
            this.chefao3.verificaPersonagem(getPersonagem());
            this.chefao1.morrer(getPersonagem());
            this.chefao2.morrer(getPersonagem());
            this.chefao3.morrer(getPersonagem());
             
            if(chefao1.getStatus()==false && chefao2.getStatus()==false && chefao3.getStatus()==false) {
                setExecutando(false);
            }
           
           getPersonagem().draw();
           
           info.mostrarInformacoes4(getJanela(), getPersonagem(), chefao1, chefao2, chefao3);
           
           this.chefao1.draw();
           this.chefao2.draw();
           this.chefao3.draw();
           
           getJanela().update();
           
           this.temp1++;
           this.temp2++;
       }
       
    }
    
}