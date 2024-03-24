package Modelo;

//Chefão Saad.

public class Chefao1 extends Inimigo {

    //Construtor:
    public Chefao1(int x, int y) {
        super("src\\sprites\\saad.png", 20); //Imagem do sprite e número de frames da imagem.
        setX(x);
        setY(y);
        setTotalDuration(2000); //Duração ds frames
        setAtaque(new ForcaBruta());
    }
    
    //Teletransporta no cenário caso não estiver atacando o personagem de tempo em tempo:
    public void teletransportar(Personagem p) {
        
        if((getStatus() == true) && (this.collided(p) == false)) {
          
            int x, y;
        
            if(p.getY() >= 500) { //metade da tela para baixo no eixo Y
                if(p.getX() <= 600) //metade da tela para esquerda no eixo X
                    this.x = p.getX() + 100;
                else //metade da tela para direita no eixo X
                    this.x = p.getX();
                
                this.y = p.getY() - 200;
            }
            else { //metade da tela para cima no eixo Y
                if(p.getX() <= 600) 
                    this.x = p.getX() + 200;
                else
                    this.x = p.getX();
                
                this.y = p.getY() + 100;
            }
        }
    }
    
}
