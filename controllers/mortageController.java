package kz.mortgage.percent.controllers;

import kz.mortgage.percent.entity.Mortage;
import kz.mortgage.percent.repositories.MortageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/mortgages")
public class mortageController {
    @Autowired
    private MortageRepository mortageRepository;
    @PostMapping("/calculate")
    public double calculateMortage (@RequestBody Mortage mortage){
        double sum = mortage.getSum();
        double interestRate = mortage.getInterestRate() / 100 / 12;
        int month = mortage.getMonth();

        double monthlyPayment = sum * (interestRate * Math.pow(1 + interestRate,month)) / (Math.pow(1 + interestRate, month)-1);
        mortageRepository.save(mortage);
        return monthlyPayment;
    }

}
