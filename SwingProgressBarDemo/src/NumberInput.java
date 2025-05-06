import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class NumberInput extends JFrame {
    private JTextField textField;
    private JLabel label;

    public NumberInput() {
        // Thiết lập JFrame
        setTitle("Giới hạn nhập số");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setLayout(new FlowLayout());

        // Tạo JLabel "Number: "
        JLabel numberLabel = new JLabel("Number: ");
        add(numberLabel);

        // Tạo JTextField
        textField = new JTextField(15); // Chiều rộng 15 ký tự
        add(textField);

        // Tạo JLabel để hiển thị số
        label = new JLabel(" ");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        add(label);

        // Thêm DocumentListener để giới hạn chỉ nhập số
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleInput();
            }

            // Hàm xử lý khi nhập dữ liệu
            private void handleInput() {
                String text = textField.getText();
                if (text.matches("\\d*")) { // Chỉ cho phép ký tự số
                    label.setText("Valid Number: " + text);
                } else {
                    label.setText("Invalid Input!");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Hiển thị giao diện
        SwingUtilities.invokeLater(() -> {
            NumberInput frame = new NumberInput();
            frame.setVisible(true);
        });
    }
}