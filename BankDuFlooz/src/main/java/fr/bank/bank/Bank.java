package fr.bank.bank;

import fr.bank.person.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    //Initialisation du scanner
    Scanner scan = new Scanner(System.in);

    int nombreClients = 0;
    int nombreCompte = 0;
    List<Agency> listAgency = new ArrayList<Agency>();

    public void addAgency(Agency agency){
        this.listAgency.add(agency);
    }

    //GettersSetters
    public int getNombreClients() {
        return nombreClients;
    }

    public void setNombreClients(int nombreClients) {
        this.nombreClients = nombreClients;
    }

    public int getNombreCompte() {
        return nombreCompte;
    }

    public void setNombreCompte(int nombreCompte) {
        this.nombreCompte = nombreCompte;
    }

    public List<Agency> getListAgency() {
        return listAgency;
    }

    public void setListAgency(List<Agency> listAgency) {
        this.listAgency = listAgency;
    }

    //Methods

    /**
     * Methode pour rechercher un client par son login parmi tous les comptes de la banque
     * vérifie dans chaque agence.
     */
    public Client verifLogin() {
        Client clientToFound = null;
        do {
            System.out.println("Saisissez votre Login: ");
            String login = scan.next();
            for (Agency agency : this.listAgency) {
                for (Client client : agency.listClients) {
                    if (client.getLogin().equals(login)) {
                        System.out.println("Client trouvé");
                        clientToFound =  verifPassword(client);
                    } else {
                        System.out.println("Client introuvable");
                    }
                }
            }
        }while (clientToFound == null);
        return clientToFound;
    }

    /**
     * Methode pour vérifier le mot de passe du client trouvé par le login
     * dans la methode verifLogin
     * @param client le client trouvé par vérifLogin
     * @return le client dont on veut les infos
     */
    public Client verifPassword(Client client){
        String password;
        do {
            System.out.println("Saisissez votre mot de passe");
            password = scan.next();
            if(client.getPassword().equals(password)){
                System.out.println("OK");
            }else {
                System.out.println("Mot de passe incorrect");
            }
        }while (!password.equals(client.getPassword()));
        return client;
    }

    /**
     * Methode pour choisir le compte à modifier
     * @param clientFound les infos du client identifié
     * @return le compte selectionné
     */
    public Account displayAccountChoice(Client clientFound) {
        int cursor = 1;
        int accountId;
        do {
            System.out.println("Choisissez le compte à utiliser");
            for (Account account : clientFound.getListAccounts()) {
                System.out.println(cursor + " " + account.getType());
                cursor++;
            }
            cursor = 1;
            System.out.println("Numéro du compte : ");
            accountId = scan.nextInt();
        } while ( accountId < 1 || accountId > clientFound.getListAccounts().size());
        return clientFound.getListAccounts().get(accountId-1);
    }

    /**
     * Methode pour verifier le type de compte
     * @param account le compte a analyser
     * @return le type de compte
     */
    public String checkAccountType(Account account){
        String accountType;
        if(account instanceof CurrentAccount){
           accountType = "compte courant";
        }else if (account instanceof PaidAccount){
            accountType = "compte payant";
        }else {
            accountType = "compte rémunéré";
        }
        return accountType;
    }

    /**
     * Methode pour afficher les données du compte selon son type
     * @param accountType le nom du type de compte
     * @param account le compte à analyser
     */
    public void displayAccount(String accountType, Account account){
        if (accountType.equals("compte courant")){
            System.out.println("COMPTE COURANT");
            CurrentAccount cu = (CurrentAccount) account;
            System.out.println("Solde: " + cu.getSold()+ "€");
        } else if (accountType.equals("compte payant")){
            System.out.println("COMPTE PAYANT");
            PaidAccount pa = (PaidAccount) account;
            System.out.println("Solde: " + pa.getSold()+ "€");
        } else {
            System.out.println("COMPTE REMUNERE");
            SavingAccount sa = (SavingAccount) account;
            System.out.println("Solde: " + sa.getSold()+ "€");
            System.out.println("Taux: " + sa.getInterestRate());
        }
    }

    public int chooseOperation(Account chosenAccount){
        //le numéro de l'opération à effectuer
        int chosenOperation = 0;
        //liste des opérations possibles
        List<String> listChoice = new ArrayList<>();
        //boolean pour vérifier si l'entrée est valide
        Boolean isvalid = false;

        do {
            //vide la liste au cas ou elle a deja des données.
            listChoice.clear();
            //ajoute les differentes possibilités de choix
            listChoice.add("1. Déposer de l'argent");
            listChoice.add("2. Retirer de l'argent");
            listChoice.add("3. Vérifier taux");
            System.out.println("Que souhaitez vous faire?");
            if (chosenAccount.isRemovable()) {
                listChoice.remove(2);
                for (int i = 0; i < listChoice.size(); i++) {
                    System.out.println(listChoice.get(i));
                }
            } else if (chosenAccount instanceof SavingAccount) {
                for (int i = 0; i < listChoice.size(); i++) {
                    System.out.println(listChoice.get(i));
                }
            } else {
                listChoice.remove(1);
                listChoice.remove(1);
                System.out.println(listChoice.get(0));
            }
            //saisie de l'utilisateur
            chosenOperation = scan.nextInt();
            //vérifie si l'entrée est valide
            if (chosenOperation < 1 || chosenOperation > listChoice.size()){
                isvalid = false;
            }else {
                isvalid = true;
            }
            System.out.println(chosenOperation);
        }while (!isvalid);
        return chosenOperation;
    }

    /**
     * Methode pour effectuer les différentes opérations possibles selon le compte
     * @param chosenOperation l'opération choisie
     * @param accountFound le compte sur lequel faire les opérations
     */
    public void makeOperation(int chosenOperation, Account accountFound){
        boolean isValid = false;
        //cast du compte pour être sûr d'avoir le bon type de compte
//        if (accountFound instanceof CurrentAccount){
//            CurrentAccount returnAccount = (CurrentAccount) accountFound;
//        }else if (accountFound instanceof PaidAccount){
//            PaidAccount returnAccount = (PaidAccount) accountFound;
//        }else {
//            SavingAccount returnAccount = (SavingAccount) accountFound;
//        }
        //Déposer de l'argent
        if (chosenOperation == 1){
            System.out.println("Quelle somme voulez-vous déposer?");
            CurrentAccount cu = (CurrentAccount) accountFound;
            double sum = scan.nextDouble();
            cu.setSold(cu.getSold() + sum);
            System.out.println("Votre nouveau solde est de " + cu.getSold() + "€");
        //Retirer de l'argent
        }else if (chosenOperation == 2){
            do {
                System.out.println("Quelle somme voulez-vous retirer?");
                CurrentAccount cu = (CurrentAccount) accountFound;
                double sum = scan.nextDouble();
                if (sum < cu.getSold()) {
                    cu.setSold(cu.getSold() - sum);
                    System.out.println("Votre nouveau solde est de " + cu.getSold() + "€");
                    isValid = true;
                } else {
                    if (sum < 1) {
                        System.out.println("Vous ne pouvez pas retirer une somme négative");
                    } else {
                        System.out.println("Votre compte ne peux pas être à découvert");
                    }
                }
            }while (!isValid) ;
        //Vérifier son taux
        }else {
            SavingAccount sa = (SavingAccount) accountFound;
            System.out.println("Votre taux actuel est " + sa.getInterestRate());
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + nombreClients +
                ", listAgency=" + listAgency +
                '}';
    }
}
