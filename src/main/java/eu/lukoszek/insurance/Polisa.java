package eu.lukoszek.insurance;

import java.time.LocalDate;

public class Polisa {
    private String idNumber;
    private LocalDate startDate;
    private LocalDate endDate;

    public Polisa(String idNumber, LocalDate startDate, LocalDate endDate) {
        this.idNumber = idNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
