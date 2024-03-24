package Visao;

import Controle.ControleTela;
import Modelo.FabricaPersonagem;
import Modelo.Jogo;
import jplay.Sound;
import jplay.Sprite;
import jplay.Window;

//Padrão Arquitetural MVC => View.

public class TelaInicial
{
        Window window;
        Sprite backGround;
        int opcaoEscolhida = 0;
        Sound musica;
        
        private ControleTela controle;

        public TelaInicial(Window window)
        {
            this.window = window;
            carregarObjetos();
            loop();
            descarregarObjetos();
        }

        private void carregarObjetos()
        {
                //window = new Window(1180, 700);
                
                backGround = new Sprite("src\\sprites\\menu.png", 3);

                this.controle = new ControleTela(window,this,null,null);
            
        }
        
        private void desenhar()
        {
                backGround.draw();
                window.display();        
        }
        
        private void verificarOpcaoEscolhida()
        {                
            
            controle.opcaoTelaInicial();
                
            backGround.setCurrFrame(opcaoEscolhida);
        }
        
        private void descarregarObjetos()
        {                        
                window.exit();
                window = null;
                backGround = null;
        }


        private void loop()
        {
                boolean sair = false;
                do
                {
                        desenhar();
                        verificarOpcaoEscolhida();
                        
                        controle.escolherModo(window);
                        
                }while(sair == false);
        }
        
        public void modoArcade()
        {
            //ESCOLHER DIFICULDADE
            
            new TelaDificuldade(window);
        }
        
        public void modoMultiplayer()
        {
            new Jogo(window, backGround, 3, FabricaPersonagem.criarPersonagem(window,1));;
        
        }
        
        public void modoSurvival()
        {
             new TelaPersonagem(window);
        
        }
        
        public void setOpcao(int x) {
            this.opcaoEscolhida = x;
        }
        
        public int getOpcao() {
            return opcaoEscolhida;
        }
}
