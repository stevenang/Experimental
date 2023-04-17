package tw.idv.stevenang.experimental.api.v1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String userId;

    private String birthday;

    private String address_01;

    private String address_02;

    private String city;

    private String state;

    private String zipCode;

    private String country;

    private String phone;

    private String email;
}
