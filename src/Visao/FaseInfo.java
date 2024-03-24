package Visao;

import Modelo.Fase;
import Modelo.Inimigo;
import Modelo.Personagem;
import java.awt.Color;
import java.awt.Font;
import jplay.Window;

//Usada para printar informações nas fases relacionadas ao personagem e inimigos.

public class FaseInfo {
    
    public void updateFasesNormais(Window w, Personagem p) {
        
        w.update();
        p.draw();
     
    }
    
    public void drawInimigo(Inimigo i) {
        i.draw();
    }
    
    //Fase 1, 2 e 3.
    public void mostrarInformacoes(Window janela, Personagem personagem, int ini, int wave) {
        Font f = new Font("arial", Font.BOLD, 30);
        Font f1 = new Font("arial", Font.BOLD, 50);
        
        janela.drawText("Health:" + format(personagem.getVida()), 30, 30, Color.RED, f);
        janela.drawText("Enemies left:" + ini, 300, 30, Color.BLUE, f);
        janela.drawText("Wave:" + wave + "/" + Fase.getCont(), 600, 30, Color.BLACK, f);
        janela.drawText(personagem.getEstado().getDescricao(), 900, 40, Color.CYAN, f1);
    }
    
    //Fase Chefão 1.
    public void mostrarInformacoes1(Window janela, Personagem personagem, Inimigo ini, int time) {
        Font f = new Font("arial", Font.BOLD, 30);
        Font f1 = new Font("arial", Font.BOLD, 50);
        Font f2 = new Font("arial", Font.BOLD, 10);
        
        janela.drawText("Health:" + format(personagem.getVida()), 30, 45, Color.RED, f);
        janela.drawText("Saad Health:" + ini.getVida(), 800, 45, Color.BLUE, f);
        janela.drawText("TP Time:" + time + "/1000", 800, 70, Color.BLUE, f);
        janela.drawText(personagem.getEstado().getDescricao(), 400, 40, Color.CYAN, f1);
    }
     
    //Fase Chefão 2.
    public void mostrarInformacoes2(Window janela, Personagem personagem, Inimigo ini) {
        Font f = new Font("arial", Font.BOLD, 30);
        Font f1 = new Font("arial", Font.BOLD, 50);
        Font f2 = new Font("arial", Font.BOLD, 10);
        
        janela.drawText("Health:" + format(personagem.getVida()), 30, 45, Color.RED, f);
        janela.drawText("Monster Health:" + ini.getVida(), 800, 45, Color.BLUE, f);
        janela.drawText("Monster Attack:" + ini.getAtaque().getDano(), 800, 70, Color.BLUE, f);
        janela.drawText(personagem.getEstado().getDescricao(), 400, 40, Color.CYAN, f1);
    }
    
    //Fase Chefão 3.
    public void mostrarInformacoes3(Window janela, Personagem personagem, Inimigo ini) {
        Font f = new Font("arial", Font.BOLD, 30);
        Font f1 = new Font("arial", Font.BOLD, 50);
        Font f2 = new Font("arial", Font.BOLD, 10);
        
        janela.drawText("Health:" + format(personagem.getVida()), 30, 45, Color.RED, f);
        janela.drawText("Batman Health:" + ini.getVida(), 800, 45, Color.BLUE, f);
        janela.drawText(personagem.getEstado().getDescricao(), 400, 40, Color.CYAN, f1);
    }
    
    //Fase 4.
    public void mostrarInformacoes4(Window janela, Personagem personagem, Inimigo ini1, Inimigo ini2, Inimigo ini3) {
        Font f = new Font("arial", Font.BOLD, 30);
        
        janela.drawText("Player Health: " + format(personagem.getVida()), 30, 45, Color.RED, f);
        janela.drawText("Saad Health: " + ini1.getVida(), 400, 45, Color.BLUE, f);
        janela.drawText("Monster Health: " + ini2.getVida(), 700, 45, Color.BLUE, f);
        janela.drawText("Batman Health: " + ini3.getVida(), 550, 75, Color.BLUE, f);
    }
    
    //Fase Survival.
    public void mostrarInformacoes5(Window janela, Personagem personagem, int n, int wave) {
        Font f = new Font("arial", Font.BOLD, 30);
        Font f1 = new Font("arial", Font.BOLD, 50);
        
        janela.drawText("Health:" + format(personagem.getVida()), 30, 30, Color.RED, f);
        janela.drawText("Enemies killed:" + n, 300, 30, Color.BLUE, f);
        janela.drawText("Wave:" + wave, 600, 30, Color.BLACK, f);
        janela.drawText(personagem.getEstado().getDescricao(), 900, 40, Color.CYAN, f1);
    }
    
    //Fase Multiplayer.
    public void mostrarInformacoes6(Window janela, Personagem player1, Personagem player2, int score) {
        Font f = new Font("arial", Font.BOLD, 30);
        
        janela.drawText("Player 1:  " + format(player1.getVida()), 30, 30, Color.RED, f);
        janela.drawText("Player 2:  " + format(player2.getVida()), 630, 30, Color.RED, f);
        janela.drawText("Score:  " + score, 330, 30, Color.BLACK, f);
        
    }
    
    public static String format(double x) {
        return String.format("%.0f", x);
    }
    
}
