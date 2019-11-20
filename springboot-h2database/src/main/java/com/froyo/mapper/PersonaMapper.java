package com.froyo.mapper;

import com.froyo.model.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<Persona> {
    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Persona(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));
    }
}
