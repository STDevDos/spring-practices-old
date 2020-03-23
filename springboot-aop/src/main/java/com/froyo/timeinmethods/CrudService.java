package com.froyo.timeinmethods;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class CrudService {

    public void create() {
        System.out.println("crear dato...");
    }

    public void read() {
        System.out.println("leer dato...");
    }

    public void update() {
        System.out.println("actualizar dato...");
    }

    public void delete() {
        System.out.println("eliminar dato...");
    }

    public void select() throws SQLException {
        throw new SQLException("ERROR: SQLException -> send email");
    }

}
