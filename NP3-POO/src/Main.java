public class Main {
    public static void main(String[] args) {

        try {
            Utils utils = new Utils();

            Clinica clinica = new Clinica("ClinicaTop");
            Veterinario veterinario = new Veterinario("Tadeu");
            Veterinario veterinaria = new Veterinario("Tadinha");

            Animal cachorro1 = new Cachorro("Doguinho", 2016);
            Cachorro cachorro2 = new Cachorro("Dogão", 2020);
            Animal gato = new Gato("Mingal", 2019);
            Animal passaro = new Passaro("Piupiu", 2025);

            gato.emitirSom();
            passaro.alimentar();
            cachorro2.brincar();


            clinica.criarConsulta(gato, veterinaria);
            clinica.criarConsulta(cachorro1, veterinaria);
            clinica.criarConsulta(cachorro2, veterinario);
            clinica.criarConsulta(passaro, veterinario);

            veterinaria.examinar(gato);
            veterinario.examinar(passaro);

            utils.calcularIdade(cachorro1.anoNascimento, cachorro1.nome);


            clinica.mostrarConsultas();
            clinica.cancelarConsulta();


        } catch (NullPointerException e){
            System.out.println("Erro");
        }
    }
}