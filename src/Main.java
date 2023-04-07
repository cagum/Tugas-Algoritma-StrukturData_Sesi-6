import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<Book>();
        HashMap<String, Integer> total = new HashMap<String, Integer>();
        Book bookTemp = new Book();

        System.out.println("----------------------- REGISTER BUKU -----------------------");
        System.out.println();
        System.out.println("List Kategori");
        int no = 0;
        for (String kategori : bookTemp.getListKategori() ) {
            total.put(kategori, 0);
            System.out.println(no + " " + kategori);
            no++;
        }

        System.out.println();
        System.out.println();

        boolean isNext = false;
        int bookLawas = 0;
        int bookBaru = 0;

        do {

            Book book = new Book();
            System.out.print("Judul : ");
            book.judul = input.nextLine();

            System.out.print("Author : ");
            book.author = input.nextLine();

            System.out.print("Penerbit : ");
            book.penerbit = input.nextLine();

            boolean foundKategori = true;
            do {
                System.out.print("Kategori : ");
                book.kategori = Integer.parseInt(input.nextLine());
                if (book.checkAvailableCategory()) {
                    foundKategori = false;
                } else {
                    System.out.println("Kategori tidak ditemukan silahkan ulang kembali !");
                }
            } while (foundKategori);

            System.out.print("Tahun : ");
            book.tahun = Integer.parseInt(input.nextLine());

            total.put(book.getKategori(), (total.get(book.getKategori()) + 1));

            if (book.tahun < 2010) {
                bookLawas += 1;
            } else {
                bookBaru += 1;
            }

            books.add(book);

            System.out.print("Apakah anda ingin menambah buku baru lagi ? [Y/n] ");
            String next = input.nextLine();

            System.out.println();
            System.out.println();

            if (next.equals("Y")) {
                isNext = true;
            } else {
                isNext = false;
            }

        } while (isNext);


        System.out.println();
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("Daftar Buku Yang Tersedia : ");
        System.out.println("======================================================================");
        System.out.println("No\t\tJudul\t\tPengarang \t\tPenerbit\t\tTahun\t\tKategori\t\t");
        System.out.println("======================================================================");
        int number = 1;
        for (Book book : books) {
            System.out.print(number + "\t\t");
            System.out.print(book.judul + "\t\t");
            System.out.print(book.author + "\t\t");
            System.out.print(book.penerbit + "\t\t");
            System.out.print(book.tahun + "\t\t\t");
            System.out.print(book.getKategori() + "\t\t");
            number ++;
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println("Jumlah buku yang tersedia : " + (bookLawas + bookBaru));
        for (String kategori : bookTemp.getListKategori()) {
            System.out.println("Buku " + kategori + " : " + total.get(kategori));
        }
        System.out.println("Buku Baru : " + bookBaru);
        System.out.println("Buku Lawas : " +  bookLawas);
    }
}