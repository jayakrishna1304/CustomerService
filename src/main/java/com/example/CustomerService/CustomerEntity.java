package com.example.CustomerService;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class CustomerEntity {
    @Id
    private int customer_id;
    private String customer_name;
    private String customer_email;
    private String customer_phone_no;
    private String address;
    private String city;
    private String Phone;
    private String state;
    private String country;
    private String pincode;
    private Date created_at;
    private Date updated_at;
}
