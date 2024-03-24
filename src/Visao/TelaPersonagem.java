package Visao;

import Controle.ControleTela;
import jplay.Sprite;
import jplay.Window;

//Padrão Arquitetural MVC => View.

public class TelaPersonagem {
    
    Sprite backGround;
    int opcaoEscolhida = 0;
    //int dif=0;
    
    ControleTela controle;
    
    public TelaPersonagem(Window window)
    {
        backGround = new Sprite("src\\sprites\\telapers.png", 4);
        
        controle = new ControleTela(window,null,null,this);
        backGround.draw();
        window.display();
        escolherPersonagem(window, backGround);
        
    }
    
    private void verificarOpcaoEscolhida()
    {                
            
        controle.opcaoTelaPersonagem();
            
        backGround.setCurrFrame(opcaoEscolhida);
    }
    
    private void escolherPersonagem(Window window, Sprite backGround)
        {
                boolean sair = false;
                do
                {
                        backGround.draw();
                        window.display();
                        verificarOpcaoEscolhida();
                        
                        controle.escolherPersonagem(window);
                        
                }while(sair == false);
        }
    
    public void setOpcao(int x) {
        this.opcaoEscolhida = x;
    }
    
    public int getOpcao() {
        return opcaoEscolhida;
    }
    public void setBackGround(Sprite back) {
        this.backGround = back;
    }
    
    public Sprite getBackGround() {
        return backGround;
    }
    
}
