package modul;

public class Customer {
    private String id;
    private String name;
    private String address;
    private String t_number;
    private String email;

    public Customer(String id) {
        this.id = id;
    }

    public Customer(String id, String name, String address, String t_number, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.t_number = t_number;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getT_number() {
        return t_number;
    }

    public void setT_number(String t_number) {
        this.t_number = t_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
