public class BD extends Livre {
    private String dessinateur;

    public Roman(String titre, String auteur, String isbn, String dessinateur) {
        super(titre, auteur, isbn);
        this.dessinateur = dessinateur;
    }

    public String getDessinateur() {
        return dessinateur;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Dessinateur : "+dessinateur);
    }
}

