package ohtu.verkkokauppa;

import org.springframework.stereotype.*;

interface IViitegeneraattori {
    public int uusi();
}

@Component
public class Viitegeneraattori implements IViitegeneraattori {
    private int seuraava;

    public Viitegeneraattori(){
        seuraava = 1;
    }

    public int uusi(){
        return seuraava++;
    }
}
