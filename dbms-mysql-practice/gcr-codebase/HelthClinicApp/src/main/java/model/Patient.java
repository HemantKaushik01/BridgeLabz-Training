package model;

public class Patient {
    public int id;
    public String name;
    public String dob;
    public String phone;
    public String email;
    public String address;
    public String bloodGroup;

    public Patient(String name, String dob, String phone,
                   String email, String address, String bloodGroup) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }
}
