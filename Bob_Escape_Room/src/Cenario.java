//AQUI REALIZAR ANALISE DE QUAL CENARIO DEVE SER MOSTRADO E MANDAR COMO VARIAVEL DEFINIDA

public class Cenario {

    public String updateCenario(String cenarioAtual, Jogador jogador, int screenWidth){

        // Entrada -> Corredor
        if (cenarioAtual.equals("Entrada") && jogador.x >= 1090) {

            jogador.x = 0;
            return "Corredor";
        }

        // Corredor -> Entrada
        if (cenarioAtual.equals("Corredor") && jogador.x <= -100) {

            jogador.x = screenWidth - jogador.tamanhoPersonagem;
            return "Entrada";
        }

        // Corredor -> Bar
        if (cenarioAtual.equals("Corredor") && jogador.x >= 1090) {

            jogador.x = 0;
            return "Bar";
        }

        // Bar -> Corredor
        if (cenarioAtual.equals("Bar") && jogador.x <= -100) {

            jogador.x = screenWidth - jogador.tamanhoPersonagem;
            return "Corredor";
        }


        return cenarioAtual;
    }

}
