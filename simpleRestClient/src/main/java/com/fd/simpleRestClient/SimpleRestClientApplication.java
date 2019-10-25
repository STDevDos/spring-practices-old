package com.fd.simpleRestClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 * @author Froy
 * <p>
 * CommandLineRunner: aplicación de arranque con el método run el cual se le puede enviar un arreglo de String.
 * Aplicación ejecutada en la consola.
 */
@SpringBootApplication
public class SimpleRestClientApplication implements CommandLineRunner {

    /**
     * Método principal de iniciación de la aplicación.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SimpleRestClientApplication.class);
        //app.setWebEnvironment(false); //Establece si ésta aplicación se está ejecutando en un enterno web
        app.setWebApplicationType(WebApplicationType.NONE);
        args[0] = "Froy";
        app.run(args);
    }

    @Override
    public void run(String... argsRun) throws Exception {

        /**
         * Una forma de obtener el response de otro proyecto es utilizando RestTemplate.
         * El ejemplo se esta corriendo una aplicación en el puerto 8080 y ese proyecto
         * tiene un Request @GetMapping("retrieveCustomer")
         * :: Método getForObject::
         *
         * Parámetro 1 : el url del request.
         * Parámetro 2 : el tipo de objeto que regresará.
         *
         */

        RestTemplate plantilla = new RestTemplate();
        String resultado = plantilla.getForObject("http://localhost:8080/retrieveCustomer", String.class);

        System.out.println("Parámetro: " + argsRun[0]);
        System.out.println(resultado);
    }
}
