package eu.lukoszek.insurance.owner;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerApi {
    private OwnerService ownerService;

    public OwnerApi(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getOwners() {
        return ownerService.getOwners();
    }

    @PostMapping
    public void addOwner(@RequestBody @Valid Owner owner) {
        ownerService.addOwner(owner);
    }
}

