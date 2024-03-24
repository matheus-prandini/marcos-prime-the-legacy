package Modelo;

import jplay.Scene;
import jplay.Window;

public class FaseChefao3 extends Fase { //Fase da Lua
    
    private Inimigo chefao;
    private int tele = 0;
    
    public FaseChefao3(Window window, Personagem p, Inimigo chefao) {
       
        super();
        setJanela(window);
        setCenario(new Scene());
        getCenario().loadFromFile("src\\sprites\\faseLua.scn");
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
           
            if(this.tele == 200) {
                chefao.atacar1(getJanela(), getCenario(), getPersonagem());
                this.tele = 0;
            }
            
            if(chefao.getAtaques().size() > 0) {
                chefao.run(getPersonagem(), getCenario(), getJanela());
            }
            
            this.chefao.verificaPersonagem(getPersonagem());
            this.chefao.morrer(getPersonagem());
           
            if(chefao.getStatus()==false) {
                setExecutando(false);
            }
            
           getCenario().moveScene(getPersonagem());
           
           info.mostrarInformacoes3(getJanela(), getPersonagem(), this.chefao);
           getPersonagem().draw();
           this.chefao.draw();
           getJanela().update();
           
           this.tele++;
       }
       
   }
    
}
