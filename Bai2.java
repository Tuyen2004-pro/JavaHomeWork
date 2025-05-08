import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào 3 số nguyên a, b, c
        System.out.print("Nhập vào số nguyên a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập vào số nguyên b: ");
        int b = scanner.nextInt();
        System.out.print("Nhập vào số nguyên c: ");
        int c = scanner.nextInt();

        // Kiểm tra điều kiện tam giác
        if (isTriangle(a, b, c)) {
            System.out.println("Ba số " + a + ", " + b + ", và " + c + " là độ dài ba cạnh của một tam giác.");
        } else {
            System.out.println("Ba số " + a + ", " + b + ", và " + c + " không phải là độ dài ba cạnh của một tam giác.");
        }

        scanner.close();
    }

    // Hàm kiểm tra điều kiện tam giác
    public static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}