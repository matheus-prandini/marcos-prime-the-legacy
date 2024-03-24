package Controle;

import Modelo.FabricaPersonagem;
import Modelo.Jogo;
import Visao.TelaDificuldade;
import Visao.TelaInicial;
import Visao.TelaPersonagem;
import jplay.Keyboard;
import jplay.Window;

//Padrão Arquitetural MVC => Controler.

public class ControleTela {
    
    private TelaInicial telaIni;
    private TelaDificuldade telaDif;
    private TelaPersonagem telaPers;
    private Keyboard keyboard;
    
    //Instanciação de qual tela será usada e da janela.
    public ControleTela(Window window, TelaInicial ini, TelaDificuldade dif, TelaPersonagem pers) {
        
        this.telaIni = ini;
        this.telaDif = dif;
        this.telaPers = pers;
        
        //Restições para as teclas do teclado durante a execução das telas.
        keyboard = window.getKeyboard();
        keyboard.setBehavior(Keyboard.UP_KEY,   Keyboard.DETECT_INITIAL_PRESS_ONLY);
        keyboard.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        
    }
   
    //Verifica a opção escolhida na tela inicial para controle de sprites.
    public void opcaoTelaInicial() {
        
        if (keyboard.keyDown(Keyboard.UP_KEY) )
                {
                        if (telaIni.getOpcao() > 0)                        
                            telaIni.setOpcao(telaIni.getOpcao() - 1);                        
                }
                else
                {
                        if ( keyboard.keyDown(Keyboard.DOWN_KEY) )
                        {
                            if (telaIni.getOpcao() <= 2)                            
                                telaIni.setOpcao(telaIni.getOpcao() + 1);                            
                        }
                }
        
    }
    
    //Verifica a escolha do modo do jogador.
    public void escolherModo(Window window) {
        
        if((telaIni.getOpcao() == 0)&&(keyboard.keyDown(Keyboard.ENTER_KEY)) )
        {
            telaIni.modoArcade();
        }
                        
        if((telaIni.getOpcao() == 1)&&(keyboard.keyDown(Keyboard.ENTER_KEY)) )
        {
            telaIni.modoMultiplayer();
        }
                        
        if((telaIni.getOpcao() == 2)&&(keyboard.keyDown(Keyboard.ENTER_KEY)) )
        {
            telaIni.modoSurvival();
        }

        //Se apertar a tecla ESC, sai da tela inicial.
        if (keyboard.keyDown(Keyboard.ESCAPE_KEY))
            window.exit();
        
    }
    
    //Verifica a opção escolhida de dificuldade para controle de sprites.
    public void escolherDificuldade(Window window) {
        
        if (keyboard.keyDown(Keyboard.UP_KEY) )
            {
                if (telaDif.getDif() > 0)                        
                    telaDif.setDif(telaDif.getDif() - 1);                        
            }
            
            if (keyboard.keyDown(Keyboard.DOWN_KEY) )
            {
                if (telaDif.getDif() < 2)                            
                    telaDif.setDif(telaDif.getDif() +1);                            
            }
            
            
            telaDif.getBackGround().setCurrFrame(telaDif.getDif());
            
            if(keyboard.keyDown(Keyboard.ENTER_KEY))
            {
                //tela = false;
                new Jogo(window,telaDif.getBackGround(),telaDif.getDif(), null);
            }
        
    }
    
    //Verifica opção escolhida de personagem para controle de sprites.
    public void opcaoTelaPersonagem() {
        
        if (keyboard.keyDown(Keyboard.UP_KEY) )
        {
            if (telaPers.getOpcao() > 0)                        
                telaPers.setOpcao(telaPers.getOpcao() - 1);                        
        }
        
        else
        {
            if (keyboard.keyDown(Keyboard.DOWN_KEY) )
            {
                if (telaPers.getOpcao() < 3)                            
                    telaPers.setOpcao(telaPers.getOpcao() + 1);                            
            }
        }
        
    }
    
    //Trata a escolha do personagem para o modo Survival.
    public void escolherPersonagem(Window window) {
        
        if((telaPers.getOpcao() == 0)&&(keyboard.keyDown(Keyboard.ENTER_KEY)) )
        {
            new Jogo(window, telaPers.getBackGround(), 4, FabricaPersonagem.criarPersonagem(window,1));
        }
                        
        if((telaPers.getOpcao() == 1)&&(keyboard.keyDown(Keyboard.ENTER_KEY)) )
        {
            new Jogo(window, telaPers.getBackGround(), 4, FabricaPersonagem.criarPersonagem(window,2));
        }
                        
        if((telaPers.getOpcao() == 2)&&(keyboard.keyDown(Keyboard.ENTER_KEY)) )
        {
            new Jogo(window, telaPers.getBackGround(), 4, FabricaPersonagem.criarPersonagem(window,3));
        }
                        
        if((telaPers.getOpcao() == 3)&&(keyboard.keyDown(Keyboard.ENTER_KEY)) )
        {
            new Jogo(window, telaPers.getBackGround(), 4, FabricaPersonagem.criarPersonagem(window,4));
        }

        //Se apertar a tecla ESC, sai da tela inicial.
        if (keyboard.keyDown(Keyboard.ESCAPE_KEY))
            window.exit();
        
    }
    
}
