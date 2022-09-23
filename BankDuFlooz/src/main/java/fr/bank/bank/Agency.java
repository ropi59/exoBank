package fr.bank.bank;

import fr.bank.person.Client;

import java.util.ArrayList;
import java.util.List;

public class Agency {

    //Attributes
    String id;
    List<Client> listClients = new ArrayList<Client>();
    List<Account> listAccounts = new ArrayList<Account>();

    //Constructor


    public Agency(String id) {
        this.id = id;
    }

    //Getters Setters
    public List<Client> getListClients() {
        return listClients;
    }

    public void setListClients(List<Client> listClients) {
        this.listClients = listClients;
    }

    public List<Account> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(Account account) {
        this.listAccounts.add(account);
    }

    //Methods
    /**
     * Methode pour ajouter un client a une agence et lui attribuer un id
     * @param client le client à ajouter
     * @param bank les infos de la banque pour créer son id
     */
    public void addClient(Client client, Bank bank){
        //recuperation de l'id de la banque et incrementation pour créer un nouvel id
        int nbClient = bank.getNombreClients();
        nbClient += 1;
        client.setId(nbClient);
        //mise à jour du nombre de clients
        bank.setNombreClients(nbClient);
        this.listClients.add(client);
    }

    /**
     * Methode pour affecter un compte à un client et une agence et lui attribuer un id
     * @param account le compte a affecter
     * @param bank les infos de la banque pour créer son id
     * @param agency l'agence a laquelle affecter le compte
     * @param client le client auquel affecter le compte
     */
    public void addAccount(Account account, Bank bank, Agency agency, Client client){
        int nbAccount = bank.getNombreCompte();
        nbAccount +=1;
        account.setId(nbAccount);
        bank.setNombreCompte(bank.getNombreCompte() + 1);
        client.setListAccounts(account);
        agency.setListAccounts(account);
    }

    //ToString

    @Override
    public String toString() {
        return "Agency{" +
                "id='" + id + '\'' +
                ", listClients=" + listClients +
                ", listAccounts=" + listAccounts +
                '}';
    }
}
