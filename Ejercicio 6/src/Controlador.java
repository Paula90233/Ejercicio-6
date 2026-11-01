import java.util.ArrayList;
public class Controlador {
	private RegistroIntegraciones registro;
	private Vista vista;

	public Controlador() {
        registro = new RegistroIntegraciones();
        vista = new Vista();
    }

	public void iniciar() {
		registro.cargarInicial();
        int opcion = 0;
        while (opcion != 6) {
            opcion = vista.mostrarMenu();
            procesarOpcion(opcion);
        }
	}

	public void procesarOpcion(int opcion) {
		Integracion integracion;
        ArrayList<Integracion> integraciones;

        switch (opcion) {
            case 1:
                integraciones = registro.listarActivas();
                vista.mostrarIntegraciones(integraciones);
                break;
            case 2:
                integracion = registro.buscarPorId(vista.pedirId());
                if (integracion != null) {
                    vista.mostrarMensaje(integracion.toString());
                    vista.mostrarConfiguracion(integracion);
                } 
				else {
                    vista.mostrarMensaje("No se encontró la integración.");
                }
                break;
            case 3:
                registro.ordenarPorLatencia();
                vista.mostrarMensaje("Integraciones ordenadas por latencia.");
                vista.mostrarIntegraciones(registro.listarActivas());
                break;
            case 4:
                integracion = registro.buscarPorId(vista.pedirId());
                if (integracion != null) {
                    mostrarOperaciones(integracion);
                } 
				else {
                    vista.mostrarMensaje("No se encontró la integración.");
                }
                break;
            case 5:
                integracion = registro.buscarPorId(vista.pedirId());
                if (integracion != null) {
                    ejecutarOperacion(integracion);
                } 
				else {
                    vista.mostrarMensaje("No se encontró la integración.");
                }
                break;
            case 6:
                vista.mostrarMensaje("Saliendo del sistema...");
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
	}

	public void mostrarOperaciones(Integracion integracion) {
		vista.mostrarMensaje("Operaciones disponibles para "+ integracion.nombre + ":");

        if (integracion instanceof Consultable) {
            vista.mostrarMensaje("- Consultar estado y cotizar.");
        }
        if (integracion instanceof Transaccional) {
            vista.mostrarMensaje("- Cobrar y reintegrar.");
        }
        if (integracion instanceof Documentable) {
            vista.mostrarMensaje("- Generar documento.");
        }
        if (integracion instanceof Auditable) {
            vista.mostrarMensaje("- Registrar eventos y consultar historial.");
        }
	}

	public void ejecutarOperacion( Integracion integracion) {
		int opcion = vista.pedirOperacion();
        double monto;
        String resultado;

        switch (opcion) {
            case 1:
                if (integracion instanceof Consultable) {
                    resultado = ((Consultable) integracion).consultarEstado();
                    vista.mostrarMensaje("Estado: " + resultado);
                } 
				else {
                    vista.mostrarMensaje("Operación no disponible.");
                }
                break;
            case 2:
                if (integracion instanceof Consultable) {
                    monto = vista.pedirMonto();
                    double cotizacion = ((Consultable) integracion).cotizar(monto);
                    vista.mostrarMensaje("Cotización: Q" + cotizacion);
                } 
				else {
                    vista.mostrarMensaje("Operación no disponible.");
                }
                break;
            case 3:
                if (integracion instanceof Transaccional) {
                    monto = vista.pedirMonto();
                    resultado = ((Transaccional) integracion).cobrar(monto);
                    vista.mostrarMensaje(resultado);
                } 
				else {
                    vista.mostrarMensaje("Operación no disponible.");
                }
                break;
            case 4:
                if (integracion instanceof Transaccional) {
                    monto = vista.pedirMonto();
                    resultado = ((Transaccional) integracion).reintegrar(monto);
                    vista.mostrarMensaje(resultado);
                } 
				else {
                    vista.mostrarMensaje("Esta integración no permite reintegros.");
                }
                break;
            case 5:
                if (integracion instanceof Documentable) {
                    String datos = vista.pedirDatos();
                    resultado = ((Documentable) integracion).generarDocumento(datos);
                    vista.mostrarMensaje(resultado);
                } 
				else {
                    vista.mostrarMensaje("Operación no disponible.");
                }
                break;
            case 6:
                if (integracion instanceof Auditable) {
                    resultado = ((Auditable) integracion).consultarHistorial();
                    vista.mostrarMensaje("Historial:\n" + resultado);
                } 
				else {
                    vista.mostrarMensaje("Operación no disponible.");
                }
                break;
            case 7:
                if (integracion instanceof Auditable) {
                    String evento = vista.pedirDatos();
                    ((Auditable) integracion).registrarEventos(evento);
                    vista.mostrarMensaje("Evento registrado.");
                } 
				else {
                    vista.mostrarMensaje("Operación no disponible.");
                }
                break;
            default:
                vista.mostrarMensaje("Operación no válida.");
        }
    }
}

