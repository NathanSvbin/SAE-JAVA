package graphes;

public interface IGraphe {
	public void ajouterSommet(String nom);
	public void ajouterArc(String de, String vers, String etiquette);
	public boolean getArcs(String de, String vers);
	public String getValeurArcs(String de, String vers);
}
