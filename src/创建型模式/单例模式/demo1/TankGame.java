package 创建型模式.单例模式.demo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankGame extends JFrame {

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;
    private final int PLAYER_TANK_SPEED = 5;
    private final int ENEMY_TANK_SPEED = 3;
    private final int BULLET_SPEED = 8;
    private final int BULLET_SIZE = 10;
    private Tank playerTank;
    private List<Tank> enemyTanks;
    private List<Bullet> bullets;

    public TankGame() {
        super("Tank Game");

        // 设置窗口大小和关闭操作
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 创建玩家坦克
        playerTank = new Tank(100, 100, PLAYER_TANK_SPEED, Color.RED);

        // 创建敌方坦克
        enemyTanks = new ArrayList<>();
        enemyTanks.add(new Tank(200, 200, ENEMY_TANK_SPEED, Color.BLUE));
        enemyTanks.add(new Tank(300, 300, ENEMY_TANK_SPEED, Color.GREEN));

        // 创建子弹列表
        bullets = new ArrayList<>();

        // 添加键盘监听器
        addKeyListener(new TankControl());

        // 设置窗口可见
        setVisible(true);

        // 启动游戏循环
        gameLoop();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        playerTank.draw(g);
        for (Tank enemyTank : enemyTanks) {
            enemyTank.draw(g);
        }
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    private void gameLoop() {
        while (true) {
            // 更新玩家坦克和子弹
            playerTank.update();
            for (Iterator<Bullet> iterator = bullets.iterator(); iterator.hasNext();) {
                Bullet bullet = iterator.next();
                bullet.update();
                if (bullet.isOutOfBounds()) {
                    iterator.remove();
                }
            }

            // 更新敌方坦克
            for (Tank enemyTank : enemyTanks) {
                enemyTank.update();
            }

            // 重绘窗口
            repaint();

            // 线程休眠一段时间，控制游戏速度
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new TankGame();
    }

    private class Tank {

        private int x;
        private int y;
        private int direction;
        private int speed;
        private Color color;

        public Tank(int x, int y, int speed, Color color) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.color = color;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, 30, 30);
        }

        public void update() {
            int oldX = x;
            int oldY = y;

            switch (direction) {
                case 0: // 上
                    if (y - speed >= 0) {
                        y -= speed;
                    }
                    break;
                case 1: // 下
                    if (y + speed + 30 <= WINDOW_HEIGHT) {
                        y += speed;
                    }
                    break;
                case 2: // 左
                    if (x - speed >= 0) {
                        x -= speed;
                    }
                    break;
                case 3: // 右
                    if (x + speed + 30 <= WINDOW_WIDTH) {
                        x += speed;
                    }
                    break;
            }

            // 检查是否与其他坦克相撞
            if (collidesWithOtherTanks()) {
                // 恢复原始位置
                x = oldX;
                y = oldY;
            }
        }

        public boolean collidesWithOtherTanks() {
            Rectangle tankBounds = getBounds();
            for (Tank enemyTank : enemyTanks) {
                if (enemyTank != this && enemyTank.getBounds().intersects(tankBounds)) {
                    return true;
                }
            }
            return false;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 30, 30);
        }
    }

    private class Bullet {

        private int x;
        private int y;
        private int direction;
        private int speed;

        public Bullet(int x, int y, int direction, int speed) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.speed = speed;
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillOval(x, y, BULLET_SIZE, BULLET_SIZE);
        }

        public void update() {
            switch (direction) {
                case 0: // 上
                    y -= speed;
                    break;
                case 1: // 下
                    y += speed;
                    break;
                case 2: // 左
                    x -= speed;
                    break;
                case 3: // 右
                    x += speed;
                    break;
            }
        }

        public boolean isOutOfBounds() {
            return x < 0 || x > WINDOW_WIDTH || y < 0 || y > WINDOW_HEIGHT;
        }
    }

    private class TankControl implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    playerTank.direction = 0;
                    break;
                case KeyEvent.VK_DOWN:
                    playerTank.direction = 1;
                    break;
                case KeyEvent.VK_LEFT:
                    playerTank.direction = 2;
                    break;
                case KeyEvent.VK_RIGHT:
                    playerTank.direction = 3;
                    break;
                case KeyEvent.VK_SPACE:
                    playerTank.notify();
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
