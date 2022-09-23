package fr.bank;

import fr.bank.bank.*;
import fr.bank.person.Client;
import fr.bank.person.Status;

import java.util.Scanner;

public class Main {

    public static void main (String[] args){





        //Création des données de base pour l'application (création d'une banque, d'agences, d'un client et de comptes)
        //Création de la banque
        Bank bankDuFlooz = new Bank();

        //Création des agences
        Agency agenceLille = new Agency("lille");
        Agency agenceParis = new Agency("paris");
        Agency agenceLyon = new Agency("lyon");
        Agency agenceMarseille = new Agency("marseille");
        //Ajout des agences à la banque
        bankDuFlooz.addAgency(agenceLille);
        bankDuFlooz.addAgency(agenceParis);
        bankDuFlooz.addAgency(agenceLyon);
        bankDuFlooz.addAgency(agenceMarseille);

        //verification que les agences sont bien ajoutées a la bank
        //System.out.println(bankDuFlooz.toString());

        //Creation d'un client
        Client client1 = new Client("Doe", "John", Status.CLIENT, "johndoe", "johndoe");
        client1.setId(bankDuFlooz.getNombreClients()+1);
        //Ajout du client à l'agence de Lille
        agenceLille.addClient(client1, bankDuFlooz);

        //Verification que le client est bien créé
        //System.out.println(client1.toString());
        //Verification que le client est bien ajouté à l'agence de lille
        //System.out.println(agenceLille);

        //Creation d'un compte courant
        Account currentAccount1 = new CurrentAccount(1250.00, client1.getId());
        //Verification de la creation d'un compte
        //System.out.println(currentAccount1.toString());
        //Ajout du compte au client et a l'agence
        agenceLille.addAccount(currentAccount1, bankDuFlooz, agenceLille,client1);
        //System.out.println(agenceLille);

        //Creation d'un compte payant
        Account paidAccount1 = new PaidAccount(2000.00, client1.getId());
        //Verification de la creation d'un compte
        //System.out.println(currentAccount1.toString());
        //Ajout du compte au client et a l'agence
        agenceLille.addAccount(paidAccount1, bankDuFlooz, agenceLille,client1);
        //System.out.println(agenceLille);

        //Creation d'un compte epargne
        Account savingAccount1 = new SavingAccount(10000.00, client1.getId());
        //Verification de la creation d'un compte
        //System.out.println(currentAccount1.toString());
        //Ajout du compte au client et a l'agence
        agenceLille.addAccount(savingAccount1, bankDuFlooz, agenceLille,client1);
        System.out.println(agenceLille);
        System.out.println(bankDuFlooz);

        //////////////////////////////////////////////////////////////////////////////////////////
        //APPLICATION

        System.out.println("********************************");
        System.out.println("*                              *");
        System.out.println("* BIENVENUE A LA BANK DU FLOOZ *");
        System.out.println("*                              *");
        System.out.println("********************************");

        //Login du client
        Client clientFound = bankDuFlooz.verifLogin();

        //Choix du compte
        Account accountFound = bankDuFlooz.displayAccountChoice(clientFound);

        //affichage du compte
        String accountType = bankDuFlooz.checkAccountType(accountFound);
        bankDuFlooz.displayAccount(accountType, accountFound);
        //choix de l'opération à effectuer
        int operationSelected = bankDuFlooz.chooseOperation(accountFound);
        //effectuer l'opération demandée
        bankDuFlooz.makeOperation(operationSelected, accountFound);






    }
}
