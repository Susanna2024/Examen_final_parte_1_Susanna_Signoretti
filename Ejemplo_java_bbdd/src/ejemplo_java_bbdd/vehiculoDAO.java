package ejemplo_java_bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class vehiculoDAO {

    // Método para consultar todos los vehículos
    public List<vehiculo> consultarTodosVehiculos() {
        List<vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculos";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                vehiculo vehiculo = new vehiculo(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("marca"),
                    rs.getInt("potencia"),
                    rs.getDate("fecha_de_compra")
                );
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    // Método para consultar un vehículo por ID
    public vehiculo consultarVehiculoPorId(int id) {
        String sql = "SELECT * FROM Vehiculos WHERE id = ?";
        vehiculo vehiculo = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                vehiculo = new vehiculo(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("marca"),
                    rs.getInt("potencia"),
                    rs.getDate("fecha_de_compra")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculo;
    }

    // Método para insertar un nuevo vehículo
    public boolean insertarNuevoVehiculo(vehiculo vehiculo) {
    String sql = "INSERT INTO Vehiculos (tipo, marca, potencia, fecha_de_compra) VALUES (?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pstmt.setString(1, vehiculo.getTipo());
        pstmt.setString(2, vehiculo.getMarca());
        pstmt.setInt(3, vehiculo.getPotencia());
        pstmt.setDate(4, new java.sql.Date(vehiculo.getFechaDeCompra().getTime()));

        int filasAfectadas = pstmt.executeUpdate();
        if (filasAfectadas > 0) {
            // Recuperare l'ID generato automaticamente
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                vehiculo.setId(rs.getInt(1));
            }
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    // Método para eliminar un vehículo por ID
    public boolean eliminarVehiculoPorId(int id) {
        String sql = "DELETE FROM Vehiculos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar los datos de un vehículo
    public boolean actualizarDatosVehiculo(vehiculo vehiculo) {
        String sql = "UPDATE Vehiculos SET tipo = ?, marca = ?, potencia = ?, fecha_de_compra = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehiculo.getTipo());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setInt(3, vehiculo.getPotencia());
            pstmt.setDate(4, new java.sql.Date(vehiculo.getFechaDeCompra().getTime()));
            pstmt.setInt(5, vehiculo.getId());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener la potencia media según el tipo de vehículo
    public double obtenerPotenciaMediaSegunTipoVehiculo(String tipo) {
        String sql = "SELECT AVG(potencia) FROM Vehiculos WHERE tipo = ?";
        double potenciaMedia = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                potenciaMedia = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return potenciaMedia;
    }

    // Método para obtener la potencia máxima según el tipo de vehículo
    public int obtenerPotenciaMaximaSegunTipoVehiculo(String tipo) {
        String sql = "SELECT MAX(potencia) FROM Vehiculos WHERE tipo = ?";
        int potenciaMaxima = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                potenciaMaxima = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return potenciaMaxima;
    }
}
