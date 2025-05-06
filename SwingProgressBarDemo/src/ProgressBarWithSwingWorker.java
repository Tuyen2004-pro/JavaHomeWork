import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Lớp chính
public class ProgressBarWithSwingWorker extends JFrame {

    private JProgressBar progressBar;
    private JButton startButton;

    public ProgressBarWithSwingWorker() {
        // Thiết lập JFrame
        setTitle("JProgressBar với SwingWorker");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setLayout(new BorderLayout());

        // Tạo thanh JProgressBar
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true); // Hiển thị phần trăm
        add(progressBar, BorderLayout.CENTER);

        // Tạo JButton "Start"
        startButton = new JButton("Start");
        add(startButton, BorderLayout.SOUTH);

        // Thêm sự kiện cho nút "Start"
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vô hiệu hóa nút khi đang chạy
                startButton.setEnabled(false);

                // Tạo và chạy SwingWorker
                ProgressTask task = new ProgressTask();
                task.execute();
            }
        });
    }

    // Lớp SwingWorker để cập nhật giá trị thanh JProgressBar
    private class ProgressTask extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100); // Chờ 100ms (tổng cộng 10 giây)
                progressBar.setValue(i); // Cập nhật giá trị
            }
            return null;
        }

        @Override
        protected void done() {
            // Kích hoạt lại nút sau khi hoàn thành
            startButton.setEnabled(true);
            JOptionPane.showMessageDialog(
                ProgressBarWithSwingWorker.this, 
                "Hoàn thành!", 
                "Thông báo", 
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        // Hiển thị giao diện
        SwingUtilities.invokeLater(() -> {
            ProgressBarWithSwingWorker frame = new ProgressBarWithSwingWorker();
            frame.setVisible(true);
        });
    }
}