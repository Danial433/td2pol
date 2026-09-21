import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Biblio biblio1 = new Biblio("Alexandre");

        Scanner scanner = new Scanner(System.in);

        String options;

        do {
            System.out.println();
            System.out.println("===== GESTION DE LA BIBLIOTHEQUE =====");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Afficher la bibliotheque");
            System.out.println("3. Chercher les livres d'un type");
            System.out.println("4. Chercher un livre donné par son ISBN");
            System.out.println("5. Supprimer un livre");
            System.out.println("6. Modifier un livre");
            System.out.println("7. Ajouter un exemplaire");
            System.out.println("8. Prêter un exemplaire");
            System.out.println("9. Rendre un exemplaire");
            System.out.println("Q. Quit");
            System.out.println("Votre choix : ");

            options = scanner.nextLine();

            switch (options) {

                case "1":
                    System.out.println("Type (Roman, Journal, BD) : ");
                    String type = scanner.nextLine();

                    System.out.println("Titre : ");
                    String titre = scanner.nextLine();

                    System.out.println("Auteur : ");
                    String auteur = scanner.nextLine();

                    System.out.println("ISBN : ");
                    String isbn = scanner.nextLine();

                    switch (type) {

                        case "Roman":
                            System.out.println("Genre : ");
                            String genre = scanner.nextLine();

                            Roman roman = new Roman(titre, auteur, isbn, genre);
                            biblio1.ajouteLivre(roman);
                            System.out.println("Roman ajouté.");
                            break;

                        case "Journal":
                            System.out.println("Numero de parution : ");
                            String numeroParution = scanner.nextLine();

                            Journal journal = new Journal(
                                    titre, auteur, isbn, numeroParution);

                            biblio1.ajouteLivre(journal);
                            System.out.println("Journal ajouté.");
                            break;

                        case "BD":
                            System.out.println("Dessinateur : ");
                            String dessinateur = scanner.nextLine();

                            BD bd = new BD(
                                    titre, auteur, isbn, dessinateur);

                            biblio1.ajouteLivre(bd);
                            System.out.println("BD ajoutée.");
                            break;

                        default:
                            System.out.println("Type inconnu.");
                    }
                    break;

                case "2":
                    biblio1.afficher();
                    break;

                case "3":
                    System.out.print("Type (Roman, Journal, BD) : ");
                    String typeRecherche = scanner.nextLine();

                    switch (typeRecherche) {

                        case "Roman":
                            biblio1.chercherLivreParType(Roman.class);
                            break;

                        case "Journal":
                            biblio1.chercherLivreParType(Journal.class);
                            break;

                        case "BD":
                            biblio1.chercherLivreParType(BD.class);
                            break;

                        default:
                            System.out.println("Type inconnu.");
                    }
                    break;

                case "4":
                    System.out.println("ISBN : ");
                    String ISBN_4 = scanner.nextLine();

                    Livre livre = biblio1.rechercherLivre(ISBN_4);

                    if (livre != null) {
                        livre.afficher();
                    } else {
                        System.out.println("Livre introuvable.");
                    }
                    break;

                case "5":
                    System.out.println("ISBN : ");
                    String ISBN_5 = scanner.nextLine();

                    if (biblio1.supprimer(ISBN_5)) {
                        System.out.println("Livre supprimé.");
                    } else {
                        System.out.println("Livre introuvable.");
                    }
                    break;

                case "6":
                    System.out.println("ISBN : ");
                    String ISBN_6 = scanner.nextLine();

                    System.out.println("Nouveau Titre : ");
                    String titre_6 = scanner.nextLine();

                    System.out.println("Nouvel Auteur : ");
                    String auteur_6 = scanner.nextLine();

                    System.out.println(
                            biblio1.modifierLivre(
                                    ISBN_6, titre_6, auteur_6));
                    break;

                case "7":
                    System.out.println("ISBN du livre : ");
                    String ISBN_7 = scanner.nextLine();

                    Livre livreExemplaire =
                            biblio1.rechercherLivre(ISBN_7);

                    if (livreExemplaire != null) {

                        System.out.println("Emplacement : ");
                        String emplacement = scanner.nextLine();

                        System.out.println("Etat : ");
                        String etat = scanner.nextLine();

                        Exemplaire exemplaire =
                                new Exemplaire(emplacement, etat);

                        livreExemplaire.ajouterExemplaire(exemplaire);

                        System.out.println("Exemplaire ajouté.");

                    } else {
                        System.out.println("Livre introuvable.");
                    }
                    break;

                case "8":
                    System.out.println("ISBN du livre : ");
                    String ISBN_8 = scanner.nextLine();

                    Livre livrePreter =
                            biblio1.rechercherLivre(ISBN_8);

                    if (livrePreter != null) {

                        if (livrePreter.getExemplaires().size() == 0) {
                            System.out.println(
                                    "Ce livre n'a pas d'exemplaire.");
                        } else {

                            System.out.println("Exemplaires : ");

                            for (int i = 0;
                                 i < livrePreter.getExemplaires().size();
                                 i++) {

                                System.out.println(
                                        (i + 1) + ". "
                                        + livrePreter.getExemplaires()
                                                .get(i)
                                                .getEmplacement()
                                        + " - "
                                        + livrePreter.getExemplaires()
                                                .get(i)
                                                .getEtat());
                            }

                            System.out.println(
                                    "Choisir un exemplaire : ");

                            int choix =
                                    Integer.parseInt(scanner.nextLine());

                            if (choix > 0 &&
                                choix <= livrePreter
                                        .getExemplaires().size()) {

                                Exemplaire exemplaire =
                                        livrePreter
                                                .getExemplaires()
                                                .get(choix - 1);

                                exemplaire.preter();

                                System.out.println(
                                        "Exemplaire prêté.");

                            } else {
                                System.out.println(
                                        "Exemplaire invalide.");
                            }
                        }

                    } else {
                        System.out.println("Livre introuvable.");
                    }
                    break;

                case "9":
                    System.out.println("ISBN du livre : ");
                    String ISBN_9 = scanner.nextLine();

                    Livre livreRendre =
                            biblio1.rechercherLivre(ISBN_9);

                    if (livreRendre != null) {

                        if (livreRendre.getExemplaires().size() == 0) {
                            System.out.println(
                                    "Ce livre n'a pas d'exemplaire.");
                        } else {

                            System.out.println("Exemplaires : ");

                            for (int i = 0;
                                 i < livreRendre.getExemplaires().size();
                                 i++) {

                                System.out.println(
                                        (i + 1) + ". "
                                        + livreRendre.getExemplaires()
                                                .get(i)
                                                .getEmplacement()
                                        + " - "
                                        + livreRendre.getExemplaires()
                                                .get(i)
                                                .getEtat());
                            }

                            System.out.println(
                                    "Choisir un exemplaire : ");

                            int choix =
                                    Integer.parseInt(scanner.nextLine());

                            if (choix > 0 &&
                                choix <= livreRendre
                                        .getExemplaires().size()) {

                                Exemplaire exemplaire =
                                        livreRendre
                                                .getExemplaires()
                                                .get(choix - 1);

                                exemplaire.rendre();

                                System.out.println(
                                        "Exemplaire rendu.");

                            } else {
                                System.out.println(
                                        "Exemplaire invalide.");
                            }
                        }

                    } else {
                        System.out.println("Livre introuvable.");
                    }
                    break;

                case "Q":
                case "q":
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (!options.equalsIgnoreCase("Q"));

        scanner.close();
    }
}

