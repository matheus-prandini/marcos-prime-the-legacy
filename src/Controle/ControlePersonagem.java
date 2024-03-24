package Controle;

import Modelo.Personagem;
import java.awt.event.KeyEvent;
import jplay.Keyboard;
import jplay.Window;

//Padrão Arquitetural MVC => Controler.

//Classe responsável por tratar eventos relacionados ao Personagem.
public class ControlePersonagem {
    
    private Personagem personagem;
    private Keyboard teclado;
    
    //Insctancação de um keyboard e do personagem para o qual o controle será realizado.
    public ControlePersonagem(Window w, Personagem p) {
        
        this.personagem = p;
        
        teclado = w.getKeyboard();
        
        modificarTeclado();
    }
    
    //Movimentação do personagem para modos de somente 1 player: Modo História e modo Survival.
    public void movimentar(Window janela) {
        
        //VERIFICA TECLAS
        
        personagem.setHorizontal(true);
        if(teclado.keyDown(Keyboard.A_KEY) == true) {
            
            if(personagem.getX() > 0) {
                personagem.setX(personagem.getX() - personagem.getVelocidade());
            } 
            
            if(personagem.getDirecao() != 2) {
                personagem.setSequence(8,12);
                personagem.setDirecao(2);
            }
            
            personagem.setMovendo(true);
            
        }
        else if(teclado.keyDown(Keyboard.LEFT_KEY) == true) {
            
            if(personagem.getX() > 0) {
                personagem.setX(personagem.getX() - personagem.getVelocidade());
            } 
            
            if(personagem.getDirecao() != 1) {
                personagem.setSequence(4,8);
                personagem.setDirecao(1);
            }
            
            personagem.setMovendo(true);
            
        }
        else
        
            if(teclado.keyDown(Keyboard.D_KEY) == true) {
            
                if(personagem.getX() < janela.getWidth() - 50) {
                    personagem.setX(personagem.getX() + personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 1) {
                    personagem.setSequence(4,8);
                    personagem.setDirecao(1);
                }
            
                personagem.setMovendo(true);
            }
            
            else if(teclado.keyDown(Keyboard.RIGHT_KEY) == true) {
            
                if(personagem.getX() < janela.getWidth() - 50) {
                    personagem.setX(personagem.getX() + personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 2) {
                    personagem.setSequence(8,12);
                    personagem.setDirecao(2);
                }
            
                personagem.setMovendo(true);
            }
            
            else
                personagem.setHorizontal(false);
        
        if(!personagem.isHorizontal()){
        
            if(teclado.keyDown(KeyEvent.VK_W)) {
            
                if(personagem.getY() > 0) {
                    personagem.setY(personagem.getY() - personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 5) {
                    personagem.setSequence(0,4);
                    personagem.setDirecao(5);
                }
            
                personagem.setMovendo(true);
            }
            
            else if(teclado.keyDown(Keyboard.UP_KEY)) {
            
                if(personagem.getY() > 0) {
                    personagem.setY(personagem.getY() - personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 4) {
                    personagem.setSequence(12,16);
                    personagem.setDirecao(4);
                }
            
                personagem.setMovendo(true);
            }
        
            else if(teclado.keyDown(Keyboard.S_KEY)) {
            
                if(personagem.getY() < janela.getHeight() - 50) {
                    personagem.setY(personagem.getY() + personagem.getVelocidade());
                } 
                
                if(personagem.getDirecao() != 4) {
                    personagem.setSequence(12,16);
                    personagem.setDirecao(4);
                }
            
                personagem.setMovendo(true);
            }
            
            else if(teclado.keyDown(Keyboard.DOWN_KEY)) {
            
                if(personagem.getY() < janela.getHeight() - 50) {
                    personagem.setY(personagem.getY() + personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 5) {
                    personagem.setSequence(0,4);
                    personagem.setDirecao(5);
                }
            
                personagem.setMovendo(true);
            }
            
        }
        
        if(personagem.isMovendo()) {
            personagem.update();
            personagem.setMovendo(false);
        }
        
        personagem.atualizarObservadores();
        
    }
    
    //Responsável pela movimentação do player 1 para o modo multiplayer.
    public void movimentar1(Window janela) {
        
        //VERIFICA TECLAS
        
        personagem.setHorizontal(true);
        if(teclado.keyDown(Keyboard.LEFT_KEY) == true) {
            
            if(personagem.getX() > 0) {
                personagem.setX(personagem.getX() - personagem.getVelocidade());
            } 
            
            if(personagem.getDirecao() != 1) {
                personagem.setSequence(4,8);
                personagem.setDirecao(1);
            }
            
            personagem.setMovendo(true);
            
        }
        else
        
            if(teclado.keyDown(Keyboard.RIGHT_KEY) == true) {
            
                if(personagem.getX() < janela.getWidth() - 50) {
                    personagem.setX(personagem.getX() + personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 2) {
                    personagem.setSequence(8,12);
                    personagem.setDirecao(2);
                }
            
                personagem.setMovendo(true);
            }
            else
                personagem.setHorizontal(false);
        
        if(!personagem.isHorizontal()){
        
            if(teclado.keyDown(Keyboard.UP_KEY)) {
            
                if(personagem.getY() > 0) {
                    personagem.setY(personagem.getY() - personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 4) {
                    personagem.setSequence(12,16);
                    personagem.setDirecao(4);
                }
            
                personagem.setMovendo(true);
            }
        
            if(teclado.keyDown(Keyboard.DOWN_KEY)) {
            
                if(personagem.getY() < janela.getHeight() - 50) {
                    personagem.setY(personagem.getY() + personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 5) {
                    personagem.setSequence(0,4);
                    personagem.setDirecao(5);
                }
            
                personagem.setMovendo(true);
            }
        }
        
        if(personagem.isMovendo()) {
            personagem.update();
            personagem.setMovendo(false);
        }
        
        //movimentar1(janela, teclado);
        
        personagem.atualizarObservadores();
        
        
    }
    
    //Responsável pela movimentação do player 2 para o modo multiplayer.
    public void movimentar2(Window janela) {
        
        //VERIFICA TECLAS
        
        personagem.setHorizontal(true);
        if(teclado.keyDown(Keyboard.A_KEY) == true) {
            
            if(personagem.getX() > 0) {
                personagem.setX(personagem.getX() - personagem.getVelocidade());
            } 
            
            if(personagem.getDirecao() != 1) {
                personagem.setSequence(4,8);
                personagem.setDirecao(1);
            }
            
            personagem.setMovendo(true);
            
        }
            
        else
        
            if(teclado.keyDown(Keyboard.D_KEY) == true) {
            
                if(personagem.getX() < janela.getWidth() - 50) {
                    personagem.setX(personagem.getX() + personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 2) {
                    personagem.setSequence(8,12);
                    personagem.setDirecao(2);
                }
            
                personagem.setMovendo(true);
            }
            
            else
                personagem.setHorizontal(false);
        
        if(!personagem.isHorizontal()){
        
            if(teclado.keyDown(KeyEvent.VK_W)) {
            
                if(personagem.getY() > 0) {
                    personagem.setY(personagem.getY() - personagem.getVelocidade());
                } 
            
                if(personagem.getDirecao() != 4) {
                    personagem.setSequence(12,16);
                    personagem.setDirecao(4);
                }
            
                personagem.setMovendo(true);
            }
        
            else if(teclado.keyDown(Keyboard.S_KEY)) {
            
                if(personagem.getY() < janela.getHeight() - 50) {
                    personagem.setY(personagem.getY() + personagem.getVelocidade());
                } 
                
                if(personagem.getDirecao() != 5) {
                    personagem.setSequence(0,4);
                    personagem.setDirecao(5);
                }
            
                personagem.setMovendo(true);
            }
            
        }
        
        if(personagem.isMovendo()) {
            personagem.update();
            personagem.setMovendo(false);
        }
        
        personagem.atualizarObservadores();
        
    }
 
    //Trata evento de ataque do player 1 para todos os modos.
    public boolean verificarAtaque() {
        
        if(teclado.keyDown(Keyboard.SPACE_KEY)) {
            
            return true;
            
        }
        else
            return false;
        
    }
    
    //Trata evento de ataque do player 2 para o modo multiplayer.
    public boolean verificarAtaque2() {
        
        if(teclado.keyDown(Keyboard.ENTER_KEY)) {
            
            return true;
            
        }
        else
            return false;
        
    }
    
    //Função para liberar todos os botões que podem ser utilizados durante o jogo.
    public void modificarTeclado() {
        
        teclado.setBehavior(Keyboard.A_KEY, Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Keyboard.D_KEY, Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Keyboard.S_KEY, Keyboard.DETECT_EVERY_PRESS);
        teclado.addKey(KeyEvent.VK_W, Keyboard.DETECT_EVERY_PRESS); 
        teclado.setBehavior(Keyboard.UP_KEY,   Keyboard.DETECT_EVERY_PRESS);
        teclado.setBehavior(Keyboard.DOWN_KEY, Keyboard.DETECT_EVERY_PRESS);
        
    }
    
    //Get Teclado.
    public Keyboard getKeyboard() {
        return teclado;
    }
}
