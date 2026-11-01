public class Certificador extends Integracion implements Documentable, Auditable, Consultable {
	private String historial = "";

	public Certificador(int id, String nombre, double latenciaProm, String configuracion) {
        super(id, nombre, true, "Conectada", latenciaProm, configuracion);
    }

	public String generarDocumento(String datos){
		return "Documento FEL generado con los datos: " + datos;
	}

	public void registrarEventos(String evento){
		historial += evento + "\n";
	}

	public String consultarHistorial(){
		return historial;
	}

	public String consultarEstado(){
		return estadoConexion;
	}
	
	public double cotizar(double monto){
		return 0;
	}
}
