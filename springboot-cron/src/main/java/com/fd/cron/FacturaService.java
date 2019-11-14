package com.fd.cron;

/**
 * @author Froy
 */
public interface FacturaService {

    /**
     * Simple método para enviar balance por correo electrónico.
     * El valor de las carteras se obtendrá de forma manual.
     */
    public void sendBalance();
}
