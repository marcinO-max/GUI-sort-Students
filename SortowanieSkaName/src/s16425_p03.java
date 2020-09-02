import java.lang.*;

import java.io.*;
import java.util.Scanner;

public class s16425_p03 {
    public static void main(String[] args) throws FileNotFoundException {
        String sciezka1 = "src/dane01.txt";
        String sciezka2 = "src/dane02.txt";
        String s = wspolny(sciezka1, sciezka2);
        Scanner scanner = new Scanner(s);
        int count = 0;
        while (scanner.hasNext()) {
            count++;
            scanner.nextLine();
        }
        Student[] tab = new Student[count];
        String[] linia;
        scanner = new Scanner(s);
        int pozycja = 0;

        while (scanner.hasNext()) {
            linia = scanner.nextLine().split(" ");
            tab[pozycja] = new Student(linia[0], linia[1], linia[2], Integer.parseInt(linia[3]));
            pozycja++;
        }
        sortowaniePoName(tab);
        //      sortowaniePoEsce(tab);


    }

    public static String wspolny(String sciezka1, String sciezka2) {
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fis1 = new FileInputStream(sciezka1);
            int c;
            while ((c = fis1.read()) != -1) {
                sb.append((char) c);
            }
            sb.append("\n");
            fis1.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


        try {
            FileInputStream fis2 = new FileInputStream(sciezka2);
            int c;
            while ((c = fis2.read()) != -1) {
                sb.append((char) c);
            }

            fis2.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


        String s = sb.toString();
        return s;
    }

    public static void sortowaniePoEsce(Student[] tab) throws FileNotFoundException {


        Student[] kopiaTablicyStudentow = tab.clone();
        Student wynik[] = new Student[tab.length];
        int najmniejszyIndex = 0;
        int najmnieszaWartosc = 99999;
        for (int i = 0; i < tab.length; i++) {
            najmniejszyIndex = 0;
            najmnieszaWartosc = 99999;
            for (int j = 0; j < wynik.length; j++) {
                if (kopiaTablicyStudentow[j] == null) {
                    continue;
                }
                if (getS(kopiaTablicyStudentow[j].getNumerIndeksu()) < najmnieszaWartosc) {
                    najmniejszyIndex = j;
                    najmnieszaWartosc = getS(kopiaTablicyStudentow[j].getNumerIndeksu());
                }
            }

            wynik[i] = kopiaTablicyStudentow[najmniejszyIndex];
            kopiaTablicyStudentow[najmniejszyIndex] = null;
        }

        String wynikString = "";
        for (int i = 0; i < wynik.length; i++) {
            wynikString += wynik[i] + "\r\n";
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("sortSka.txt");
            for (int i = 0; i < wynikString.length(); i++) {
                fos.write((int) wynikString.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void sortowaniePoName(Student[] tab) {
        Student temp;
        int count = 0;
        Student[] wynik = new Student[tab.length];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i].getImie().toCharArray()[count] <= tab[j].getImie().toCharArray()[count]) {
                    temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                } else if (tab[i].getImie().toCharArray()[count] == tab[j].getImie().toCharArray()[count]) {
                    count++;
                    j--;
                }
            }
        }


            String wynikString = "";
            for(int i = 0 ; i <tab.length;i++){
                wynikString+=tab[i]+"\r\n";
            }

            FileOutputStream fos = null;
            try{
                fos = new FileOutputStream("sortName.txt");
                for(int i = 0 ; i <wynikString.length();i++){
                    fos.write((int)wynikString.charAt(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }


    }


    public static int getS(String s) {
        String wynik = "";
        for (int i = 1; i < s.length(); i++) {
            wynik += s.charAt(i);
        }
        return Integer.parseInt(wynik);
    }
}




