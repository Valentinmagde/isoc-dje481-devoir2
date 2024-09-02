import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe pour gérer une liste d'étudiants et effectuer des opérations statistiques sur cette liste.
 */
public class GestionEtudiants {
    private List<Etudiant> etudiants;

    /**
     * Constructeur pour initialiser une nouvelle instance de GestionEtudiants.
     */
    public GestionEtudiants() {
        etudiants = new ArrayList<>();
    }

    /**
     * Ajoute un étudiant à la liste des étudiants.
     *
     * @param etudiant L'étudiant à ajouter.
     */
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    /**
     * Affiche et enregistre les statistiques de la classe dans un fichier nommé "stat.txt".
     * Les statistiques incluent :
     * - Le premier et le dernier étudiant de la classe
     * - La moyenne de la classe
     * - Le nombre d'étudiants ayant au moins la moyenne
     * - La liste des étudiants admis, recalés, et en rattrapage
     */
    public void afficherStatistiques() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant à traiter.");
            return;
        }

        // Trier les étudiants par moyenne décroissante
        etudiants.sort(Comparator.comparingDouble(Etudiant::getMoyenne).reversed());

        // Premier et dernier étudiant
        Etudiant premier = etudiants.get(0);
        Etudiant dernier = etudiants.get(etudiants.size() - 1);

        // Moyenne de la classe
        double moyenneClasse = etudiants.stream().mapToDouble(Etudiant::getMoyenne).average().orElse(0.0);

        // Nombre d'étudiants ayant au moins la moyenne
        long nbAuMoinsMoyenne = etudiants.stream().filter(e -> e.getMoyenne() >= moyenneClasse).count();

        // Listes des étudiants
        List<Etudiant> admis = new ArrayList<>();
        List<Etudiant> recales = new ArrayList<>();
        List<Etudiant> rattrapage = new ArrayList<>();

        for (Etudiant e : etudiants) {
            if (e.getMoyenne() >= 10) {
                admis.add(e);
            } else if (e.getMoyenne() < 7) {
                recales.add(e);
            } else {
                rattrapage.add(e);
            }
        }

        // Affichage des statistiques
        System.out.println("Premier de la classe : " + premier);
        System.out.println("Dernier de la classe : " + dernier);
        System.out.printf("Moyenne de la classe : %.2f%n", moyenneClasse);
        System.out.println("Nombre d'étudiants ayant au moins la moyenne de la classe : " + nbAuMoinsMoyenne);

        // Affichage de la liste des étudiants admis
        System.out.println("\nListe des étudiants admis :");
        if (admis.isEmpty()) {
            System.out.println("Aucun étudiant admis.");
        } else {
            admis.forEach(System.out::println);
        }

        // Affichage de la liste des étudiants recalés
        System.out.println("\nListe des étudiants recalés :");
        if (recales.isEmpty()) {
            System.out.println("Aucun étudiant recalé.");
        } else {
            recales.forEach(System.out::println);
        }

        // Affichage de la liste des étudiants en rattrapage
        System.out.println("\nListe des étudiants en rattrapage :");
        if (rattrapage.isEmpty()) {
            System.out.println("Aucun étudiant en rattrapage.");
        } else {
            rattrapage.forEach(System.out::println);
        }

        // Écriture dans le fichier stat.txt
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream("stat.txt"), "UTF-8"))) {
            writer.println("Premier de la classe : " + premier);
            writer.println("Dernier de la classe : " + dernier);
            writer.printf("Moyenne de la classe : %.2f%n", moyenneClasse);
            writer.println("Nombre d'étudiants ayant au moins la moyenne de la classe : " + nbAuMoinsMoyenne);

            writer.println("\nListe des étudiants admis :");
            if (admis.isEmpty()) {
                writer.println("Aucun étudiant admis.");
            } else {
                admis.forEach(writer::println);
            }

            writer.println("\nListe des étudiants recalés :");
            if (recales.isEmpty()) {
                writer.println("Aucun étudiant recalé.");
            } else {
                recales.forEach(writer::println);
            }

            writer.println("\nListe des étudiants en rattrapage :");
            if (rattrapage.isEmpty()) {
                writer.println("Aucun étudiant en rattrapage.");
            } else {
                rattrapage.forEach(writer::println);
            }
        } catch (java.io.IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier stat.txt : " + e.getMessage());
        }
    }
}
