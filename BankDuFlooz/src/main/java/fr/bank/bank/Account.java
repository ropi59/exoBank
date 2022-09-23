package fr.bank.bank;

public abstract class Account {

    int id;
    Type type;
    boolean removable = false;

    //Getters Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isRemovable() {
        return removable;
    }

    public void setRemovable(boolean removable) {
        this.removable = removable;
    }

    //Methods
    void createAccount(String type, double sold){};
    void consultAccount(int id){};
    void updateAccount(int id){};
    void deleteAccount(int id){};

}
