package eu.lukoszek.insurance.car;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarApi {
    private CarService carService;
    private List<Car> carList;

    public CarApi(CarService carservice, List<Car> carList) {
        this.carService = carservice;
        this.carList = Arrays.asList(new Car("126p", "Fiat", "VF123B", "WB123"),
                new Car("3", "BMW", "VF121434", "WZ123231"));
    }

    @PostMapping
    public String addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping
    public List<Car> getCars() {
        return carList;
    }
}

