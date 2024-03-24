package Modelo;

import Controle.ControlePersonagem;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.Window;

//Padrão Obsever => Concrete Subject.

//Padrão State => Context.

public abstract class Personagem extends Sprite implements SubjectPersonagem {
    
    private double velocidade;
    private int direcao; //Para animacao de sprites
    private boolean movendo;
    private boolean horizontal;
    private Colisao controle;
    private ControlePersonagem controle_pers;
    private int id; //Id é a arma que o personagem irá utilizar
    private LinkedList<AtaquePersonagem> ataques;
    private ArrayList<ObserverInimigo> observadores;  //Padrão Observer.
    
    private PersonagemState estado; //Padrão State.
    
    private static final double vidaTotal = 1000;
    
    private double vida;
    
    public Personagem(int x, int y, String imagem, Window window) {
        
        super(imagem, 20);
        
        this.direcao = 3;
        this.movendo = false;
        this.horizontal = true;
        this.controle = new Colisao();
        this.ataques = new LinkedList<>();
        this.observadores = new ArrayList<ObserverInimigo>();
        this.x = x;
        this.y = y;
        this.vida = vidaTotal;
        this.controle_pers = new ControlePersonagem(window,this);
        this.estado = new NormalState(this);
        this.setTotalDuration(2000);
        
    }
    
    //Métodos relacionados ao padrão observer:
    //
    public void adicionarObservador(ObserverInimigo o) {
        
        getObservadores().add(o);
        
    }
    
    public void removerObservador(ObserverInimigo o) {
        
        getObservadores().remove(o);
        
    }
    
    public void atualizarObservadores() {
        
        for(ObserverInimigo o: getObservadores()) {
            o.atualizar(this);
        }
        
    }
    //Fim métodos relacionados a padrão observer
    
    //Aplicado o padrão MVC => ControleMovimento => Pacote Controle
    //
    public void movimentar(Window janela) {
        
        getControle_pers().movimentar(janela); 
        
    }
    
    //PLAYER 1
    public void movimentar1(Window janela) {
        
        getControle_pers().movimentar1(janela);
        
    }
 
    //PLAYER 2
    public void movimentar2(Window janela) {
        
        getControle_pers().movimentar2(janela);
        
    }
    //
    
    //Controle de caminho para tratar colisões
    public void caminho(Scene cenario) {
        
        Point min = new Point((int)this.x, (int)this.y);
        Point max = new Point((int)this.x+this.width, (int)this.y+this.height);
        
        Vector tiles = cenario.getTilesFromPosition(min, max);
     
        for (int i=0; i<tiles.size(); i++) {
            
            TileInfo tile = (TileInfo) tiles.elementAt(i);
            
            if(controle.verificaColisao(this, tile) == true) { //Verifica se colidiu
                
                if(this.isHorizontal() == true) {
                    
                    //Reposicionamento
                    if(this.x <= tile.x - 1) { //personagem atras da parede
                        this.x = tile.x - this.width;
                    }
                    else { // personagem na frente da parede
                        this.x = tile.x + tile.width;
                    }
                }
                else {
                    
                    if(this.y > tile.y + tile.height-1) { //player abaixo da parede
                       this.y = tile.y + tile.height; 
                    }
                    else { //acima da parede
                        this.y = tile.y - this.height;
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
    
    //Ataque Player 1:
    public void atacar(Window janela, Scene cenario, ControlePersonagem controle, Inimigo ini) {
        
        getEstado().atacar(janela, cenario, controle, ini, getId());
        
    }
    
    //Ataque Player 2:
    public void atacar2(Window janela, Scene cenario, ControlePersonagem controle, Inimigo ini) {
        
        getEstado().atacar2(janela, cenario, controle, ini, getId());
        
    }
    
    //Novo ataque disparado:
    public void adicionaAtaque(double x, double y, int caminho, Scene cenario, int n) {
        
        AtaquePersonagem ataque;
        
        ataque = verificaAtaque(x,y,caminho,n);
        
        getAtaques().addFirst(ataque); //Adiciona na lista.
        cenario.addOverlay(ataque); //Adiciona no cenário.
  
    }
    
    //Função do ataque enquanto está sendo executado:
    public void run(Inimigo ini, Scene cenario, Window janela) {
        
        for(int i = 0; i < getAtaques().size(); i++) {
            
            AtaquePersonagem ataque = getAtaques().removeFirst();
            ataque.movimento(); //Movimento do ataque.
            ataque.caminho(cenario); //Colisão com cenário.
            ataque.ataqueCoordenadas(janela); //Verifica se saiu da tela.
            getAtaques().addLast(ataque);
         
            ataque.inimigo(ini, ataque); //Verifica se colidiu com inimigo.
            
            if(ataque.isStatus() == false) //Se status for falso, remove da lista.
                getAtaques().remove(ataque);
            
        }
        
    }
    
    //A partir do id do personagem, atribui seu tipo de ataque.
    public AtaquePersonagem verificaAtaque(double x, double y, int caminho, int n) {
        
        if(n == 1) {
            
            return new GarrafaCerveja(x, y, caminho);
            
        }
        else if(n == 2) {
            
            return new Celular(x, y, caminho);
            
        }
        else if(n == 3) {
           
            return new RaioLaser(x, y, caminho);
            
        }
        else
            return null;
        
    }
    
    /***********************************************************Setters e Getters***********************************************/
    
     public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public void setVida(double vida) {
        this.vida = vida;
    }
    
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public void setMovendo(boolean movendo) {
        this.movendo = movendo;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public void setAtaques(LinkedList<AtaquePersonagem> ataques) {
        this.ataques = ataques;
    }

    public void setObservadores(ArrayList<ObserverInimigo> observadores) {
        this.observadores = observadores;
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

    public boolean isHorizontal() {
        return horizontal;
    }

    public LinkedList<AtaquePersonagem> getAtaques() {
        return ataques;
    }

    public ArrayList<ObserverInimigo> getObservadores() {
        return observadores;
    }
    
    public double getVida() {
        return vida;
    }

    public PersonagemState getEstado() {
        return estado;
    }

    public void setEstado(PersonagemState estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ControlePersonagem getControle_pers() {
        return controle_pers;
    }

    public void setControle_pers(ControlePersonagem controle_pers) {
        this.controle_pers = controle_pers;
    }
    
}
