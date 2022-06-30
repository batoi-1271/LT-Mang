import java.util.Scanner;

public class student {
    private String name;
    private int age;
    private int math, chemistry, history;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    Scanner sc = new Scanner(System.in);
    public  student() {}
    public student(String name, int age, int math, int chemistry, int history) {
        this.name = name;
        this.age = age;
        this.math = math;
        this.chemistry = chemistry;
        this.history = history;
    }
    public void Nhap() {
        System.out.println("Nhap ten: "); name = sc.nextLine();
        System.out.println("Nhap tuoi: "); age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap diem toan: "); math = sc.nextInt();
        System.out.println("Nhap hoa: "); chemistry = sc.nextInt();
        System.out.println("Nhap su: "); history = sc.nextInt();
    }

    public float tinhDiemTB() {
        return (math + chemistry + history) / 3;
    }

    public void Output() {
        System.out.printf("%6d %-18s %10.2f %12.2f %12.2f \n", name, age, math, chemistry, history, tinhDiemTB());
    }
}
