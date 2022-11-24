package eu.lukoszek.insurance.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CarService {
    private List<Car> carList = new ArrayList<>();
    private final Validator validator;

    @Autowired
    public CarService(Validator validator) {
        this.validator = validator;
    }

    public String addCar(Car car) {
        Set<ConstraintViolation<Car>> errors = validator.validate(car);
        if (!errors.isEmpty()) {
            String message = ("Samochód nie może być dodany, lista błędów:");
            for (ConstraintViolation<Car> err : errors) {
                message = message.concat(String.format(">>> %s %s (%s)\n",
                        err.getPropertyPath(),
                        err.getMessage(),
                        err.getInvalidValue())
                    );}
            return message;
        } else {
            carList.add(car);
            return "Właściciel został dodany";
        }
    }


}
