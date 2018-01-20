

public class Biblioteka {
        String Tytul;
        String Autor;
        int Egzemplarze;
        public Biblioteka(){}
        public Biblioteka(String t, String a, int e){
            Tytul = t;
            Autor = a;
            Egzemplarze = e;
        }
        public String getTytul(){
            return Tytul;
        }
        public int getIlosc(){
            return Egzemplarze;
        }
        public String getAutor() {
            return Autor;
        }
        public void setIlosc(int il){
            if(Egzemplarze <= 0){
                System.out.println("Ilosc produktu nie moze byc mniejsza lub rowna 0");
            }
            else{
                Egzemplarze = il;
            }
        }
}
