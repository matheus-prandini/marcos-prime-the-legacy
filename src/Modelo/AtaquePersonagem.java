package Modelo;

import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.TileInfo;
import jplay.Window;


//Relacionada aos ataques dos personagens.

//Padrão Strategy => Strategy

public abstract class AtaquePersonagem extends Ataque {
    
    //Variáveis para o tipo caminho: Static e final
    public static final int left = 1, right = 2, stop = 3, up = 4, down = 5; 
    
    private boolean movendo; //True: movimentando na tela. Falso: Não movimentando.
    private boolean status; // True: visível na tela. Falso: Não visível na tela. 
    private double velocidade; //Velocidade do Ataque na tela.
    private int caminho; // Direção do ataque.
    private int dano; //Dano ataque
    private int id;
    Colisao controle; //Trata de colisão com obstáculos no cenário
    
    
    //Construtor ataque do personagem:
    public AtaquePersonagem(double x, double y, int caminho, String imagem) {
       
        super(imagem);  //Sprite do ataque juntamente com o número de frames da imagem.
        this.x = x; //Cordenada X.
        this.y = y; //Coordenada Y.
        this.caminho = caminho;
        this.status = true;
        this.movendo = false;
        this.controle = new Colisao();
    }
   
    
    //Função que define o movimento do ataque:
    public void movimento() {
        
        if(getCaminho() == left) { //Ataque para a esquerda.
            
            this.x = this.x - getVelocidade(); //Ataque  move para a esquerda do cenário.
           
            if(this.id != 3)
                setSequence(6,9); //Animação para esquerda do sprite de ataque.
            else
                setSequence(3,6);
            
            setMovendo(true);
        }
        
        if(getCaminho() == right) { //Ataque para a direita.
            
            this.x = this.x + getVelocidade(); //Ataque move para a direita do cenário.
           
            if(this.id != 3)
                setSequence(3,6); //Animação para direita do sprite de ataque.
            else
                setSequence(6,9);
            
            setMovendo(true);
        }
        
        if(getCaminho() == up) { //Ataque para cima.
            
            this.y = this.y - getVelocidade(); //Ataque move para cima do cenári.
           
            if(this.id != 3)
                setSequence(0,3); //Animação para cima do sprite de ataque.
            else
                setSequence(9,12);
            
            setMovendo(true);
        }
        
        if(getCaminho() == down) { //Ataque para baixo.
            
            this.y = this.y + getVelocidade(); //Ataque move para baixo do cenário.
           
            if(this.id != 3)
                setSequence(9,12); //Animação para baixo do sprite de ataque.
            else
                setSequence(0,3);
            
            setMovendo(true);
        }
        
        if(isMovendo()) {
            update();
            setMovendo(false);
        }
        
    }
    
    //Trata de todas as colisões do ataque com os obstáculos do cenário:
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
                        this.x = 20000000;
                        this.y = 20000000;
                        this.status = false;
                    }
                    else if(tile.y > this.y + (this.height-1.5)) { // Cima - Baixo
                        this.x = 20000000;
                        this.y = 20000000;
                        this.status = false;
                    }
                }
                if(colisaoHorizontal(this,tile)) {
                    
                    if(tile.x > this.x + (this.width-1.5)) {
                       this.x = 20000000;
                       this.y = 20000000;
                       this.status = false;
                    }
                    else if(tile.x + (tile.width-1.5) < this.x) {
                        this.x = 20000000;
                        this.y = 20000000;
                        this.status = false;
                    }
                    
                }
                
            }
            
        }
        
    }
    
    //Verifica colisão no eixo y com algum obstáculo do cenário:
    private boolean colisaoVertical(GameObject obj, GameObject obj2) {
        
        if(obj2.x + obj2.width <= obj.x) {
            return false;
        }
        
        if(obj.x + obj.width <= obj2.x) {
            return false;
        }
        
        return true; 
        
    }
    
    //Verifica colisão no eixo x com algum obstáculo do cenário:
    private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
        
        if(obj2.y + obj2.height <= obj.y) {
            return false;
        }
        
        if(obj.y + obj.height <= obj2.y) {
            return false;
        }
        
        return true; //ocorreu colisão
        
    }
    
    //Verifica se o ataque saiu da tela:
    public void ataqueCoordenadas(Window janela) {
        
        if(this.x < 0 || this.x > janela.getWidth() || this.y < 0 || this.y > janela.getHeight()) {
            this.x = 2000000;
            this.y = 2000000;
            this.status = false;
        }
    }
    
    //Trata da colisão do ataque com o inimigo:
    public void inimigo(Inimigo ini, AtaquePersonagem ataque) {
        
        if(ataque.collided(ini)) {
                ataque.x = 2000000;
                ataque.y = 2000000;
                ataque.status = false;
                ini.setVida(ini.getVida()- (getDano()));
            }     
    }
    

   /*********************Setters e Getters****************************/
    
    public void setCaminho(int caminho) {
        this.caminho = caminho;
    }

    public void setMovendo(boolean movendo) {
        this.movendo = movendo;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public int getCaminho() {
        return caminho;
    }
    
    public boolean isMovendo() {
        return movendo;
    }

    public boolean isStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
