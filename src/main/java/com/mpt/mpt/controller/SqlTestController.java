package com.mpt.mpt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sql")
public class SqlTestController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/test")
    public Map<String, Object> testSql() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // Test basic database connectivity
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            response.put("basicTest", "SUCCESS");
            response.put("result", result);
            
            // Test if our tables exist and have data
            List<Map<String, Object>> tables = jdbcTemplate.queryForList(
                "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC'"
            );
            response.put("tables", tables);
            
            // Test each table
            for (Map<String, Object> table : tables) {
                String tableName = (String) table.get("TABLE_NAME");
                try {
                    Integer count = jdbcTemplate.queryForObject(
                        "SELECT COUNT(*) FROM " + tableName, Integer.class);
                    response.put(tableName + "_count", count);
                } catch (Exception e) {
                    response.put(tableName + "_error", e.getMessage());
                }
            }
            
            response.put("status", "SUCCESS");
            
        } catch (Exception e) {
            response.put("status", "ERROR");
            response.put("message", e.getMessage());
            response.put("errorType", e.getClass().getSimpleName());
        }
        
        return response;
    }
    
    @GetMapping("/schema")
    public List<Map<String, Object>> getSchema() {
        return jdbcTemplate.queryForList(
            "SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, IS_NULLABLE " +
            "FROM INFORMATION_SCHEMA.COLUMNS " +
            "WHERE TABLE_SCHEMA = 'PUBLIC' " +
            "ORDER BY TABLE_NAME, ORDINAL_POSITION"
        );
    }
} 