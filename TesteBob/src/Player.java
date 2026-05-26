import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Player {

    KeyHandler keyH;

    // ===== POSIÇÃO =====

    int x = 100;

    // TAMANHO DO PERSONAGEM
    final int drawSize = 185;

    // POSIÇÃO DO CHÃO
    final int groundY = 527;

    // PLAYER COMEÇA NO CHÃO
    int y = groundY - drawSize;

    // ===== MOVIMENTO =====

    int speed = 5;

    // Guarda para qual lado o Bob está olhando
    boolean facingRight = true;

    // ===== GRAVIDADE =====

    double velocityY = 0;
    double gravity = 0.6;

    boolean jumping = false;

    // ===== SPRITES =====

    BufferedImage[] walkFrames;
    BufferedImage[] idleFrames;

    BufferedImage jumpFrame;

    // ===== ANIMAÇÃO =====

    int spriteCounter = 0;
    int spriteNum = 0;

    public Player(KeyHandler keyH) {

        this.keyH = keyH;

        try {

            BufferedImage walkSheet =
                    loadImage("/assets/BobAndando.png");

            BufferedImage idleSheet =
                    loadImage("/assets/Bob_Parado.png");

            BufferedImage jumpSheet =
                    loadImage("/assets/BobPulando.png");

            // BobAndando.png: grade 3x3, usando 8 frames
            walkFrames = cutFrames(walkSheet, 3, 3, 8);

            // Bob_Parado.png: grade 5x5, usando 25 frames
            idleFrames = cutFrames(idleSheet, 5, 5, 25);

            // BobPulando.png: imagem única
            jumpFrame = jumpSheet;

        } catch(Exception e) {

            System.out.println("ERRO AO CARREGAR SPRITES");
            e.printStackTrace();
        }
    }

    private BufferedImage loadImage(String path) throws Exception {

        InputStream stream = getClass().getResourceAsStream(path);

        if(stream == null) {
            throw new RuntimeException("Imagem não encontrada: " + path);
        }

        return ImageIO.read(stream);
    }

    private BufferedImage[] cutFrames(
            BufferedImage sheet,
            int cols,
            int rows,
            int totalFrames
    ) {

        BufferedImage[] frames = new BufferedImage[totalFrames];

        int frameWidth = sheet.getWidth() / cols;
        int frameHeight = sheet.getHeight() / rows;

        int frame = 0;

        for(int row = 0; row < rows; row++) {

            for(int col = 0; col < cols; col++) {

                if(frame < totalFrames) {

                    frames[frame] = sheet.getSubimage(
                            col * frameWidth,
                            row * frameHeight,
                            frameWidth,
                            frameHeight
                    );

                    frame++;
                }
            }
        }

        return frames;
    }

    public void update() {

        // ===== MOVIMENTO HORIZONTAL =====

        if(keyH.leftPressed) {
            x -= speed;
            facingRight = false;
        }

        if(keyH.rightPressed) {
            x += speed;
            facingRight = true;
        }

        // ===== ANIMAÇÃO =====

        spriteCounter++;

        if(spriteCounter > 10) {

            spriteNum++;

            int maxFrames;

            if(jumping) {
                maxFrames = 1;
            } else if(keyH.leftPressed || keyH.rightPressed) {
                maxFrames = walkFrames.length;
            } else {
                maxFrames = idleFrames.length;
            }

            if(spriteNum >= maxFrames) {
                spriteNum = 0;
            }

            spriteCounter = 0;
        }

        // ===== PULO =====

        if(keyH.jumpPressed && !jumping) {

            velocityY = -13;

            jumping = true;
        }

        // ===== GRAVIDADE =====

        velocityY += gravity;

        y += velocityY;

        // ===== CHÃO =====

        int floorPosition = groundY - drawSize;

        if(y >= floorPosition) {

            y = floorPosition;

            velocityY = 0;

            jumping = false;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage currentFrame;

        if(jumping) {

            currentFrame = jumpFrame;

        } else if(keyH.leftPressed || keyH.rightPressed) {

            int frameIndex = spriteNum % walkFrames.length;
            currentFrame = walkFrames[frameIndex];

        } else {

            int frameIndex = spriteNum % idleFrames.length;
            currentFrame = idleFrames[frameIndex];
        }

        // ===== DESENHAR PLAYER =====
        // Se estiver olhando para direita, desenha normal.
        // Se estiver olhando para esquerda, desenha espelhado.

        if(facingRight) {

            g2.drawImage(
                    currentFrame,
                    x,
                    y,
                    drawSize,
                    drawSize,
                    null
            );

        } else {

            g2.drawImage(
                    currentFrame,
                    x + drawSize,
                    y,
                    -drawSize,
                    drawSize,
                    null
            );
        }
    }
}