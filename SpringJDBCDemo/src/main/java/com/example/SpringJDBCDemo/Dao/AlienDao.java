package com.example.SpringJDBCDemo.Dao;

import com.example.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class AlienDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien){

        String sql = "insert into alien (id, name, tech) values (?,?,?)";

        int row = jdbcTemplate.update(sql,alien.getId(),alien.getName(),alien.getTech());
        System.out.println(row + " rows updated");
    }

    public List<Alien> read(){

        RowMapper<Alien> rowMapper = (rs, rowNum) -> {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));

                return alien;
        };

        String sql = "Select * from alien";

        List<Alien> alienArrayList = jdbcTemplate.query(sql,rowMapper);

        return alienArrayList;
    }
}
