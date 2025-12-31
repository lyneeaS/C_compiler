package tp1;
import java.util.*;

public class ScannerCode1 {

    private static final String[] motsCles = {
        "int", "float", "printf", "scanf", "if", "else", "main"
    };

    private static final String[] symboles = {
        ";", ",", "(", ")", "{", "}"
    };

    private static final String[] operateurs = {
        "=", "+", "-", "*", "/", "%"
    };

    public void analyser(String code) {

        String[] separer = code.split(
            "\\s+|(?=[;(),{}=+*/%])|(?<=[;(),{}=+*/%])"
        );

        Set<String> tabMotsCles = new HashSet<>();
        Set<String> tabSymboles = new HashSet<>();
        Set<String> tabIdentificateurs = new HashSet<>();
        Set<String> tabOperateurs = new HashSet<>();
        Set<String> tabChaines = new HashSet<>();

        for (String t : separer) {
            if (t.isEmpty()) continue;

            if (Arrays.asList(motsCles).contains(t)) {
                tabMotsCles.add(t);
            }
            else if (Arrays.asList(symboles).contains(t)) {
                tabSymboles.add(t);
            }
            else if (Arrays.asList(operateurs).contains(t)) {
                tabOperateurs.add(t);
            }
            else if (t.startsWith("\"") && t.endsWith("\"")) {
                tabChaines.add(t.replace("\"", ""));
            }
            else {
                tabIdentificateurs.add(t);
            }
        }

        System.out.println("\n1 Mots clés : " + tabMotsCles);
        System.out.println("2 Symboles : " + tabSymboles);
        System.out.println("3 Identificateurs : " + tabIdentificateurs);
        System.out.println("4 Opérateurs : " + tabOperateurs);
        System.out.println("5 Chaines : " + tabChaines);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer votre code :");
        String code = sc.nextLine();

        ScannerCode1 obj = new ScannerCode1();
        obj.analyser(code);

        sc.close();
    }
}
