import java.util.ArrayList;
import java.util.Scanner;
public class Vista {
	private Scanner entrada = new Scanner(System.in);
	public int mostrarMenu() {
		System.out.println("\n      SISTEMA DE INTEGRACIONES     ");
        System.out.println("1. Listar integraciones activas");
        System.out.println("2. Buscar integración por ID");
        System.out.println("3. Ordenar integraciones por latencia");
        System.out.println("4. Mostrar operaciones disponibles");
        System.out.println("5. Ejecutar operación");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        return entrada.nextInt();
	}

	public void mostrarIntegraciones(ArrayList<Integracion> integraciones) {
		for (Integracion integracion : integraciones) {
            System.out.println(integracion);
        }
	}

	public void mostrarConfiguracion(Integracion integracion) {
		 System.out.println("Configuración: "
                + integracion.consultarConfiguracion());
	}

	public void mostrarMensaje(Object mensaje) {
		System.out.println(mensaje);
	}

	public int pedirId() {
        System.out.print("Ingrese el ID de la integración: ");
        return entrada.nextInt();
    }

    public int pedirOperacion() {
        System.out.println("\nSeleccione la operación:");
        System.out.println("1. Consultar estado");
        System.out.println("2. Cotizar");
        System.out.println("3. Cobrar");
        System.out.println("4. Reintegrar");
        System.out.println("5. Generar documento");
        System.out.println("6. Consultar historial");
        System.out.println("7. Registrar evento");
        System.out.print("Opción: ");
        return entrada.nextInt();
    }

    public double pedirMonto() {
        System.out.print("Ingrese el monto: ");
        return entrada.nextDouble();
    }

    public String pedirDatos() {
        entrada.nextLine();
        System.out.print("Ingrese los datos: ");
        return entrada.nextLine();
    }
}
