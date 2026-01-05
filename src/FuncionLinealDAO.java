import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionLinealDAO {

    public void registrarVector(double[] vector, double m, double b) {

        String sql = "INSERT INTO FUNCION_LINEAL (X, Y, M, B) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionOracle.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, vector[0]);
            ps.setDouble(2, vector[1]);
            ps.setDouble(3, m);
            ps.setDouble(4, b);

            ps.executeUpdate();
            System.out.println("Registro almacenado correctamente en Oracle. ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
