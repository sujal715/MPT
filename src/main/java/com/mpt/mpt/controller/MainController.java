package com.mpt.mpt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/")
    public String home() {
        return "Booking System is running! Database is configured.";
    }
    
    @GetMapping("/db-test")
    public Map<String, Object> testDatabase() {
        Map<String, Object> result = new HashMap<>();
        
        try {
            // Test basic connectivity
            Integer test = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            result.put("connection", "SUCCESS");
            result.put("test", test);
            
            // Test if tables exist
            List<Map<String, Object>> tables = jdbcTemplate.queryForList(
                "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC'"
            );
            result.put("tables", tables);
            
            // Test data in tables
            for (Map<String, Object> table : tables) {
                String tableName = (String) table.get("TABLE_NAME");
                try {
                    Integer count = jdbcTemplate.queryForObject(
                        "SELECT COUNT(*) FROM " + tableName, Integer.class);
                    result.put(tableName + "_count", count);
                } catch (Exception e) {
                    result.put(tableName + "_error", e.getMessage());
                }
            }
            
            result.put("status", "SUCCESS");
            
        } catch (Exception e) {
            result.put("status", "ERROR");
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    @GetMapping("/h2-console")
    public String h2Console() {
        return "H2 Console available at: <a href='/h2-console'>http://localhost:8080/h2-console</a><br>" +
               "JDBC URL: jdbc:h2:mem:testdb<br>" +
               "Username: sa<br>" +
               "Password: password";
    }
} 