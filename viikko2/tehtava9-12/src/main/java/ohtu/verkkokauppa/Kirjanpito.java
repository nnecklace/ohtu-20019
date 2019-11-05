package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.stereotype.*;

interface IKirjanpito {
    public void lisaaTapahtuma(String tapahtuma);
    public ArrayList<String> getTapahtumat();
}

@Component
public class Kirjanpito implements IKirjanpito {
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }

    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }
}
