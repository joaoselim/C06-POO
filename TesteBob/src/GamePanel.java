import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements Runnable {

    final int screenWidth = 1177;
    final int screenHeight = 562;

    Thread gameThread;

    KeyHandler keyH = new KeyHandler();

    Player player = new Player(keyH);

    BufferedImage background;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);

        this.setFocusable(true);

        try {

            background = ImageIO.read(
                    getClass().getResourceAsStream("/assets/cenario.png")
            );

        } catch (Exception e) {

            System.out.println("ERRO AO CARREGAR CENARIO");
            e.printStackTrace();
        }
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null) {

            update();

            repaint();

            try {
                Thread.sleep(16);
            } catch(Exception e) {}
        }
    }

    public void update() {

        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // DESENHA CENARIO
        g2.drawImage(background, 0, 0, screenWidth, screenHeight, null);

        // DESENHA PLAYER
        player.draw(g2);

        g2.dispose();
    }
}