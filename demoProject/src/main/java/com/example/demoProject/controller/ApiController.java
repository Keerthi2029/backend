package com.example.demoProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getOperationCode() {
        Map<String, Integer> response = new HashMap<String, Integer>();
        response.put("operation_code", 1);
        return ResponseEntity.ok(response);
    }
    

    @PostMapping
    public ResponseEntity<Map<String, Object>> processData(@RequestBody Map<String, List<String>> request) {
        List<String> data = request.get("data");
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> highestLA= new ArrayList<>();
        
        String highest = "a";
        highestLA.add(highest);

        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]") && item.charAt(0) > highest.charAt(0)) {
                	String tmp= String.valueOf(highest);
                    highest = tmp;
                }
            }
        }

        if (!highestLA.contains(String.valueOf(highest)) && highest != "a") {
            highestLA.add(String.valueOf(highest));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("is_success", true);
        response.put("user_id", "john_doe_17091999");  // Replace with actual values
        response.put("email", "john@xyz.com");
        response.put("roll_number", "ABCD123"); 
        response.put("numbers", numbers);
        response.put("alphabets", alphabets);
        response.put("highest_lowercase_alphabet", highestLA);

        return ResponseEntity.ok(response);
    }

    
}
