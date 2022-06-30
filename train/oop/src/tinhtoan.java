import java.util.Scanner;

public class tinhtoan {
    private String line1;
    private String line2;

    public tinhtoan() {
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi 1: ");
        line1 = sc.nextLine();
        System.out.println("Nhap chuoi 2: ");
        line2 = sc.nextLine();
    }

    public  boolean result() {
        return line1.equals(line2);
    }

    public static void main(String[] args) {
        tinhtoan tt = new tinhtoan();
        tt.Nhap();
        System.out.println(tt.result());
        System.out.println("3");
    }
}
