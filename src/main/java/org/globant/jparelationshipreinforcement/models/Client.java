package org.globant.jparelationshipreinforcement.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    // @JoinColumn(name = "client_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinTable(
            name="clients_addresses_details", 
            joinColumns =  @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name="address_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"address_id"}))
    //@Fetch(FetchType.EAGER)
    private List<Adress> addresses;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private List<Invoice> invoices;

    // Alternative method to add invoices

    // public Client addInvoice(Invoice invoice){
    //     invoices.add(invoice);
    //     invoice.setClient(this);
    //     return this;
    // }

    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
        invoice.setClient(this);
    }

    public Client() {
        addresses = new ArrayList<>();
        invoices = new ArrayList<>();
    }

    public Client(Long id, String name, String lastname, List<Adress> addresses) {
        this();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.addresses = addresses;
    }

    public Client(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() { 
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Adress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Adress> addresses) {
        this.addresses = addresses;
    }

    
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", lastname=" + lastname + ", addresses=" + addresses.toString()
                + ", invoices=" + invoices.toString() + "]";
    } 
}