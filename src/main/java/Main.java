import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.List;

public class Main {
    public static List<Biblioteka> produkty;
    public static int licznik;
    public static void main(String[] args) throws IOException{
        WczytajDane();
        Menu();
    }
    public static void Menu() throws IOException {
        System.out.println("1 Wypozycz ksiazke");
        System.out.println("2 Wyswietl dostepne ksiazki");
        System.out.println("3 Wyjdz");
        Scanner wczytywanie = new Scanner(System.in);
        int opcja;
        opcja = wczytywanie.nextInt();
        switch(opcja) {
            case 1:
                Wypozycz();
                break;
            case 2:
                Magazyn();
                break;
            case 3:
                Wyjdz();
        }
    }
    public static void WczytajDane() throws IOException {
        File file = new File("src/main/resources/baza.txt");
        Scanner in = new Scanner(file);
        licznik = 0;
        Biblioteka tymczas;
        produkty = new ArrayList<Biblioteka>();
        while(in.hasNext() != false) {
            tymczas = new Biblioteka(in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine()));
            produkty.add(tymczas);
            licznik++;
        }
        in.close();
    }
    public static void Wyjdz(){
        System.exit(0);
    }
    public static void Magazyn() throws IOException{
        for(int i=0; i<licznik; i++) {
            System.out.println(produkty.get(i).getTytul() + " " + produkty.get(i).getAutor() + " " + produkty.get(i).getIlosc() + "szt");
        }
        System.out.println("0 Wroc do menu");
        Scanner wczytaj = new Scanner(System.in);
        int opcja;
        opcja = wczytaj.nextInt();
        while(opcja != 0){
            System.out.println("Nieprawidlowy numer");
            System.out.println("0 Wroc do menu");
            opcja = wczytaj.nextInt();
        }
        Menu();
    }
    public static void Wypozycz() throws IOException {
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Wybierz ksiazke");
        for(int i =0; i<licznik; i++) {
            System.out.println(i + " " + produkty.get(i).getTytul() + " " + produkty.get(i).getAutor() + " " + produkty.get(i).getIlosc() + "szt");
        }
        int opcja = wczytaj.nextInt();
        if(opcja < licznik && opcja >= 0)
        {
            if(produkty.get(opcja).getIlosc() != 0) {
                produkty.get(opcja).setIlosc(produkty.get(opcja).getIlosc() - 1);
                System.out.println("Wypozyczono: " + produkty.get(opcja).getTytul() + " za " + produkty.get(opcja).getAutor());
                PrintWriter wyp = new PrintWriter("src/main/resources/baza.txt");
                for(int i=0; i<licznik; i++){
                    wyp.println(produkty.get(i).getTytul() + "\n" + produkty.get(i).getAutor() + "\n" + produkty.get(i).getIlosc());
                }
                wyp.close();
            }
            else{
                System.out.println("Chwilowy brak egzemplarzy");
            }
        }
        else
        {
            System.out.println("Nieprawidlowy numer ksiazki");
        }
        System.out.println("0 Wroc do menu");
        int opcja2 = wczytaj.nextInt();
        while(opcja2 != 0){
            System.out.println("Nieprawidlowy numer");
            System.out.println("[0] - Powrot do menu glownego");
            opcja2 = wczytaj.nextInt();
        }
        Menu();
    }
}