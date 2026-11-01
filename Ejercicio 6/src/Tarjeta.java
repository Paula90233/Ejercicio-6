public class Tarjeta extends Integracion implements Transaccional, Auditable, Consultable, Documentable {
	private String historial = "";

    public Tarjeta(int id, String nombre, double latenciaProm, String configuracion) {
        super(id, nombre, true, "Conectada", latenciaProm, configuracion);
    }

	public String cobrar(double monto){
		return "Cobro de Q" + monto + " realizado con tarjeta.";
	}
	
	public String reintegrar(double monto){
		return "Reintegro de Q" + monto + " realizado a la tarjeta.";
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
		return monto * 0.03;
	}
	
	public String generarDocumento(String datos){
		return "Comprobante de pago generado con los datos: " + datos;
	}
}
