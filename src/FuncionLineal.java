public class FuncionLineal {

    private double m;
    private double b;

    public FuncionLineal(double m, double b) {
        this.m = m;
        this.b = b;
    }

    // retorna vector bidimensional {x, y}
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
