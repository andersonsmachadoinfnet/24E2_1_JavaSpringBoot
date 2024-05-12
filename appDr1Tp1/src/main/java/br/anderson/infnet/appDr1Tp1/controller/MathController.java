package br.anderson.infnet.appDr1Tp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calc")
public class MathController {
    @GetMapping("/soma/{a}/{b}")
    public double soma(@PathVariable double a, @PathVariable double b) {
        return a + b;
    }

    @GetMapping("/subtracao/{a}/{b}")
    public double subtracao(@PathVariable double a, @PathVariable double b) {
        return a - b;
    }

    @GetMapping("/multiplicacao/{a}/{b}")
    public double multiplicacao(@PathVariable double a, @PathVariable double b) {
        return a * b;
    }

    @GetMapping("/divisao/{a}/{b}")
    public double divisao(@PathVariable double a, @PathVariable double b) {
        return a / b;
    }
}
