package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    private static Peli luoPeli(String type) {
        Tuomari tuomari = new Tuomari();
        if (type.endsWith("a")) {
            return new KPSPelaajaVsPelaaja(tuomari);
        }

        if (type.endsWith("b")) {
            return new KPSTekoaly(tuomari, new Tekoaly());
        }

        if (type.endsWith("c")) {
            return new KPSTekoaly(tuomari, new TekoalyParannettu(20));
        }

        return null;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            Peli peli = luoPeli(vastaus);
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

            if (peli == null) {
                break;
            }

            peli.pelaa();

        }

    }
}
