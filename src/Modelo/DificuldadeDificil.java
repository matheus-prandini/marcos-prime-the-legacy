package Modelo;

import java.util.ArrayList;
import jplay.Window;

//Padrão Abstract Factory => Concrete Factory.

public class DificuldadeDificil extends DificuldadeFactory {
    
    //SINGLETON
    private static DificuldadeFactory instancia = new DificuldadeDificil();
       
        private DificuldadeDificil () { 
            super();
        }
        
        public static DificuldadeFactory getInstancia() {
            return instancia;
        }
     //
    
    public void setarFases() {
        
        Fase.setNum_ini(30);
        Fase.setCont(5);
    }

    public ArrayList<Fase> criarFases(Window janela) {
        
        ArrayList<Fase> fases = new ArrayList<Fase>();
        
        Personagem personagem = FabricaPersonagem.criarPersonagem(janela,1);
        
        //fases.add(new FaseInicial1(janela, personagem));
        fases.add(FabricaFase.gerarFase(janela, personagem, 1));
        fases.add(FabricaFase.gerarFaseChefao(janela, personagem, instancia, 1));
        
        return fases;
        
    }

    public ArrayList<Fase> criarFases2(Window janela) {
        
        ArrayList<Fase> fases = new ArrayList<Fase>();
        
        Personagem personagem = FabricaPersonagem.criarPersonagem(janela,2);
        
        //fases.add(new FaseInicial2(janela, personagem, 150, 400));
        fases.add(FabricaFase.gerarFase(janela, personagem, 2));
        fases.add(FabricaFase.gerarFaseChefao(janela, personagem, instancia, 2));
        
        return fases;
        
    }

    public ArrayList<Fase> criarFases3(Window janela) {
          
        ArrayList<Fase> fases = new ArrayList<Fase>();
        
        Personagem personagem = FabricaPersonagem.criarPersonagem(janela,3);
        
        //fases.add(new FaseInicial3(janela, personagem, 480, 0));
        fases.add(FabricaFase.gerarFase(janela, personagem, 3));
        fases.add(FabricaFase.gerarFaseChefao(janela, personagem, instancia, 3));
        
        return fases;
        
    }

    public Fase criarFase4(Window janela) {
        
        Personagem personagem = FabricaPersonagem.criarPersonagem(janela,4);
        
        Fase fase;
       
        Fase.setId(4);
        
        ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();
        
        inimigos.add(criarChefao1());
        inimigos.add(criarChefao2());
        inimigos.add(criarChefao3());
        
        fase = new Fase4(janela, personagem, inimigos);
        
        return fase;
    }

    public Chefao1 criarChefao1() {
        
        //Chefao Fase 1:
        Chefao1 chefao = new Chefao1(500,100);
        chefao.setVelocidade(0.5);
        chefao.setVida(1000);
        chefao.getAtaque().setDano(5);
        
        return chefao;
        
    }

    public Chefao2 criarChefao2() {
        
        //Chefao Fase 2:
        Chefao2 chefao = new Chefao2(500,100);
        chefao.setVelocidade(0.4);
        chefao.setVida(5000);
        chefao.getAtaque().setDano(10);
        
        return chefao;
        
    }

    public Chefao3 criarChefao3() {
        
        //Chefao Fase 3:
        Chefao3 chefao = new Chefao3(500,100,2);
        chefao.setVelocidade(0.3);
        chefao.setVida(3000);
        
        return chefao;
        
    }

    
}
