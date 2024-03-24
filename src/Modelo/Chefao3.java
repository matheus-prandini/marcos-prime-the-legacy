package Modelo;

import java.util.LinkedList;
import jplay.Scene;
import jplay.Window;

//Chefão Batman.

public class Chefao3 extends Inimigo {
    
    private AtaquePersonagem ataque; //Ataques que serão armazenadas na Lista de "Ataques" do chefão => Boomerangues.
    
    public Chefao3(int x, int y, double velAtaque) {
        super("src\\sprites\\batman.png", 20); //Imagem do sprite e número de frames da imagem.
        setX(x);
        setY(y);
        setTotalDuration(2000); //Duração dos frames.
        setAtaques(new LinkedList<AtaquePersonagem>());
        this.ataque = new Boomerangue(getX(),getY(),getDirecao());
        this.ataque.setVelocidade(velAtaque);
    }
    
    public void atacar1(Window janela, Scene cenario, Personagem p) {
        
        adicionaAtaque(getX()+13, getY()+16, getDirecao(), cenario);
        
        run(p, cenario, janela);
        
    }
    
    //Novo ataque disparado:
    public void adicionaAtaque(double x, double y, int caminho, Scene cenario) {
        
        AtaquePersonagem ataque = new Boomerangue(x,y,caminho);
        
        ataque.setVelocidade(this.ataque.getVelocidade()) ; //Ataque referenciado aqui
        
        getAtaques().addFirst(ataque); //Adiciona na lista.
        cenario.addOverlay(ataque); //Adiciona no cenário.
  
    }
    
    //Função do ataque enquanto está sendo executado:
    public void run(Personagem p, Scene cenario, Window janela) {
        
        for(int i = 0; i < getAtaques().size(); i++) {
            
            AtaquePersonagem ataque = getAtaques().removeFirst();
            ataque.movimento(); //Movimento do ataque.
            ataque.caminho(cenario); //Colisão com cenário.
            ataque.ataqueCoordenadas(janela); //Verifica se saiu da tela.
            getAtaques().addLast(ataque);
         
            if(ataque.collided(p)) {
                ataque.x = 2000000;
                ataque.y = 2000000;
                ataque.setStatus(false);
                p.setVida(p.getVida()-ataque.getDano());
            }
            
            //ataque.inimigo(ini, ataque); //Verifica se colidiu com inimigo.
            
            if(ataque.isStatus() == false) //Se status for falso, remove da lista.
                getAtaques().remove(ataque);
            
        }
        
    }
    
}
