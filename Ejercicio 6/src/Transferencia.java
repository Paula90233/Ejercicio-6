public class Transferencia extends Integracion implements Auditable, Consultable, Transaccional {
	private String historial = "";

    public Transferencia(int id, String nombre, double latenciaProm, String configuracion) {
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
		return monto * 0.01;
	}

	public String cobrar(double monto){
		return "Transferencia de Q" + monto + " realizada.";
	}

	public String reintegrar(double monto){
		return "Reintegro de Q" + monto + " realizado.";
	}
}
