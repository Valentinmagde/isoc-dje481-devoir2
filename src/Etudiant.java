/**
 * Classe représentant un étudiant avec un matricule, un nom, un prénom et une moyenne.
 */
public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;
    private double moyenne;

    /**
     * Constructeur pour initialiser un objet Etudiant avec les informations fournies.
     *
     * @param matricule Le matricule de l'étudiant.
     * @param nom Le nom de l'étudiant.
     * @param prenom Le prénom de l'étudiant.
     * @param moyenne La moyenne de l'étudiant.
     */
    public Etudiant(String matricule, String nom, String prenom, double moyenne) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    /**
     * Obtient le matricule de l'étudiant.
     *
     * @return Le matricule de l'étudiant.
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Obtient le nom de l'étudiant.
     *
     * @return Le nom de l'étudiant.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient le prénom de l'étudiant.
     *
     * @return Le prénom de l'étudiant.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Obtient la moyenne de l'étudiant.
     *
     * @return La moyenne de l'étudiant.
     */
    public double getMoyenne() {
        return moyenne;
    }

    /**
     * Retourne une représentation textuelle de l'étudiant.
     *
     * @return Une chaîne de caractères représentant l'étudiant.
     */
    @Override
    public String toString() {
        return nom + " " + prenom + " - Matricule: " + matricule + ", Moyenne: " + moyenne;
    }
}
