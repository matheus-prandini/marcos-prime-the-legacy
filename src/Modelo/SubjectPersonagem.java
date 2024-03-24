package Modelo;

//Padrão Obsever => Subject.

public interface SubjectPersonagem {
    
    public void adicionarObservador(ObserverInimigo o);
    public void removerObservador(ObserverInimigo o);
    public void atualizarObservadores();
    public double getX();
    public double getY();
    
}
