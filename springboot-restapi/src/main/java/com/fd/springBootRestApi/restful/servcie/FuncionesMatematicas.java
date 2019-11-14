package com.fd.springBootRestApi.restful.servcie;

/**
 * Interfaz en donde se definen funciones que tiene que ver con temas de matematicas.
 *
 * @author Muguruza
 */
public interface FuncionesMatematicas {

    /**
     * true si el valor pasado por parámetro es un número primo.
     * false si el valor pasado por parámetro NO es un número promo.
     * <p>
     * Un número primo es un número natural <b>mayor que 1</b> que tiene únicamente <b>dos divisores</b> distintos <b>él mismo y el 1</b>.
     *
     * @param numero
     * @return
     * @see https://stackoverflow.com/questions/2385909/what-would-be-the-fastest-method-to-test-for-primality-in-java
     */
    boolean isPrimeNumber(long number);

}
