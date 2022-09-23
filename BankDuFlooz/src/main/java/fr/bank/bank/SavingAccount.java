package fr.bank.bank;

public class SavingAccount extends Account{

    //Attributes
    Type type = Type.SAVING_ACCOUNT;
    int id;
    double sold;
    boolean removable = false;
    double interestRate = 1.2;
    int clientId;

    //Contructor
    public SavingAccount(double sold, int clientId) {
        this.sold = sold;
        this.clientId = clientId;
    }

    //Getters Setters
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public boolean isRemovable() {
        return removable;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    //Methods
    @Override
    public void createAccount(String type, double sold) {}

    @Override
    public void consultAccount(int id){}

    @Override
    public void updateAccount(int id){}

    @Override
    public void deleteAccount(int id) {

    }

    //ToString
    @Override
    public String toString() {
        return "SavingAccount{" +
                "type=" + type +
                ", id=" + id +
                ", sold=" + sold +
                ", removable=" + removable +
                ", interestRate=" + interestRate +
                ", clientId=" + clientId +
                '}';
    }
}
