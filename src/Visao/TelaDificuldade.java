package Visao;

import Controle.ControleTela;
import jplay.Sprite;
import jplay.Window;

//Padrão Arquitetural MVC => View.

public class TelaDificuldade {
    
    Sprite backGround;
    int dif=0;
    
    ControleTela controle;
    
    public TelaDificuldade(Window window)
    {
     
        backGround = new Sprite("src\\sprites\\teladif.png", 3);
      
        controle = new ControleTela(window,null,this,null);
        
        backGround.draw();
        window.display();
        escolherDificuldade(window);
        
    }
    
    public void escolherDificuldade(Window window)
    {
        
        boolean tela = true;
        while(tela)
        {
            
            controle.escolherDificuldade(window);
            
            backGround.draw();
            window.display();
            
        }
        
    }
    
    public void setDif(int dif) {
        this.dif = dif;
    }
    
    public int getDif() {
        return dif;
    }
    
    public void setBackGround(Sprite back) {
        this.backGround = back;
    }
    
    public Sprite getBackGround() {
        return backGround;
    }
    
}
