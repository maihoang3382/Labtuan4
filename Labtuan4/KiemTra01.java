package Labtuan4;
import java.util.Scanner;
class Xe {
    protected String soxe;
    protected String loai;
    protected String ngaydk;
    protected boolean trthai;
    public Xe() {
        this.soxe = "";
        this.loai = "";
        this.ngaydk = "";
        this.trthai = true;
    }
    public Xe(Xe other) {
        this.soxe = other.soxe;
        this.loai = other.loai;
        this.ngaydk = other.ngaydk;
        this.trthai = other.trthai;
    }
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số xe: ");
        soxe = sc.nextLine();
        System.out.print("Nhập loại xe: ");
        loai = sc.nextLine();
        System.out.print("Nhập ngày đăng kiểm (dd/MM/yyyy): ");
        ngaydk = sc.nextLine();
        System.out.print("Xe có được phép lưu hành không (true/false): ");
        trthai = sc.nextBoolean();
    }
    public void in() {
        System.out.println("Số xe: " + soxe);
        System.out.println("Loại xe: " + loai);
        System.out.println("Ngày đăng kiểm: " + ngaydk);
        System.out.println("Trạng thái lưu hành: " + (trthai ? "Cho phép" : "Không cho phép"));
    }
    public String getSoxe() {
        return soxe;
    }
    public String getLoai() {
        return loai;
    }
    public String getNgaydk() {
        return ngaydk;
    }
    public boolean isLuuHanh() {
        return trthai;
    }
}
class ChuyenXe extends Xe {
    private int msc;
    private String ten;
    private String noiden;
    private double doanhthu;
    public ChuyenXe() {
        super();
        this.msc = 0;
        this.ten = "";
        this.noiden = "";
        this.doanhthu = 0.0;
    }
    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("Nhập mã số chuyến xe: ");
        msc = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên tài xế: ");
        ten = sc.nextLine();
        System.out.print("Nhập nơi đến: ");
        noiden = sc.nextLine();
        System.out.print("Nhập doanh thu: ");
        doanhthu = sc.nextDouble();
    }
    @Override
    public void in() {
        super.in();
        System.out.println("Mã số chuyến xe: " + msc);
        System.out.println("Tên tài xế: " + ten);
        System.out.println("Nơi đến: " + noiden);
        System.out.println("Doanh thu: " + doanhthu);
        System.out.println("Lợi nhuận (30% doanh thu): " + getLoiNhuan());
    }
    public int getMsc() {
        return msc;
    }
    public double getDoanhthu() {
        return doanhthu;
    }
    public double getLoiNhuan() {
        return doanhthu * 0.3;
    }
    public String getThangNam() {
        if (ngaydk != null && ngaydk.contains("/")) {
            String[] parts = ngaydk.split("/");
            if (parts.length == 3) {
                return parts[1] + "/" + parts[2]; // MM/yyyy
            }
        }
        return "";
    }
}
class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Xe x1 = new Xe();
        System.out.println("Nhập thông tin x1");
        x1.nhap();
        System.out.println("In thông tin x1");
        x1.in();
        Xe x2 = new Xe(x1);
        System.out.println("In thông tin x2");
        x2.in();
        System.out.print("Nhập số lượng chuyến xe: ");
        int m = sc.nextInt();
        ChuyenXe[] ds1 = new ChuyenXe[m];
        for (int i = 0; i < m; i++) {
            System.out.println("\nNhập thông tin cho chuyến xe thứ " + (i + 1) + ":");
            ds1[i] = new ChuyenXe();
            ds1[i].nhap();
        }
        System.out.println("\nThông tin các chuyến xe");
        for (ChuyenXe cx : ds1) {
            cx.in();
        }
        System.out.println("\nCác chuyến xe bị hủy (không lưu hành hoặc doanh thu < 100.000)");
        for (ChuyenXe cx : ds1) {
            if (!cx.isLuuHanh() || cx.getDoanhthu() < 100000) {
                System.out.println("Mã số chuyến xe bị hủy: " + cx.getMsc());
            }
        }
        System.out.println("\nTổng lợi nhuận theo loại xe theo tháng-năm");
        for (int i = 0; i < m; i++) {
            boolean counted = false;
            for (int j = 0; j < i; j++) {
                if (ds1[i].getLoai().equals(ds1[j].getLoai()) && ds1[i].getThangNam().equals(ds1[j].getThangNam())) {
                    counted = true;
                    break;
                }
            }
            if (!counted) {
                double tongLoiNhuan = 0;
                for (int k = 0; k < m; k++) {
                    if (ds1[i].getLoai().equals(ds1[k].getLoai()) && ds1[i].getThangNam().equals(ds1[k].getThangNam())) {
                        tongLoiNhuan += ds1[k].getLoiNhuan();
                    }
                }
                System.out.println("Loại xe: " + ds1[i].getLoai() + ", Tháng/Năm: " + ds1[i].getThangNam() +
                        ", Tổng lợi nhuận: " + tongLoiNhuan);
            }
        }
    }
}
