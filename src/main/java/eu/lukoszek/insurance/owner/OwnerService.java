package eu.lukoszek.insurance.owner;

import eu.lukoszek.insurance.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

import static eu.lukoszek.insurance.owner.OwnerIdType.PESEL;
import static eu.lukoszek.insurance.owner.OwnerIdType.REGON;

@Service
public class OwnerService {
    private static List<Owner> ownerList = List.of(
            new Owner("Marek", "Lukoszek", new Address("Dywizjonu 303", 175,
                    "01-470", "Warszawa"), PESEL, 76030109837L, 0),
            new Owner("Adam", "Walczak", new Address("Krucza", 50,
                    "00-130", "Warszawa"), REGON, 0L, 214699123));
    ;
    private final Validator validator;

    @Autowired
    public OwnerService(Validator validator) {
        this.validator = validator;
    }

    public String addOwner(Owner owner) {
        Set<ConstraintViolation<Owner>> errors = validator.validate(owner);
        if (!errors.isEmpty()) {
            String message = "Właściciel nie może być dodany, lista błędów:";
            for (ConstraintViolation<Owner> err : errors) {
                message = message.concat(String.format(">>> %s %s (%s)\n",
                        err.getPropertyPath(),
                        err.getMessage(),
                        err.getInvalidValue())
                );
            }
            return message;
        } else {
            ownerList.add(owner);
            return "Właściciel został dodany";
        }
    }

    public List<Owner> getOwners() {
        return ownerList;
    }
}
