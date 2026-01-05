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