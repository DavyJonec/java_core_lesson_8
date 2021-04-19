package ru.geekbrains.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 640;
    private static final int WINDOW_POS_X = 640;
    private static final int WINDOW_POS_Y = 230;

    private GameMap map;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("Tic Tac Toe");
        setResizable(false);

        JButton btnStart = new JButton("<html><body><b>Start</b></body></html>");
        JButton btnExit = new JButton("<html><body><b>EXIT</b></body></html>");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnExit);

        map = new GameMap();
        SettingsWindow settings = new SettingsWindow(this);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(map, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void startGame(int gameMode, int fieldSize, int winLength) {
        map.startNewGame(gameMode, fieldSize, winLength);
    }
}

