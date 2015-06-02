package ejercicio1;

public class Concursante {
	//Atributos
	private String cancion;
	private String pais;
	private String interprete;
	private int puntuacion;
		
	/**
	 * @param cancion
	 * @param pais
	 * @param interprete
	 * @param puntuacion
	 */
	public Concursante(String pais, String interprete, String cancion, int puntuacion) {
		this.cancion = cancion;
		this.pais = pais;
		this.interprete = interprete;
		this.puntuacion = puntuacion;
	}
	/**
	 * @return the cancion
	 */
	public String getCancion() {
		return cancion;
	}
	/**
	 * @param cancion the cancion to set
	 */
	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the interprete
	 */
	public String getInterprete() {
		return interprete;
	}
	/**
	 * @param interprete the interprete to set
	 */
	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}
	/**
	 * @return the puntuacion
	 */
	public int getPuntuacion() {
		return puntuacion;
	}
	/**
	 * @param puntuacion the puntuacion to set
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concursante cancion=" + cancion + ", pais=" + pais
				+ ", interprete=" + interprete + ", puntuacion=" + puntuacion;
	}
	
}
