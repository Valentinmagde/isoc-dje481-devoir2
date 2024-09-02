import java.util.Scanner;

/**
 * Classe principale pour exécuter l'application de gestion des étudiants.
 * Cette classe permet de saisir les informations des étudiants, de calculer les statistiques de la classe, et de les afficher.
 */
public class Main {
    /**
     * Méthode principale pour exécuter le programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionEtudiants gestion = new GestionEtudiants();

        // Demande du nombre d'étudiants
        System.out.print("Entrez le nombre d'étudiants à gérer : ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne après nextInt()

        // Lecture des informations de chaque étudiant
        for (int i = 0; i < n; i++) {
            System.out.println("\nÉtudiant " + (i + 1) + ":");
            System.out.print("Entrez le matricule : ");
            String matricule = scanner.nextLine();
            System.out.print("Entrez le nom : ");
            String nom = scanner.nextLine();
            System.out.print("Entrez le prénom : ");
            String prenom = scanner.nextLine();
            System.out.print("Entrez la moyenne : ");
            double moyenne = scanner.nextDouble();
            scanner.nextLine(); // Consomme la nouvelle ligne après nextDouble()

            Etudiant etudiant = new Etudiant(matricule, nom, prenom, moyenne);
            gestion.ajouterEtudiant(etudiant);
        }

        // Affichage des statistiques
        System.out.println("\nStatistiques de la classe :");
        gestion.afficherStatistiques();
    }
}
