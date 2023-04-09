public class FilmDisk extends Disk{
    public double loaiDia;

    public FilmDisk(){
        super();
        loaiDia = 0;
    }

    public FilmDisk(String maDia, String tenDia, String theLoai, int donGia, double loaiDia){
        super(maDia, tenDia, theLoai, donGia);
        this.loaiDia = loaiDia;
    }

    public int tinhTien(int numberOfDays){
        return (numberOfDays > 7) ? (int)(donGia * numberOfDays * loaiDia * 1.2) : (int)(donGia * numberOfDays * loaiDia);
    }
    
}
