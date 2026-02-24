import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Random rand = new Random();

        int numAleatorio = rand.nextInt(10)+1;

        System.out.println("Adivinhe qual o numero gerado (1-10): ");
        int num = entrada.nextInt();

        while(num != numAleatorio){
            if(num>numAleatorio) {
                System.out.println("Errado, muito alto! tente menor: ");
                num = entrada.nextInt();
            }
            else{
                System.out.println("Errado, muito baixo! tente maior: ");
                num = entrada.nextInt();
            }
        }
        System.out.println("Acertou!!!");
    }
}