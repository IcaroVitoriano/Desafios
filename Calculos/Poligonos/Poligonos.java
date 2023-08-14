// Pacote onde a classe Poligonos está localizada
package Poligonos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe abstrata para representar polígonos genéricos
abstract class Poligono {
    protected double tamanhoLado;

    // Construtor da classe Poligono
    public Poligono(double tamanhoLado) {
        this.tamanhoLado = tamanhoLado;
    }

    // Método abstrato para calcular a área do polígono
    public abstract double calcularArea();

    // Método abstrato para retornar uma representação em texto do polígono
    @Override
    public abstract String toString();
}

// Classe que representa um Triângulo, subclasse de Poligono
class Triangulo extends Poligono {
    public Triangulo(double tamanhoLado) {
        super(tamanhoLado);
    }

    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * tamanhoLado * tamanhoLado;
    }

    @Override
    public String toString() {
        return "Triângulo de lado " + tamanhoLado + " cm e área " + calcularArea() + " cm²";
    }
}

// Classe que representa um Quadrado, subclasse de Poligono
class Quadrado extends Poligono {
    public Quadrado(double tamanhoLado) {
        super(tamanhoLado);
    }

    @Override
    public double calcularArea() {
        return tamanhoLado * tamanhoLado;
    }

    @Override
    public String toString() {
        return "Quadrado de lado " + tamanhoLado + " cm e área " + calcularArea() + " cm²";
    }
}

// Classe principal que contém o método main
public class Poligonos {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Poligono> poligonos = new ArrayList<>();

            // Loop para coletar informações dos polígonos
            while (true) {
                System.out.print("Informe o número de lados do polígono (3 para triângulo, 4 para quadrado) ou 0 para sair: ");
                int numLados = scanner.nextInt();

                if (numLados == 0) {
                    break;
                }

                // Verifica se o número de lados é válido
                if (numLados != 3 && numLados != 4) {
                    System.out.println("Número de lados inválido. Insira 3 para triângulo ou 4 para quadrado.");
                    continue;
                }

                System.out.print("Informe o tamanho do lado (em cm): ");
                double tamanhoLado = scanner.nextDouble();

                // Verifica se o tamanho do lado é válido
                if (tamanhoLado <= 0) {
                    System.out.println("Tamanho do lado inválido. Deve ser um valor positivo.");
                    continue;
                }

                // Cria um polígono de acordo com o número de lados informado
                Poligono poligono = numLados == 3 ? new Triangulo(tamanhoLado) : new Quadrado(tamanhoLado);
                poligonos.add(poligono);
            }

            // Exibe as áreas dos polígonos e calcula a área total
            System.out.println("\nÁreas dos polígonos:");
            double areaTotal = 0;
            for (Poligono poligono : poligonos) {
                System.out.println(poligono);
                areaTotal += poligono.calcularArea();
            }

            // Exibe a área total dos polígonos
            System.out.println("\nÁrea total: " + areaTotal + " cm²");
        }
    }
}