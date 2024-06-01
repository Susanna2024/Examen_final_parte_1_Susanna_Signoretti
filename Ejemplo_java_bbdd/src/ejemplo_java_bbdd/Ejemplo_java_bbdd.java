package ejemplo_java_bbdd;

import java.util.List;

public class Ejemplo_java_bbdd {


    public static void main(String[] args) {
        // Crear una instancia del DAO de veh�culos
        vehiculoDAO vehiculoDAO = new vehiculoDAO();

        // Consultar todos los veh�culos
        System.out.println("Todos los veh�culos:");
        List<vehiculo> todosLosVehiculos = vehiculoDAO.consultarTodosVehiculos();
        for (vehiculo v : todosLosVehiculos) {
            System.out.println(v);
        }
        System.out.println();

        // Consultar un veh�culo por su ID
        System.out.println("Veh�culo con ID 2:");
        vehiculo vehiculoPorId = vehiculoDAO.consultarVehiculoPorId(2);
        System.out.println(vehiculoPorId);
        System.out.println();

        // Insertar un nuevo veh�culo
        System.out.println("Insertar un nuevo veh�culo:");
        vehiculo nuevoVehiculo = new vehiculo(33, "moto", "Honda", 120, new java.sql.Date(System.currentTimeMillis()));
        boolean insercionExitosa = vehiculoDAO.insertarNuevoVehiculo(nuevoVehiculo);
        if (insercionExitosa) {
            System.out.println("Nuevo veh�culo insertado correctamente.");
        } else {
            System.out.println("Error al insertar el nuevo veh�culo.");
        }
        System.out.println();

        // Eliminar un veh�culo por su ID
        System.out.println("Eliminar el veh�culo con ID 3:");
        boolean eliminacionExitosa = vehiculoDAO.eliminarVehiculoPorId(3);
        if (eliminacionExitosa) {
            System.out.println("Veh�culo eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el veh�culo.");
        }
        System.out.println();

        // Actualizar los datos de un veh�culo
        System.out.println("Actualizar los datos del veh�culo con ID 4:");
        vehiculo vehiculoParaActualizar = vehiculoDAO.consultarVehiculoPorId(4);
        vehiculoParaActualizar.setMarca("Renault");
        boolean actualizacionExitosa = vehiculoDAO.actualizarDatosVehiculo(vehiculoParaActualizar);
        if (actualizacionExitosa) {
            System.out.println("Datos del veh�culo actualizados correctamente.");
        } else {
            System.out.println("Error al actualizar los datos del veh�culo.");
        }
        System.out.println();

        // Obtener la potencia media seg�n el tipo de veh�culo
        System.out.println("Potencia media de coches: " + vehiculoDAO.obtenerPotenciaMediaSegunTipoVehiculo("coche"));
        System.out.println("Potencia media de motos: " + vehiculoDAO.obtenerPotenciaMediaSegunTipoVehiculo("moto"));
        System.out.println();

        // Obtener la potencia m�xima seg�n el tipo de veh�culo
        System.out.println("Potencia m�xima de barcos: " + vehiculoDAO.obtenerPotenciaMaximaSegunTipoVehiculo("barco"));
        System.out.println("Potencia m�xima de camiones: " + vehiculoDAO.obtenerPotenciaMaximaSegunTipoVehiculo("camion"));
    }
}
