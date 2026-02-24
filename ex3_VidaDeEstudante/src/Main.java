import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Insira sua Nota1: ");
        int NP1 = entrada.nextInt();
        System.out.println("Insira sua Nota2: ");
        int NP2 = entrada.nextInt();

        int NPA = (NP1 + NP2)/2;

        if (NPA >= 60)
            System.out.println("Aprovado direto!");
        else{
            System.out.println("Ficou de NP3! Informe sua Nota3: ");
            int NP3 = entrada.nextInt();

            int NFA = (NPA + NP3) / 2;

            if (NFA >= 50)
                System.out.println("Aprovado!");
            else
                System.out.println("Reprovado!");
        }
    }
}