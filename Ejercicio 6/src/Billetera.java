public class Billetera extends Integracion implements Transaccional, Auditable, Consultable {
	private String historial = "";
	
	public Billetera(int id, String nombre, boolean activa, String estadoConexion, double latenciaProm, String configuracion){
		super(id, nombre, true,"Conectada", latenciaProm, configuracion);
	}

	@Override
	public String cobrar(double monto){
		return "Cobro de Q" + monto + " realizado con billetera digital.";
	}
	
	public String reintegrar(double monto){
		return "Reintegro de Q" + monto + " realizado a la billetera.";
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
		return monto * 0.02;
	}
}
