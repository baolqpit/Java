public class MusicDisk extends Disk {

    public MusicDisk(){
        super();
    }

    public MusicDisk(String maDia, String tenDia, String theLoai, int donGia){
        super(maDia, tenDia, theLoai, donGia);
    }

    public int tinhTien(int numberOfDays){
        return donGia * numberOfDays;
    }
}