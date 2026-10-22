package ma.emsi.lakhsadi.tp0.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.Locale;

/**
 * Service d'analyse de texte : mots, caractères et voyelles.
 */
@Dependent
public class GenerateurReponse implements Serializable {

    /**
     * Analyse le texte fourni.
     * Le rôle sytème n'est pas utilisé pour ce traitement personnel.
     */
    public String genererReponse(String question, String roleSysteme) {
        String texte = question.strip();

        int nombreMots = texte.isEmpty()
                ? 0
                : texte.split("\\s+").length;

        int nombreCaracteres = question.length();
        int nombreVoyelles = 0;

        String voyelles = "aeiouyàâäéèêëîïôöùûüÿœ";

        for (char caractere : question.toLowerCase(Locale.FRENCH).toCharArray()) {
            if (voyelles.indexOf(caractere) >= 0) {
                nombreVoyelles++;
            }
        }

        return "Analyse du texte :\n"
                + "Mots : " + nombreMots + "\n"
                + "Caractères (espaces compris) : " + nombreCaracteres + "\n"
                + "Voyelles (y et voyelles accentuées inclus) : "
                + nombreVoyelles;
    }
}