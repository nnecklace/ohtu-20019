package laskin;

import javafx.scene.control.TextField;

public class Nollaa implements Komento {
    TextField a, b;
    Sovelluslogiikka s;
    int arvo;

    public Nollaa(TextField a, TextField b, Sovelluslogiikka s) {
        this.a = a;
        this.b = b;
        this.s = s;
    }

    public void suorita() {
        this.arvo = Integer.parseInt(this.a.getText());
        this.a.setText("0");
        s.nollaa();
        this.b.setText("0");
    }

    public void peru() {
        s.plus(this.arvo);
        this.a.setText(s.tulos()+"");
    }
}