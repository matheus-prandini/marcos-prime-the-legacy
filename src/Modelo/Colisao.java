package Modelo;

import jplay.GameObject;
import jplay.TileInfo;

//Responsável por identificar colisões nas fases com relação aos personagens, inimigos e ataques disparados.

public class Colisao {
    
    //GameObject obj = Personagem
    //TileInfo tile = Objeto que constitui cenário
    public boolean verificaColisao(GameObject obj, TileInfo tile) {
        
        //Fase Bar
        if(Fase.getId() == 1) {
            
            //Verifica se personagem colidiu com algo no cenário que não pode atravressar.
            if((tile.id > 2) && obj.collided(tile)) { 
                return true;
            }
            
        }
        
        //Fase Cidade
        else if(Fase.getId() == 2) {
            
            //Verifica se personagem colidiu com algo no cenário que não pode atravressar.
            if((tile.id > 13) && obj.collided(tile)) { 
                return true;
            }
 
        }
        
        //Fase Lua
        else if(Fase.getId() == 3) {
            
            //Verifica se personagem colidiu com algo no cenário que não pode atravressar.
            if((tile.id > 2) && obj.collided(tile)) { 
                return true;
            }
 
        }
        
        //Fase Espaço
        else if(Fase.getId() == 4) {
            
            //Verifica se personagem colidiu com algo no cenário que não pode atravressar.
            if((tile.id > 1) && obj.collided(tile)) { 
                return true;
            }
 
        }
        
        return false;
    }
    
}
