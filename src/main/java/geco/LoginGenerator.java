package geco;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Classe representant un generateur de login
 */
public class LoginGenerator {

    private LoginService loginService;

    /**
     * Construit un login generator
     *
     * @param loginService le service de login
     */
    public LoginGenerator(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Genere un login unique a partir d'un nom et d'un prenom en prenant la premiere lettre du prenom, concatenee avec
     * les 3 premieres lettres du nom, le tout mis en lettres capitales et desaccentue. Le login genere doit etre unique
     * par rapport a la liste des logins existants. En cas de doublon, on incremente le doublon d'un indice. Ci dessous des
     *
     * @param nom    le nom
     * @param prenom le prenom
     * @return le login genere
     */
    public String generateLoginForNomAndPrenom(String nom, String prenom) {
        String p = deAccent(prenom.substring(0, 1).toUpperCase());

        StringBuilder nBuilder = new StringBuilder();

        for (int i = 0; i < nom.length(); i++) {
            if (i<3){
                nBuilder.append(nom.charAt(i));
            }else{
                break;
            }
        }
        String n = deAccent(nBuilder.toString().toUpperCase());
        String login = p + n;

        if (loginService.loginExists(login)) {
            for (int i = 1; i < 100; i++) {
                if (!loginService.loginExists(login + i)) {
                    login = login + i;
                    break;
                }
            }
        }
        loginService.addLogin(login);
        return login;
    }

    /**
     * Supprime les accents d'une chaine de caractere
     *
     * @param str la chaine de caractere
     * @return la chaine de caractere sans accents
     */
    private String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }


}
