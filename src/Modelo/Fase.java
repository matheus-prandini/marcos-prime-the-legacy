package Modelo;

import Visao.FaseInfo;
import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.TileInfo;
import jplay.Window;

public abstract class Fase {
    
    private Window janela;
    private Scene cenario; 
    private Personagem personagem;
    private boolean executando;
    private static int num_ini;
    private static int cont;
    private static int id;
    
    protected FaseInfo info;
    
    public Fase() {
        
        this.info = new FaseInfo();
        
    }
    
    //Colisão do personagem com um determinado tile de um cenário:
    protected boolean colisaoTile(int valor, Personagem p, Scene cenario) {
        
        Point min = new Point((int)p.x, (int)p.y);
        Point max = new Point((int)p.x + p.width, (int)p.y + p.height);
        
        Vector tiles = cenario.getTilesFromPosition(min, max);
        
        for(int i = 0; i < tiles.size(); i++) {
            
            TileInfo tile = (TileInfo) tiles.elementAt(i);
            
            if(colisaoTile(p, tile, valor) == true) {
                return true;
            }
            
        }
        
        return false;
    }
   
    //Verifica se o gameobject colidiu com um tile:
    protected boolean colisaoTile(GameObject object, TileInfo tile, int valor) {
        
        if((tile.id == valor) && object.collided(tile)) {
            return true;
        }
        
        return false;
        
    }
     
    public abstract void run();
    
    /*****************************************************Setters e Getters************************************/
    
    public void setJanela(Window janela) {
        this.janela = janela;
    }

    public void setCenario(Scene cenario) {
        this.cenario = cenario;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

    public Window getJanela() {
        return janela;
    }

    public Scene getCenario() {
        return cenario;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public boolean isExecutando() {
        return executando;
    }

    public static int getNum_ini() {
        return num_ini;
    }

    public static void setNum_ini(int aNum_ini) {
        num_ini = aNum_ini;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int aCont) {
        cont = aCont;
    }
    
    public static void setId(int aid) {
        id = aid;
    }
    
    public static int getId() {
        return id;
    }
    
}
