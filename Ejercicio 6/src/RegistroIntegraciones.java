import java.util.ArrayList;
public class RegistroIntegraciones {
	private ArrayList<Integracion> integraciones;

	public RegistroIntegraciones() {
        integraciones = new ArrayList<Integracion>();
    }

	public void cargarInicial() {
		integraciones.add(new Tarjeta(1, "Visa", 120, "API Visa"));
        integraciones.add(new Tarjeta(2, "Mastercard", 150, "API Mastercard"));

        integraciones.add(new Transferencia(3, "Banco Industrial", 180,"API Banco Industrial"));
        integraciones.add(new Transferencia(4, "Banrural", 200,"API Banrural"));

        integraciones.add(new Billetera(5, "PayPal", true, "Conectada", 100, "API PayPal"));
        integraciones.add(new Billetera(6, "Google Pay", true, "Conectada", 130, "API Google Pay"));

        integraciones.add(new ProveedorLogistico(7, "Cargo Expreso", 250,"API Cargo Expreso"));
        integraciones.add(new ProveedorLogistico(8, "DHL", 220, "API DHL"));

        integraciones.add(new Certificador(9, "Certificador FEL", 170,"API FEL"));

        integraciones.add(new ServicioConsulta(10, "Servicio de consulta", 90, "API de consulta"));
	}

	public ArrayList<Integracion> listarActivas() {
		ArrayList<Integracion> activas = new ArrayList<Integracion>();
        for (int i = 0; i < integraciones.size(); i++) {
            if (integraciones.get(i).activa) {
                activas.add(integraciones.get(i));
            }
        }
        return activas;
	}

	public Integracion buscarPorId(int id) {
		Integracion encontrada = null;
        for (int i = 0; i < integraciones.size(); i++) {
            if (integraciones.get(i).id == id) {
                encontrada = integraciones.get(i);
            }
        }
        return encontrada;
	}

	public void ordenarPorLatencia() {
		Integracion temporal;
        for (int i = 0; i < integraciones.size() - 1; i++) {
            for (int j = i + 1; j < integraciones.size(); j++) {
                if (integraciones.get(i).compareTo(integraciones.get(j)) > 0) {
                    temporal = integraciones.get(i);
                    integraciones.set(i, integraciones.get(j));
                    integraciones.set(j, temporal);
                }
            }
        }
	}

	public void agregarIntegracion(Integracion integracion) {
		integraciones.add(integracion);
	}
}
