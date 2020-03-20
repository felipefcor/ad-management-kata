package domain.ad;

import domain.Ad.AdTitle;
import domain.exceptions.TitleTooLongException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AdTitleShould {

    @Test
    public void throw_an_exception_when_tries_to_create_a_title_with_more_than_50_characters(){

        Assertions.assertThrows(TitleTooLongException.class, () -> new AdTitle("Esto es una prueba para comprobar que no se puede añadir más de " +
                "cincuenta caracteres a un titulo"));

    }

}

