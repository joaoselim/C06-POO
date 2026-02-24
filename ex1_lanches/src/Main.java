import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Entre com o valor de lanches1: ");
        int lanches1 = entrada.nextInt();
        System.out.println("Entre com o valor de lanches2: ");
        int lanches2 = entrada.nextInt();
        System.out.println("Entre com o valor de lanches3: ");
        int lanches3 = entrada.nextInt();

        int total = lanches1 + lanches2 + lanches3;
        float media = (float) total / 3;

        System.out.println("Total de lanches: " + total);
        System.out.println("Média de lanches: " + media);
    }
}