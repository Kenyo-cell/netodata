package org.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {
    private final String findSqlQuery;
    private final String findSqlQueryFileSource = "two_find.sql";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        findSqlQuery = read(findSqlQueryFileSource);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return jdbcTemplate.query(
                findSqlQuery,
                Map.of("name", name),
                (rs, rowIndex) -> rs.getString("product_name")
        );
    }
}
