package privateschool;

import java.util.Scanner;
import utils.Console_Simple;

/**
 *
 * @author mcvakou
 */
public class PrivateSchool {

    public static void main(String[] args) {
//ΔΕΝ ΕΛΕΓΧΩ ΤΑ input ΤΟΥ ΧΡΗΣΤΗ ΟΤΑΝ ΠΕΡΝΑΕΙ ΤΙΜΕΣ ΣΤΑ columns ΤΩΝ tables.
//ΕΛΕΓΧΩ ΕΓΡΑΦΕΣ ΠΟΥ ΔΕΝ ΜΠΟΡΕΙ ΝΑ ΔΕΧΤΕΙ Η ΒΑΣΗ Κ ΤΟ ΜΕΝΟΥ.
        Scanner sc = new Scanner(System.in);
        Console_Simple console = new Console_Simple();

        console.mainProcess(sc);
        sc.close();
    }
}
