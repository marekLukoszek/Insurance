package eu.lukoszek.insurance.owner;

import eu.lukoszek.insurance.Address;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("Personal data of Owner")
public class Owner {
    @ApiModelProperty("Unique name of owner")
    @NotNull
    @Size(min = 3)
    private String surname;
    @NotNull
    @Size(min = 2)
    private String name;
    @NotNull
    private Address address;
    @NotNull
    private OwnerIdType ownerIdType;
    @PESEL
    private long pesel;
    @Size(min=9)
    private int regon;

    public Owner(String surname, String name, Address address, OwnerIdType ownerIdType, long pesel, int regon) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.ownerIdType = ownerIdType;
        this.pesel = pesel;
        this.regon = regon;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }
}

