package Labtuan4;
class Nguoi {
    private String ten;
    private String diaChi;
    public Nguoi(String ten, String diaChi) {
        this.ten = ten;
        this.diaChi = diaChi;
    }
    public String layTen() {
        return ten;
    }
    public String layDiaChi() {
        return diaChi;
    }
    public void datDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    @Override
    public String toString() {
        return "Nguoi[ten=" + ten + ", diaChi=" + diaChi + "]";
    }
}
class SinhVien extends Nguoi {
    private String chuongTrinh;
    private int namHoc;
    private double hocPhi;
    public SinhVien(String ten, String diaChi, String chuongTrinh, int namHoc, double hocPhi) {
        super(ten, diaChi);
        this.chuongTrinh = chuongTrinh;
        this.namHoc = namHoc;
        this.hocPhi = hocPhi;
    }
    public String layChuongTrinh() {
        return chuongTrinh;
    }
    public void datChuongTrinh(String chuongTrinh) {
        this.chuongTrinh = chuongTrinh;
    }
    public int layNamHoc() {
        return namHoc;
    }
    public void datNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }
    public double layHocPhi() {
        return hocPhi;
    }
    public void datHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }
    @Override
    public String toString() {
        return "SinhVien: " + super.toString() +
                ", chuongTrinh=" + chuongTrinh +
                ", namHoc=" + namHoc +
                ", hocPhi=" + hocPhi;
    }
}
class NhanVien extends Nguoi {
    private String truong;
    private double luong;
    public NhanVien(String ten, String diaChi, String truong, double luong) {
        super(ten, diaChi);
        this.truong = truong;
        this.luong = luong;
    }
    public String layTruong() {
        return truong;
    }
    public void datTruong(String truong) {
        this.truong = truong;
    }
    public double layLuong() {
        return luong;
    }
    public void datLuong(double luong) {
        this.luong = luong;
    }
    @Override
    public String toString() {
        return "NhanVien: " + super.toString() +
                ", truong=" + truong +
                ", luong=" + luong;
    }
}
class Main1 {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien("Mai Viet Hoang", "HCM", "CNTT", 2025, 20000000);
        System.out.println(sv.toString());

        NhanVien nv = new NhanVien("Ronaldo", "Han Quoc", "Mogwart", 15000000);
        System.out.println(nv.toString());
    }
}
