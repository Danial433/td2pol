import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Biblio biblio1 = new Biblio("Alexandre");

        System.out.println("1. Afficher la bibliotheque.");
        System.out.println("2. Chercher les livres d'un type");
        System.out.println("3. Chercher un livre donné par son ISBN");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. Modifier un livre");
        System.out.println("Q. Quit");
        System.out.println("Votre choix: ");

        String options = null;
        Scanner scanner = new Scanner(System.in); // Capturing the input
        do {
            options = scanner.nextLine();
            switch (options) {
                case "1":
                    biblio1.afficher();
                    break;
                case "2":
                    System.out.print("Type (Roman, Journal, BD) : ");
                    String type = scanner.nextLine();

                    switch(type) {
                        case "Roman" :
                            biblio1.chercherLivreParType(Roman.class);
                            break;
                        case "Journal" :
                            biblio1.chercherLivreParType(Journal.class);
                            break;
                        case "BD" : 
                            biblio1.chercherLivreParType(BD.class);
                            break;
                        default : 
                            System.out.println("Type inconnu.");                           
                    }
                    break;
                case "3":
                    System.out.println("ISBN : ");
                    String ISBN_3 = scanner.nextLine();

                    biblio1.rechercherLivre(ISBN_3);
                    break;
                case "4":
                    System.out.println("ISBN : ");
                    String ISBN_4 = scanner.nextLine();

                    biblio1.supprimer(ISBN_4);
                    break;
                case "5":
                    System.out.println("ISBN : ");
                    String ISBN_5 = scanner.nextLine();
                    System.out.println("Nouveau Titre : ");
                    String titre_5 = scanner.nextLine();
                    System.out.println("Auteur : ");
                    String auteur_5 = scanner.nextLine();
                    
                    break;
            }
        } while (!options.equals("Q")); // quitting the program
    }
    }

