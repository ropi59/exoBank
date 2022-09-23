package fr.bank.person;

import fr.bank.bank.Account;

import java.util.ArrayList;
import java.util.List;

public class Client {

    //Attributes
    private int id;
    private String name;
    private String firstname;
    private Status status = Status.CLIENT;
    private String login;
    private String password;
    private List<Account> listAccounts = new ArrayList<Account>();

    //Constructor
    public Client(String name, String firstname, Status status, String login, String password) {
        this.name = name;
        this.firstname = firstname;
        this.status = status;
        this.login = login;
        this.password = password;
    }

    //Getters&setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public List<Account> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(Account account) {
        this.listAccounts.add(account);
    }

    //Methods
    public void removeMoney(Account account, int sum){

    }

    public void addMoney(Account account, int sum){

    }

    public void getSold(Account account){

    }


    //ToString
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", status=" + status +
                ", login='" + login + '\'' +
                ", Password='" + password + '\'' +
                ", listAccounts=" + listAccounts +
                '}';
    }
}
