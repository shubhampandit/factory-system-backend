package com.springProject.factorysystem.entity.referenceEntities.master;

import com.springProject.factorysystem.entity.referenceEntities.AddressDetails;
import com.springProject.factorysystem.entity.referenceEntities.BankDetails;
import com.springProject.factorysystem.entity.referenceEntities.ContactDetails;
import com.springProject.factorysystem.entity.referenceEntities.TaxDetails;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
public class CompanyMaster {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;

    @OneToOne(targetEntity = AddressDetails.class, cascade = CascadeType.ALL)
    private AddressDetails addressDetails;

    @OneToOne(targetEntity = ContactDetails.class, cascade = CascadeType.ALL)
    private ContactDetails contactDetails;

    @OneToOne(targetEntity = BankDetails.class,cascade = CascadeType.ALL)
    private BankDetails bankDetails;

    @OneToOne(targetEntity = AddressDetails.class, cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private AddressDetails destination;

    @OneToOne(targetEntity = TaxDetails.class, cascade = CascadeType.ALL)
    private TaxDetails taxDetails;

    private String additionalInformation;

    public CompanyMaster() {
    }

    public CompanyMaster(String name, AddressDetails addressDetails, ContactDetails contactDetails, BankDetails bankDetails, AddressDetails destination, TaxDetails taxDetails, String additionalInformation) {
        this.name = name;
        this.addressDetails = addressDetails;
        this.contactDetails = contactDetails;
        this.bankDetails = bankDetails;
        this.destination = destination;
        this.taxDetails = taxDetails;
        this.additionalInformation = additionalInformation;
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

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public AddressDetails getDestination() {
        return destination;
    }

    public void setDestination(AddressDetails destination) {
        this.destination = destination;
    }

    public TaxDetails getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
