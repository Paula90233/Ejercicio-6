public abstract class Integracion implements Comparable<Integracion> {
	protected int id;
	protected String nombre;
	protected boolean activa;
	protected String estadoConexion;
	protected double latenciaProm;
	protected String configuracion;

	public Integracion(int id, String nombre, boolean activa, String estadoConexion, double latenciaProm, String configuracion){
		this.id = id;
		this.nombre = nombre;
		this.activa = activa;
		this.estadoConexion = estadoConexion;
		this.latenciaProm = latenciaProm;
		this.configuracion = configuracion;
	}
	public String consultarConfiguracion() {
		return configuracion;
	}

	public int compareTo(Integracion otra) {
		if (this.latenciaProm < otra.latenciaProm) {
        	return -1;
    	} 
		else if (this.latenciaProm > otra.latenciaProm) {
        	return 1;
   	 	} 
		else {
        	if (this.id < otra.id) {
           	 return -1;
        	} 
			else if (this.id > otra.id) {
            	return 1;
        	} 
			else {
            	return 0;
        	}
    	}
	}

	@Override
	public String toString() {
		return  "ID: " + id +
               " | Nombre: " + nombre +
               " | Activa: " + activa +
               " | Conexión: " + estadoConexion +
               " | Latencia: " + latenciaProm + " ms";
	}
}
