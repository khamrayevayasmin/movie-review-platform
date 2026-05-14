package com.movie_review_platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/util")
public class KhamrayevaYasminUtilController {

    @GetMapping("/factorial/{n}")
    public ResponseEntity<Long> factorial(@PathVariable int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return ResponseEntity.ok(result);
    }

    @GetMapping("/fibonacci/{n}")
    public ResponseEntity<List<Long>> fibonacci(@PathVariable int n) {
        List<Long> result = new ArrayList<>();
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            result.add(a);
            long temp = a + b;
            a = b;
            b = temp;
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/isPrime/{n}")
    public ResponseEntity<Boolean> isPrime(@PathVariable int n) {
        if (n < 2) return ResponseEntity.ok(false);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @GetMapping("/reverse")
    public ResponseEntity<String> reverse(@RequestParam String text) {
        return ResponseEntity.ok(new StringBuilder(text).reverse().toString());
    }

    @GetMapping("/isPalindrome")
    public ResponseEntity<Boolean> isPalindrome(@RequestParam String text) {
        String cleaned = text.toLowerCase().replaceAll("\\s+", "");
        return ResponseEntity.ok(cleaned.equals(new StringBuilder(cleaned).reverse().toString()));
    }

    @GetMapping("/datetime")
    public ResponseEntity<String> getDateTime() {
        return ResponseEntity.ok(LocalDateTime.now().toString());
    }

    @GetMapping("/bmi")
    public ResponseEntity<Double> calculateBmi(
            @RequestParam double weight,
            @RequestParam double height) {
        double bmi = weight / (height * height);
        return ResponseEntity.ok(Math.round(bmi * 100.0) / 100.0);
    }

    @GetMapping("/celsiusToFahrenheit")
    public ResponseEntity<Double> celsiusToFahrenheit(@RequestParam double celsius) {
        return ResponseEntity.ok(celsius * 9 / 5 + 32);
    }

    @GetMapping("/vowelCount")
    public ResponseEntity<Long> countVowels(@RequestParam String text) {
        long count = text.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/isLeapYear/{year}")
    public ResponseEntity<Boolean> isLeapYear(@PathVariable int year) {
        boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return ResponseEntity.ok(leap);
    }
}