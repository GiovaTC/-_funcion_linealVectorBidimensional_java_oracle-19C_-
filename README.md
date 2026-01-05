# -_Funcion_linealVectorBidimensional_java_oracle-19C_- :. 
# Función Lineal con Vector Bidimensional en Java y Oracle 19c .

<img width="1024" height="1024" alt="image" src="https://github.com/user-attachments/assets/2d3238f0-4018-48a9-a1d8-4c4d337aca19" />    

<img width="2555" height="1079" alt="image" src="https://github.com/user-attachments/assets/c8124eb4-f292-4ac2-be1d-682ad5494f19" />    

A continuación se presenta una **solución completa, profesional y ejecutable en Java (IntelliJ IDEA)** que cumple exactamente con lo solicitado:

* Implementa una **función lineal**
* Utiliza un **vector bidimensional (x, y)**
* Calcula ( y = m \cdot x + b )
* Registra los valores en una tabla **Oracle Database 19c**
* Usa **JDBC**
* Código claro, modular y listo para pruebas

---

## 1. Modelo matemático (Función lineal) :

La función implementada es:

```text
y = m · x + b
```

El vector bidimensional se representa como:

```java
double[] vector = {x, y};
```

---

## 2. Script SQL – Oracle 19c :

Ejecute este script antes de correr el programa:

```sql
CREATE TABLE FUNCION_LINEAL (
    ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    X NUMBER(10,2),
    Y NUMBER(10,2),
    M NUMBER(10,2),
    B NUMBER(10,2),
    FECHA_REGISTRO DATE DEFAULT SYSDATE
);
```

---

## 3. Clase de conexión a Oracle (JDBC) :

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB1";
    private static final String USER = "SYSTEM";
    private static final String PASSWORD = "oracle";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

---

## 4. Clase lógica – Función lineal con vector 2D :

```java
public class FuncionLineal {

    private double m;
    private double b;

    public FuncionLineal(double m, double b) {
        this.m = m;
        this.b = b;
    }

    // Retorna vector bidimensional {x, y}
    public double[] calcular(double x) {
        double y = m * x + b;
        return new double[]{x, y};
    }

    public double getM() {
        return m;
    }

    public double getB() {
        return b;
    }
}
```

---

## 5. DAO – Registro del vector en Oracle :

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionLinealDAO {

    public void registrarVector(double[] vector, double m, double b) {

        String sql = "INSERT INTO FUNCION_LINEAL (X, Y, M, B) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, vector[0]);
            ps.setDouble(2, vector[1]);
            ps.setDouble(3, m);
            ps.setDouble(4, b);

            ps.executeUpdate();
            System.out.println("Registro almacenado correctamente en Oracle.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 6. Clase principal (Ejecución en IntelliJ IDEA) :

```java
public class Main {

    public static void main(String[] args) {

        // Parámetros de la función lineal
        double m = 2.5;
        double b = 1.0;

        // Valor de entrada
        double x = 4.0;

        FuncionLineal funcion = new FuncionLineal(m, b);
        FuncionLinealDAO dao = new FuncionLinealDAO();

        // Vector bidimensional
        double[] vector = funcion.calcular(x);

        System.out.println("Vector 2D generado:");
        System.out.println("X = " + vector[0]);
        System.out.println("Y = " + vector[1]);

        // Registro en Oracle
        dao.registrarVector(vector, funcion.getM(), funcion.getB());
    }
}
```

---

## 7. Resultado esperado :

### Consola

```text
Vector 2D generado:
X = 4.0
Y = 11.0
Registro almacenado correctamente en Oracle.
```

### Tabla Oracle

| ID | X   | Y    | M   | B   | FECHA_REGISTRO |
| -- | --- | ---- | --- | --- | -------------- |
| 1  | 4.0 | 11.0 | 2.5 | 1.0 | 06-01-2026     |

---

## 8. Arquitectura aplicada :

* Matemática (Función lineal)
* Vector bidimensional
* JDBC
* DAO
* Oracle Database 19c
* Código limpio, modular y escalable

---

**Documento listo para uso académico, técnico o profesional.** :. . / .
