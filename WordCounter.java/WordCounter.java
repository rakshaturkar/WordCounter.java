import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() {
        // Set up the frame
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");

        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        // Add components to the frame
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);
    }

    private void countWords() {
        String text = textArea.getText();
        if (text.trim().isEmpty()) {
            resultLabel.setText("Word Count: 0");
        } else {
            String[] words = text.trim().split("\\s+");
            resultLabel.setText("Word Count: " + words.length);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounter wordCounter = new WordCounter();
            wordCounter.setVisible(true);
        });
    }
}