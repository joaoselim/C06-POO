import java.io.InputStream; //Unico diferente da classe painelJogo, carrega arquivos que estão dentro do projeto
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Jogador {

    Controle controle;

    //===== POSIÇÃO =====
    int x = 100;

    final int tamanhoPersonagem = 185;

    final int chaoY = 527; // É a altura onde esta o topo da cabeça

    int y = chaoY - tamanhoPersonagem;

    int velocidade = 5;

    // GUARDA PARA QUAL LADO O BOB TA OLHANDO
    boolean olhandoPraDireita = true;

    double velocidadeY = 0;
    double gravidade = 0.6;

    boolean pulando = false;


    //===== SPRITES =====
    BufferedImage[] framesAndando;
    BufferedImage[] framesParado;

    BufferedImage framePulando;

    //===== ANIMAÇÃO =====
    int controleSprite = 0;
    int spriteNum = 0;

    public Jogador(Controle controle){

        this.controle = controle;    //<<<<<========== questionar o pq

        try{

            //
            BufferedImage recorteAndando =
                    carregarImagem("/animacoes/BobAndando.png");
            BufferedImage recorteParado =
                    carregarImagem("/animacoes/BobParado.png");
            BufferedImage recortePulo =
                    carregarImagem("/animacoes/BobPulando.png");

            //===== RECORTAR O SPRITES =====
            framesAndando = cortandoFrames(recorteAndando, 3, 3, 8);
            framesParado = cortandoFrames(recorteParado, 5, 5, 25);
            framePulando = recortePulo;

        } catch(Exception e){

            System.out.println("ERRO AO CARREGAR SPRITES");
            e.printStackTrace();
        }
    }

    private BufferedImage carregarImagem(String caminho) throws Exception {

        InputStream stream = getClass().getResourceAsStream(caminho);

        //VERIFICA SE ACHOU A IMAGEM
        if(stream == null) {
            throw new RuntimeException("Imagem não encontrada: " + caminho);
        }

        return ImageIO.read(stream);
    }

    private BufferedImage[] cortandoFrames(BufferedImage recorte, int colunas, int linhas, int numFrames){

        BufferedImage[] frames = new BufferedImage[numFrames];

        int larguraFrame = recorte.getWidth() / colunas;
        int alturaFrame = recorte.getHeight() / linhas;

        int frame = 0;

        for(int linha = 0; linha < linhas; linha++){

            for(int coluna = 0; coluna < colunas; coluna++){

                if(frame < numFrames){

                    frames[frame] = recorte.getSubimage(coluna * larguraFrame, linha * alturaFrame, larguraFrame, alturaFrame);

                    frame++;
                }
            }
        }
        return frames;
    }

    public void update(){

        //===== MOVIMENTO HORIZONTAL =====
        if(controle.esquerdaAcionado){
            x -= velocidade;
            olhandoPraDireita = false;
        }
        if(controle.direitaAcionado){
            x += velocidade;
            olhandoPraDireita = true;
        }

        //===== ANIMACAO =====
        controleSprite++; // SERVE PARA CONTROLAR A VELOCIDADE NA TROCA DE FRAMES

        if(controleSprite > 10){

            spriteNum++;

            int maxFrames;

            if(pulando){
                maxFrames = 1;
            }else if(controle.direitaAcionado || controle.esquerdaAcionado){
                maxFrames = framesAndando.length;
            } else {
                maxFrames = framesParado.length;
            }

            if(spriteNum >= maxFrames){
                spriteNum = 0;
            }

            controleSprite = 0;
        }

        if(controle.puloAcionado && !pulando) {
            velocidadeY = -13;
            pulando = true;
        }

        velocidadeY += gravidade;
        y += velocidadeY;

        int alturaChao = chaoY - tamanhoPersonagem;

        if(y >= alturaChao){

            y = alturaChao;

            velocidadeY = 0;

            pulando = false;
        }
    }

    public void draw(Graphics2D g2){

        BufferedImage frameAtual;

        if(pulando){
            frameAtual =framePulando;
        }
        else if(controle.esquerdaAcionado || controle.direitaAcionado){
            int frameAux = spriteNum % framesAndando.length;
            frameAtual = framesAndando[frameAux];
        }
        else {
            int frameAux = spriteNum % framesParado.length;
            frameAtual = framesParado[frameAux];
        }


        if(olhandoPraDireita){
            g2.drawImage(frameAtual, x, y, tamanhoPersonagem, tamanhoPersonagem, null);
        }
        else {
            g2.drawImage(frameAtual, x + tamanhoPersonagem, y, -tamanhoPersonagem, tamanhoPersonagem, null);
        }
    }

}
