package fr.bank.bank;

public class CurrentAccount extends Account{

    //Attributes
    private Type type = Type.CURRENT_ACCOUNT;
    private int id;
    private double sold;
    private boolean removable = true;

    private int clientId;

    //Constructor
    public CurrentAccount(double sold, int clientId) {
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
    public void consultAccount(int id) {}

    @Override
    public void updateAccount(int id){}

    @Override
    public void deleteAccount(int id) {

    }

    //ToString
    @Override
    public String toString() {
        return "CurrentAccount{" +
                "type=" + type +
                ", id=" + id +
                ", sold=" + sold +
                ", removable=" + removable +
                ", clientId=" + clientId +
                '}';
    }
}
