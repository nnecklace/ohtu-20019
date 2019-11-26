package laskin;

import javafx.scene.control.TextField;

public class Summa implements Komento {
    TextField a, b;
    Sovelluslogiikka s;
    int arvo;

    public Summa(TextField a, TextField b, Sovelluslogiikka s) {
        this.a = a;
        this.b = b;
        this.s = s;
    }

    public void suorita() {
        Integer i = Integer.parseInt(this.b.getText());
        this.arvo = i;
        s.plus(i);
        this.a.setText(s.tulos()+"");
    }

    public void peru() {
        s.miinus(this.arvo);
        this.a.setText(s.tulos()+"");
    }
}