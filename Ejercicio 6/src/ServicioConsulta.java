public class ServicioConsulta extends Integracion implements Consultable {
	public ServicioConsulta(int id, String nombre, double latenciaProm, String configuracion) {
        super(id, nombre, true, "Conectada", latenciaProm, configuracion);
    }

	public String consultarEstado(){
		return estadoConexion;
	}

	public double cotizar(double monto){
		return 0;
	}
}
