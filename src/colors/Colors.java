package colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Colors {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Colors().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Color Circle App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Circle Panel
        CirclePanel circlePanel = new CirclePanel();
        circlePanel.setBackground(Color.PINK);
        frame.add(circlePanel, BorderLayout.CENTER);

        // Dropdown and Output Panel
        JPanel controlPanel = new JPanel();
        String[] colors = {"Select a Color", "Red", "Blue", "Green"};
        JComboBox<String> colorDropdown = new JComboBox<>(colors);
        colorDropdown.setBackground(new Color(255, 200, 0));
        JLabel colorLabel = new JLabel("Selected Color: None");

        controlPanel.add(colorDropdown);
        controlPanel.add(colorLabel);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Event Listener
        colorDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorDropdown.getSelectedItem();
                switch (selectedColor) {
                    case "Red":
                        circlePanel.setCircleColor(Color.RED);
                        break;
                    case "Blue":
                        circlePanel.setCircleColor(Color.BLUE);
                        break;
                    case "Green":
                        circlePanel.setCircleColor(Color.GREEN);
                        break;
                    default:
                        circlePanel.setCircleColor(null);
                }
                colorLabel.setText("Selected Color: " + selectedColor);
            }
        });

        // Display frame
        frame.setVisible(true);
    }

    // Custom JPanel to draw a circle
    static class CirclePanel extends JPanel {
        private Color circleColor = null;

        public void setCircleColor(Color color) {
            this.circleColor = color;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(circleColor == null ? Color.WHITE : circleColor);
            g.fillOval(125, 75, 40, 40);
            g.drawOval(125, 75, 40, 40);
        }
    }
}
