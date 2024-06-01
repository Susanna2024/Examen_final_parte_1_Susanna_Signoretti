package ejemplo_java_bbdd;

import java.util.List;

public class Ejemplo_java_bbdd {


    public static void main(String[] args) {
        // Crear una instancia del DAO de vehículos
        vehiculoDAO vehiculoDAO = new vehiculoDAO();

        // Consultar todos los vehículos
        System.out.println("Todos los vehículos:");
        List<vehiculo> todosLosVehiculos = vehiculoDAO.consultarTodosVehiculos();
        for (vehiculo v : todosLosVehiculos) {
            System.out.println(v);
        }
        System.out.println();

        // Consultar un vehículo por su ID
        System.out.println("Vehículo con ID 2:");
        vehiculo vehiculoPorId = vehiculoDAO.consultarVehiculoPorId(2);
        System.out.println(vehiculoPorId);
        System.out.println();

        // Insertar un nuevo vehículo
        System.out.println("Insertar un nuevo vehículo:");
        vehiculo nuevoVehiculo = new vehiculo(33, "moto", "Honda", 120, new java.sql.Date(System.currentTimeMillis()));
        boolean insercionExitosa = vehiculoDAO.insertarNuevoVehiculo(nuevoVehiculo);
        if (insercionExitosa) {
            System.out.println("Nuevo vehículo insertado correctamente.");
        } else {
            System.out.println("Error al insertar el nuevo vehículo.");
        }
        System.out.println();

        // Eliminar un vehículo por su ID
        System.out.println("Eliminar el vehículo con ID 3:");
        boolean eliminacionExitosa = vehiculoDAO.eliminarVehiculoPorId(3);
        if (eliminacionExitosa) {
            System.out.println("Vehículo eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el vehículo.");
        }
        System.out.println();

        // Actualizar los datos de un vehículo
        System.out.println("Actualizar los datos del vehículo con ID 4:");
        vehiculo vehiculoParaActualizar = vehiculoDAO.consultarVehiculoPorId(4);
        vehiculoParaActualizar.setMarca("Renault");
        boolean actualizacionExitosa = vehiculoDAO.actualizarDatosVehiculo(vehiculoParaActualizar);
        if (actualizacionExitosa) {
            System.out.println("Datos del vehículo actualizados correctamente.");
        } else {
            System.out.println("Error al actualizar los datos del vehículo.");
        }
        System.out.println();

        // Obtener la potencia media según el tipo de vehículo
        System.out.println("Potencia media de coches: " + vehiculoDAO.obtenerPotenciaMediaSegunTipoVehiculo("coche"));
        System.out.println("Potencia media de motos: " + vehiculoDAO.obtenerPotenciaMediaSegunTipoVehiculo("moto"));
        System.out.println();

        // Obtener la potencia máxima según el tipo de vehículo
        System.out.println("Potencia máxima de barcos: " + vehiculoDAO.obtenerPotenciaMaximaSegunTipoVehiculo("barco"));
        System.out.println("Potencia máxima de camiones: " + vehiculoDAO.obtenerPotenciaMaximaSegunTipoVehiculo("camion"));
    }
}
