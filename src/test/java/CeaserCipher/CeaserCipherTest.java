package CeaserCipher;
import org.junit.*;
import static org.junit.Assert.*;

public class CeaserCipherTest{

    @Test
    public void rotateCharacter_ShiftsCharacterCorrectNumberofTimesAtEndOfAlphabet_char(){
        char input='x';
        char expectedOutput='h';

        assertEquals(expectedOutput, CeaserCipher.cipher(input, 10));
    }

    

}