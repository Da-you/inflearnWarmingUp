package com.group.libearyapp.homework4;

import com.group.libearyapp.homework4.FruitDto.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.group.libearyapp.homework4.FruitDto.*;

@RestController
public class FruitController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void input(@RequestBody Input request) {
        String sql = "INSERT INTO fruit(name, price, warehousing_date, is_sold) VALUES(?,?,?,false)";
        jdbcTemplate.update(sql, request.getName(), request.getPrice(), request.getWarehousingDate());
    }

    @PutMapping("/api/v1/fruit")
    public HttpStatus salse(@RequestBody Salse request) {
        String readSql = "Select * From fruit where id =?";
        boolean existFruit = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (existFruit) throw new RuntimeException("없는 과일");
        String soldSql = "UPDATE fruit SET is_sold = TRUE where id = ?";
        jdbcTemplate.update(soldSql, request.getId());
        return HttpStatus.OK;
    }

    @GetMapping("/api/v1/fruit/stat")
    public Response stat(@RequestParam(name = "name") String name) {
        String sql = "SELECT is_sold, SUM(price) as SUM from fruit WHERE name = ? GROUP BY is_sold";

        Map<Boolean, Long> resultmap = new HashMap<>();
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            boolean isSold = rs.getBoolean("is_sold");
            Long price = rs.getLong("SUM");
            resultmap.put(isSold, price);
            return null;
        }, name);
        return new Response(resultmap.get(true), resultmap.get(false));
    }
}
