import java.util.ArrayList;

public class Book {
    public String judul, author, penerbit;
    public Integer kategori, tahun;
    private ArrayList<String> listKategori = new ArrayList<String>();
    public Book(){
        this.listKategori.add(0, "Fiksi");
        this.listKategori.add(1, "Teknik");
        this.listKategori.add(2, "Manajemen");
        this.listKategori.add(3, "Lawas");
        this.listKategori.add(4, "Lainnya");
    }

    public Boolean checkAvailableCategory() {
        Boolean isFound = false;
        if (this.kategori >= 0 && this.kategori < this.listKategori.size()) {
            isFound = true;
        }
        return  isFound;
    }

    public String getKategori() {
        return this.listKategori.get(this.kategori);
    }

    public ArrayList<String> getListKategori() {
        return this.listKategori;
    }

}
