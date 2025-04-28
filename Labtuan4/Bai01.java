package Labtuan4;
class HinhTron {
    private double banKinh = 1.0;
    private String mauSac = "đỏ";

    public HinhTron() {
        this.banKinh = 1.0;
        this.mauSac = "đỏ";
    }
    public HinhTron(double banKinh) {
        this.banKinh = banKinh;
        this.mauSac = "đỏ";
    }
    public HinhTron(double banKinh, String mauSac) {
        this.banKinh = banKinh;
        this.mauSac = mauSac;
    }
    public double layBanKinh() {
        return banKinh;
    }
    public String layMauSac() {
        return mauSac;
    }
    public void datBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }
    public void datMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }
    @Override
    public String toString() {
        return "HinhTron[bán kính=" + banKinh + ", màu sắc=" + mauSac + "]";
    }
}
class HinhTru extends HinhTron {
    private double chieuCao = 1.0;
    public HinhTru() {
        super();
        this.chieuCao = 1.0;
    }
    public HinhTru(double banKinh) {
        super(banKinh);
        this.chieuCao = 1.0;
    }
    public HinhTru(double banKinh, double chieuCao) {
        super(banKinh);
        this.chieuCao = chieuCao;
    }
    public HinhTru(double banKinh, double chieuCao, String mauSac) {
        super(banKinh, mauSac);
        this.chieuCao = chieuCao;
    }
    public double layChieuCao() {
        return chieuCao;
    }
    public void datChieuCao(double chieuCao) {
        this.chieuCao = chieuCao;
    }
    public double tinhTheTich() {
        return tinhDienTich() * chieuCao;
    }
    @Override
    public String toString() {
        return "HinhTru: kế thừa từ " + super.toString() + ", chiều cao=" + chieuCao;
    }
}
class Main {
    public static void main(String[] args) {
        HinhTron hinhTron = new HinhTron(2.0, "xanh dương");
        System.out.println(hinhTron.toString());
        System.out.println("Diện tích Hình Tròn: " + hinhTron.tinhDienTich());
        HinhTru hinhTru = new HinhTru(2.0, 3.0, "xanh lá");
        System.out.println(hinhTru.toString());
        System.out.println("Thể tích Hình Trụ: " + hinhTru.tinhTheTich());
    }
}
