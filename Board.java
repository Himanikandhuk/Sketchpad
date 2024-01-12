import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JFrame implements ActionListener, AdjustmentListener {
    private Color currentColor;
    int mousesize = 10;

    public Board() {
        JButton blue = createColorButton(Color.BLUE);
        JButton white = createColorButton(Color.WHITE);
        JButton green = createColorButton(Color.GREEN);
        JButton red = createColorButton(Color.RED);
        JButton orange = createColorButton(Color.ORANGE);
        JButton pink = createColorButton(Color.PINK);
        JButton eraser = createEraserButton();
        JButton clear = createClearBUtton();
        JScrollBar sizeScrollBar = createSizeScrollBar();

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.add(blue);
        buttonsPanel.add(white);
        buttonsPanel.add(green);
        buttonsPanel.add(red);
        buttonsPanel.add(orange);
        buttonsPanel.add(pink);
        buttonsPanel.add(eraser);
        buttonsPanel.add(clear);
        buttonsPanel.add(sizeScrollBar);

        DrawingPanel drawingPanel = new DrawingPanel();
        drawingPanel.setPreferredSize(new Dimension(900, 600));

        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        currentColor = Color.BLACK;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JScrollBar createSizeScrollBar() {
        JScrollBar sizeScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, mousesize, 1, 1, 51);
        sizeScrollBar.setPreferredSize(new Dimension(300, 30));
        sizeScrollBar.addAdjustmentListener(this);
        return sizeScrollBar;
    }

    private JButton createClearBUtton() {
        JButton clear = new JButton("Clear");
        clear.setBackground(Color.GRAY);
        clear.setPreferredSize(new Dimension(100, 50));
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLACK;
                repaint();
            }
        });
        return clear;

    }

    private JButton createColorButton(Color color) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setPreferredSize(new Dimension(50, 50));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = color;
            }
        });
        return button;
    }

    private JButton createEraserButton() {
        JButton eraser = new JButton("Eraser");
        eraser.setBackground(Color.GRAY);
        eraser.setPreferredSize(new Dimension(100, 50));
        eraser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLACK;
            }
        });
        return eraser;
    }

    private class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
        private int mouseX, mouseY;

        public DrawingPanel() {
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(800, 600));
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(currentColor);
            g.fillOval(mouseX - mousesize / 2, mouseY - mousesize / 2, mousesize, mousesize);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Graphics g = getGraphics();
            g.setColor(currentColor);
            g.fillOval(e.getX() - mousesize / 2, e.getY() - mousesize / 2, mousesize, mousesize);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        mousesize = e.getValue();
    }
}

