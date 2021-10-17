package com.grupo.estudos.calculator.controllers;

import com.grupo.estudos.calculator.dto.RequestCalculation;
import com.grupo.estudos.calculator.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    private CalculationService calculationService; // ou instancia o obj ou usa o autoweired, solucao ideal pois ele faz toda essa parte

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public ModelAndView calculation(RequestCalculation request){

        ModelAndView modelAndView = new ModelAndView("home");

        float result = 0;

        switch(request.getOperator()){
            case "+" :
                result = calculationService.add(request.getFirstOperand(), request.getSecondOperand());
                break;
            case "-":
                result = calculationService.subtract(request.getFirstOperand(), request.getSecondOperand());
                break;
            case "*" :
                result = calculationService.multiply(request.getFirstOperand(), request.getSecondOperand());
                break;
            case "/" :
                result = calculationService.divide(request.getFirstOperand(), request.getSecondOperand());
                break;
        }

        modelAndView.addObject("result",result );

         return modelAndView;

    }


}
