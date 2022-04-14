package gui;

import movable.Knight;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Thread gameThread;
    private final Handler handler;

    private boolean run;

    public Game() {
        handler = new Handler();
        handler.addMovables(new Knight(100, 100));
    }

    public synchronized void start() {
        gameThread = new Thread(this);
        gameThread.start();
        run = true;
    }

    public synchronized void stop() {
        try {
            gameThread.join();
            run = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(run)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(run) {
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {
        handler.tick();
    }

    public void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

        handler.render(graphics);

        graphics.dispose();
        bufferStrategy.show();
    }

}
