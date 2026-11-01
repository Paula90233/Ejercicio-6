public class ProveedorLogistico extends Integracion implements Auditable, Consultable, Documentable {
	private String historial = "";

	public ProveedorLogistico(int id, String nombre, double latenciaProm, String configuracion) {
        super(id, nombre, true, "Conectada", latenciaProm, configuracion);
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
		return monto * 0.05;
	}

	public String generarDocumento(String datos){
		return "Guía de envío generada con los datos: " + datos;
	}
}
