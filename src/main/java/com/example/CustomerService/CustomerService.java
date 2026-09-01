package com.example.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerdb;
    public String savetocustomerdb(Requestdto request){
        CustomerEntity customer =new CustomerEntity();
        customer.setCustomer_id(request.getCustomer_id());
        customer.setCustomer_name(request.getCustomer_name());
        customer.setCustomer_email(request.getEmail());
        customer.setCreated_at(request.getCreatedDate());
        System.out.println("Customer Controller:");
        System.out.println("ID: " + request.getCustomer_id());
        System.out.println("NAME: " + request.getCustomer_name());
        System.out.println("EMAIL: " + request.getEmail());
        System.out.println("DATE: " + request.getCreatedDate());
        customerdb.save(customer);
        return "customer registered";
    }

    public Optional<CustomerEntity> searchbyId(String id) {
        return customerdb.findById(id);
    }
    public String updateCustomer(String id, UpdateCustomerDto request) {

        Optional<CustomerEntity> optionalCustomer =
                customerdb.findById(id);

        if (optionalCustomer.isEmpty()) {
            return "Customer not found";
        }

        CustomerEntity customer = optionalCustomer.get();

        customer.setCustomer_name(request.getCustomer_name());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setPincode(request.getPincode());

        customerdb.save(customer);

        return "Customer updated successfully";
    }
    public String deleteCustomer(String id) {

        if (!customerdb.existsById(id)) {
            return "Customer not found";
        }

        customerdb.deleteById(id);

        return "Customer deleted successfully";
    }
}