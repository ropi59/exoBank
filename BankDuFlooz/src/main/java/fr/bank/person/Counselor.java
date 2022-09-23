package fr.bank.person;

import fr.bank.bank.Account;
import fr.bank.bank.Type;

import java.util.List;

public class Counselor extends Client{

    public Counselor(String name, String firstname, Status status, String login, String password) {
        super(name, firstname, status, login, password);
        super.setStatus(Status.COUNSELOR);
    }

    //Methods
    public void removeMoney(Account account, int sum){

    }

    public void addMoney(Account account, int sum){

    }

    public void getSold(Account account){

    }

    public void openAccount(Client client, Type type, double sold){

    }

    public void closeAccount(int id){

    }

    public void createClient(String name, String firstname, String login, String password){

    }

    public void updateClient(int id, String name, String firstname, String login, String password){

    }

    public void deleteClient(int id){

    }
}
