import java.util.ArrayList;
import java.util.Scanner;

public class st_main {
    public static void main(String[] args) {
        student st = new student();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        try {
            System.out.println("Nhap so luong sinh vien: ");
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Vui long nhap so nguyen.");
            }
        for (int i = 0; i < n; i++) {
            System.out.println("SV thu: "+(i+1));
            st.Nhap();

            System.out.println("Danh sach SV");
            System.out.printf("%6s %10s %20s %10s %10s \n","Họ tên","Tuổi","Điểm toán","Điểm hoá", "Điểm Sử","Điểm trung bình");
            st.Output();

        }
    }
}
