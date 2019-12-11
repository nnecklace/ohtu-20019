package ohtu.kivipaperisakset;

public abstract class Peli {
    protected Tuomari tuomari;

    public Peli(Tuomari tuomari) {
        this.tuomari = tuomari;
    }

    public abstract void pelaa();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}