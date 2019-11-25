package com.froyo.simpleRestClient;

import lombok.extern.log4j.Log4j2;
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
@Log4j2
@SpringBootApplication
public class SimpleRestClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SimpleRestClientApplication.class);
        //app.setWebEnvironment(false); //Establece si ésta aplicación se está ejecutando en un enterno web
        app.setWebApplicationType(WebApplicationType.NONE);
        args[0] = "Froy";
        app.run(args);
    }

    @Override
    public void run(String... argsRun) {

        /*
          Una forma de obtener el response de otro proyecto es utilizando RestTemplate.
          El ejemplo se esta corriendo una aplicación en el puerto 8080 y ese proyecto
          tiene un Request @GetMapping("retrieveCustomer")
          :: Método getForObject::

          Parámetro 1 : el url del request.
          Parámetro 2 : el tipo de objeto que regresará.

         */

        RestTemplate plantilla = new RestTemplate();
        String resultado = plantilla.getForObject("http://localhost:8080/retrieveCustomer", String.class);

        log.info("Parámetro: " + argsRun[0]);
        log.info(resultado);
    }
}
