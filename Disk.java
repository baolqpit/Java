import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public abstract class Disk{
    public String maDia;
    public String tenDia;
    public String theLoai;
    public int donGia;
    public ArrayList<String> ngayThue = new ArrayList<>(); // Nhap ngay thue va ngay tra theo cu phap d/m/yyyy vd: 14/1/2003
    public ArrayList<String> ngayTra = new ArrayList<>();

    // Constructor ko tham so
    public Disk(){
        maDia = "";
        tenDia = "";
        theLoai = "";
        donGia = 0;
    }

    // Constructor co tham so
    public Disk(String maDia, String tenDia, String theLoai, int donGia){
       this.maDia = maDia;
       this.tenDia = tenDia;
       this.theLoai = theLoai;
       this.donGia = donGia;
    }

    // Phuong thuc abstract tinh tien
    public abstract int tinhTien(int numberOfDays);

    // Phuong thuc thue dia va tra dia
    public void thueDia(String ngay){
        ngayThue.add(ngay);
    }

    public void traDia(String ngay){
        ngayTra.add(ngay);
    }

    public static void main(String[] args) {
        int numberOfDays = 0;
        ArrayList<Disk> danhSach = new ArrayList<Disk>();
        ArrayList<Disk> danhSachDiaQua7Ngay = new ArrayList<Disk>();

        // Them dia nhac vao danh sach
        MusicDisk nhac1 = new MusicDisk("001", "BangBang", "Giai tri", 20000);
        nhac1.thueDia("14/4/2022");
        nhac1.traDia("14/4/2022");
        MusicDisk nhac2 = new MusicDisk("002", "Lac Troi", "Nhac tre", 30000);
        nhac2.thueDia("17/5/2022");
        nhac2.traDia("18/5/2022");
        MusicDisk nhac3 = new MusicDisk("003", "No one", "Lofi", 15000);
        nhac3.thueDia("25/7/2022");
        nhac3.traDia("30/8/2022");

        danhSach.add(nhac1);
        danhSach.add(nhac2);
        danhSach.add(nhac3);

        // Them dia phim vao danh sach
        FilmDisk phim1 = new FilmDisk("001", "Star War", "Vien tuong", 50000, 1.0);
       phim1.thueDia("13/2/2022");
       phim1.traDia("15/2/2022");
        FilmDisk phim2 = new FilmDisk("002", "End Game", "Anh Hung", 100000, 1.5);
       phim2.thueDia("4/9/2022");
       phim2.traDia("6/9/2022");
        FilmDisk phim3 = new FilmDisk("003", "Lat Mat", "Hanh dong", 30000, 1.5);
       phim3.thueDia("31/12/2022");
       phim3.traDia("5/2/2023");

        danhSach.add(phim1);
        danhSach.add(phim2);
        danhSach.add(phim3);

        // Duyet qua danh sach cac dia da duoc them va in ra 
       for (Disk disk : danhSach){
        LocalDate localDate1 = LocalDate.parse(disk.ngayThue.get(0), java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"));
        LocalDate localDate2 = LocalDate.parse(disk.ngayTra.get(0), java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"));
        long soNgayThue = ChronoUnit.DAYS.between(localDate1, localDate2);
        numberOfDays = (int) soNgayThue;
        System.out.println("Ma dia: " + disk.maDia + "\tTen dia: " + disk.tenDia + "\tThe loai: " + 
        disk.theLoai + "\tDon gia: " + disk.donGia + "Ngay thue: " + disk.ngayThue+ "Ngay tra: " + disk.ngayTra 
        + "\tSo ngay thue: " + soNgayThue + "\tTong don gia: " + disk.tinhTien(numberOfDays));
        if (soNgayThue > 7) {
            danhSachDiaQua7Ngay.add(disk);
        }
       }
       // Tim ra phim co ma Id la 001
       System.out.println("Dia phim co ma so 001");
       for(Disk disk : danhSach){
            if (disk.maDia == "001"){
                System.out.println("\tTen dia:" + disk.tenDia + "\tThe loai: " + disk.theLoai);
            }
        }
        // Tim ra dia co so ngay thue qua 7 ngay
        System.out.println("Dia co ngay thue qua 7 ngay");
        for(Disk disk : danhSachDiaQua7Ngay){
            System.out.println("\tTen dia:" + disk.tenDia + "\tThe loai: " + disk.theLoai);
        }
}
}
