package com.fd.batch.model;

import java.io.Serializable;

/**
 * @author Froy
 */
public class Tabla2Model implements Serializable {

    private static final long serialVersionUID = 8832973341047986369L;

    private int columna1;
    private String columna2;

    public int getColumna1() {
        return columna1;
    }

    public void setColumna1(int columna1) {
        this.columna1 = columna1;
    }

    public String getColumna2() {
        return columna2;
    }

    public void setColumna2(String columna2) {
        this.columna2 = columna2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tabla2Model [columna1=");
        builder.append(columna1);
        builder.append(", columna2=");
        builder.append(columna2);
        builder.append("]");
        return builder.toString();
    }


}
