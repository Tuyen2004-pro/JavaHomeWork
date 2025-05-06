import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MoveLabelWithMouse extends JFrame {
    private JLabel label;

    public MoveLabelWithMouse() {
        // Thiết lập JFrame
        setTitle("Di chuyển JLabel theo chuột");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setLayout(null); // Sử dụng layout tự do (absolute positioning)

        // Tạo JLabel
        label = new JLabel("Follow Me");
        label.setSize(100, 30); // Kích thước JLabel
        label.setLocation(200, 150); // Vị trí ban đầu của JLabel
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Thiết lập font chữ
        add(label);

        // Thêm MouseMotionListener vào JFrame
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Không xử lý sự kiện kéo chuột
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Di chuyển JLabel theo tọa độ chuột
                int x = e.getX();
                int y = e.getY();
                label.setLocation(x, y); // Đặt vị trí mới cho JLabel
            }
        });
    }

    public static void main(String[] args) {
        // Hiển thị giao diện
        SwingUtilities.invokeLater(() -> {
            MoveLabelWithMouse frame = new MoveLabelWithMouse();
            frame.setVisible(true);
        });
    }
}