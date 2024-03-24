package Modelo;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.Window;

//Padrão Obsever => Concrete Observer.

public abstract class Inimigo extends Sprite implements ObserverInimigo {
    
    Colisao controle;
    private double velocidade;
    private boolean movendo;
    private int direcao = 3;
    private double vida;
    private boolean status;
    private boolean horizontal;
    private AtaqueInimigo ataque;
    private LinkedList<AtaquePersonagem> ataques;

    public Inimigo(String fileName, int numFrames) {
        super(fileName, numFrames);
        this.controle = new Colisao();
        this.movendo = false;
        this.status = true;
    }
    
    //Trata colisões com os elementos do cenário.
    public void caminho(Scene cenario) {
        
        Point min = new Point((int)this.x, (int)this.y);
        Point max = new Point((int)this.x+this.width, (int)this.y+this.height);
        
        Vector tiles = cenario.getTilesFromPosition(min, max);
     
        for (int i=0; i<tiles.size(); i++) {
            
            TileInfo tile = (TileInfo) tiles.elementAt(i);
            
            if(controle.verificaColisao(this, tile) == true) { //Verifica se colidiu
                
                if(colisaoVertical(this,tile)) {
                    
                    //Reposicionamento
                    if(tile.y + (tile.height-1.5) < this.y) { // Baixo - Cima
                        this.y = tile.y + tile.height;
                    }
                    else if(tile.y > this.y + (this.height-1.5)) { // Cima - Baixo
                        this.y = tile.y - this.height;
                    }
                }
                if(colisaoHorizontal(this,tile)) {
                    
                    if(tile.x > this.x + (this.width-1.5)) {
                       this.x = tile.x - this.width; 
                    }
                    else if(tile.x + (tile.width-1.5) < this.x) {
                        this.x = tile.x + tile.width;
                    }
                    
                }
                
            }
        }
        
    }
    
    //Trata colisão com o personagem.
    public void verificaPersonagem(Personagem personagem) {
        
        if(this.collided(personagem)) {
            
            if(this.x + this.width > personagem.getX() || personagem.getX() + personagem.width > this.x) {
                
                if(personagem.getY() + (personagem.height-1.5) < this.y) { // Baixo - Cima
                    this.y = personagem.getY() + personagem.height;
                }
                    
                else if(personagem.getY() > this.y + (this.height-1.5)) { // Cima - Baixo
                    this.y = personagem.getY() - this.height;
                }
                
            }
            
            if(this.y + this.height > personagem.getY() || personagem.getY() + personagem.height > this.y) {
                
                if(personagem.getX() > this.x + (this.width-1.5)) {
                    this.x = personagem.getX() - this.width; 
                }
                    else if(personagem.getX() + (personagem.width-1.5) < this.x) {
                        this.x = personagem.getX() + personagem.width;
                    }
                
            }
            
            
        }
        
        
    }
    
    //Verificar colisão com outros inimigos
    public void verificaInimigo(List<Inimigo> inimigos, int posicao) {
        
        for(int i = 0; i < inimigos.size(); i++) {
            
            Inimigo ini = inimigos.get(i);
            
            if(this.collided(ini) && posicao != i) {
                
                if(this.x + this.width > ini.getX() || ini.getX() + ini.width > this.x) {
                
                    if(ini.getY() + (ini.height-1.5) < this.y) { // Baixo - Cima
                        this.y = ini.getY() + ini.height;
                    }
                    
                    else if(ini.getY() > this.y + (this.height-1.5)) { // Cima - Baixo
                        this.y = ini.getY() - this.height;
                    }
                
                }
            
                if(this.y + this.height > ini.getY() || ini.getY() + ini.height > this.y) {
                
                    if(ini.getX() > this.x + (this.width-1.5)) {
                        this.x = ini.getX() - this.width; 
                    }
                    
                    else if(ini.getX() + (ini.width-1.5) < this.x) {
                        this.x = ini.getX() + ini.width;
                    }
                
                }
                
            }
            
        }
        
    }
    
    private boolean colisaoVertical(GameObject obj, GameObject obj2) {
        
        if(obj2.x + obj2.width <= obj.x) {
            return false;
        }
        
        if(obj.x + obj.width <= obj2.x) {
            return false;
        }
        
        return true; 
        
    }
    
    private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
        
        if(obj2.y + obj2.height <= obj.y) {
            return false;
        }
        
