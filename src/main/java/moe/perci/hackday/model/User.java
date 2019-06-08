package moe.perci.hackday.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    private int id;

    private String name;
    private String province;
    private String city;
    private String county;
    private String address;
    private int phone;
    private String username;
    private String password;
    private String school;
    private String educationBg;
    private String idNumber;
    private String nameOfContactPerson;
    private int status;
    private int role;
    private String description;
    private String schoolLevel;
}
