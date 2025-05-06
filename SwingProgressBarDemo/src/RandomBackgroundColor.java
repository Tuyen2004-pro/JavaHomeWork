
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomBackgroundColor extends JFrame {
    private Timer timer; // Timer để thay đổi màu nền
    private JButton stopButton; // Nút Stop

    public RandomBackgroundColor() {
        // Thiết lập JFrame
        setTitle("Thay đổi màu nền ngẫu nhiên");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setLayout(new BorderLayout());

        // Tạo nút "Stop"
        stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Arial", Font.BOLD, 16));
        stopButton.setFocusable(false);
        add(stopButton, BorderLayout.SOUTH);

        // Tạo Timer để thay đổi màu nền
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sinh màu ngẫu nhiên
                Random random = new Random();
                int red = random.nextInt(256);
                int green = random.nextInt(256);
                int blue = random.nextInt(256);
                Color randomColor = new Color(red, green, blue);

                // Thay đổi màu nền của JFrame
                getContentPane().setBackground(randomColor);
            }
        });

        // Bắt đầu Timer
        timer.start();

        // Thêm ActionListener cho nút "Stop"
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dừng Timer khi nhấn nút "Stop"
                timer.stop();
                stopButton.setEnabled(false); // Vô hiệu hóa nút sau khi dừng
            }
        });
    }

    public static void main(String[] args) {
        // Hiển thị giao diện
        SwingUtilities.invokeLater(() -> {
            RandomBackgroundColor frame = new RandomBackgroundColor();
            frame.setVisible(true);
        });
    }
}