import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JFrame implements MouseListener, MouseMotionListener, ActionListener {
    private Color currentColor;

    public Board() {
        JButton blue = new JButton("Blue");
        blue.setBackground(Color.BLUE);
        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLUE;
            }
        });

        JButton white = new JButton("White");
        white.setBackground(Color.WHITE);
        white.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.WHITE;
            }
        });

        JButton green = new JButton("Green");
        green.setBackground(Color.GREEN);
        green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.GREEN;
            }
        });

        JButton red = new JButton("Red");
        red.setBackground(Color.RED);
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.RED;
            }
        });

        JButton orange = new JButton("Orange");
        orange.setBackground(Color.ORANGE);
        orange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.ORANGE;
            }
        });

        JButton pink = new JButton("Pink");
        pink.setBackground(Color.PINK);
        pink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.PINK;
            }
        });

        JButton eraser = new JButton("Eraser");
        eraser.setBackground(Color.WHITE);
        eraser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLACK;
            }
        });

        this.add(blue);
        this.add(white);
        this.add(green);
        this.add(red);
        this.add(orange);
        this.add(pink);
        this.add(eraser);
        this.setPreferredSize(new Dimension(800, 600));
        getContentPane().setBackground(Color.BLACK);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        currentColor = Color.BLACK;

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Unimplemented
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Unimplemented
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Unimplemented
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Unimplemented
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Unimplemented
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Unimplemented
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(currentColor);
        g.fillOval(e.getX(), e.getY(), 20, 20);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Unimplemented
    }
}