        if(obj.y + obj.height <= obj2.y) {
            return false;
        }
        
        return true; //ocorreu colisão
        
    }
    
    //Acionado quando personagem se move.
    public void perseguir(double x, double y) {
        
        if(this.y <= y +1 && this.y >= y-1)
        {
            
            if(this.x < x) {
                
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 2) {
                    setSequence(8,12);
                    this.direcao = 2;
                }
            
                this.horizontal = true;
                this.movendo = true;
                
            }
            
            else {
              
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 1) {
                    setSequence(4,8);
                    this.direcao = 1;
                }
            
                this.horizontal = true;
                this.movendo = true;
                
            }
            
        }
        
        else if(this.x == x)
        {
            
            if(this.y < y)
            {
            
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 5) {
                    setSequence(0,4);
                    this.direcao = 5;
                }
            
                this.horizontal = false;
                this.movendo = true;
                
            }
            else
            {
            
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 4) {
                    setSequence(12,16);
                    this.direcao = 4;
                }
            
                this.horizontal = false;
                this.movendo = true;
                
            }
              
        }
        
        else if(this.x<x) {
            
            if(this.y == y) {
                
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 2) {
                    setSequence(8,12);
                    this.direcao = 2;
                }
            
                this.horizontal = true;
                this.movendo = true;
                
            }
            else if(this.y < y) {
                
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 5) {
                    setSequence(0,4);
                    this.direcao = 5;
                }
            
                this.horizontal = false;
                this.movendo = true;  
                
            }
            else if(this.y > y) {
                
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 4) {
                    setSequence(12,16);
                    this.direcao = 4;
                }
            
                this.horizontal = false;
                this.movendo = true;
                
            }
            
        }else if(this.x > x){
            
            if(this.y == y) {
                
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 1) {
                    setSequence(4,8);
                    this.direcao = 1;
                }
            
                this.horizontal = true;
                this.movendo = true;
                
            }
            else if(this.y < y) {
                
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 5) {
                    setSequence(0,4);
                    this.direcao = 5;
                }
            
                this.horizontal = false;
                this.movendo = true; 
                
                
            }
            else {
                
                moveTo(x,y,this.velocidade);
            
                if(this.direcao != 4) {
                    setSequence(12,16);
                    this.direcao = 4;
                }
            
                this.horizontal = false;
                this.movendo = true;
                
            }
            
        }
        
        if(this.movendo == true) {
            update();
            this.movendo = false;
        }
        
        
    }
    
    //Trata situação em que inimigo morre.
    public boolean morrer(Personagem p) {
        
        if(this.vida <= 0 && this.status == true) {
            this.velocidade = 0;
            this.vida = 0;
            this.movendo = false;
            this.status = false;
            this.x = 10000;
            p.removerObservador(this);
            
            return true;
        }
        
        return false;
       
    }
    
    //Método proveniente do padrão Observer.
    public void atualizar(SubjectPersonagem s) {
        
        perseguir(s.getX(), s.getY());
        
    }
    
    //Ataque ao personagem.
    public void atacar(Personagem personagem) {
        
        if(this.collided(personagem)) {
            this.ataque.atacar(personagem);
        }
        
    }
    
    //Implementações de poderes dos Inimigos:
    public void teletransportar(Personagem p) {}
    public void superForca() {}
    public void atacar1(Window janela, Scene cenario, Personagem p){}
    public void run(Personagem p, Scene cenario, Window janela) {}
    
    
    /**************Setters e Getters******************/

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getVelocidade() {
        return velocidade;
    }
    
    public int getDirecao() {
        return direcao;
    }

    public boolean isMovendo() {
        return movendo;
    }

    public void setMovendo(boolean movendo) {
        this.movendo = movendo;
    }
    
    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getVida() {
        return vida;
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }

    public AtaqueInimigo getAtaque() {
        return ataque;
    }

    public void setAtaque(AtaqueInimigo ataque) {
        this.ataque = ataque;
    }
    
    public boolean isHorizontal() {
        return horizontal;
    }
    
    ////////////////////////////////////////////////////////////
    //Para chefao 3 somente:
    public void setAtaques(LinkedList<AtaquePersonagem> ataques) {
        this.ataques = ataques;
    }
    
    public LinkedList<AtaquePersonagem> getAtaques() {
        return ataques;
    }
    ///////////////////////////////////////////////////////Q
    
}
