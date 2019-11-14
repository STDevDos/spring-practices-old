package com.fd.springBootRestApi.restful.controller;

import com.fd.springBootRestApi.restful.servcie.FuncionesMatematicas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * RestController para funciones matemáticas.
 *
 * @author Muguruza
 */
@RestController
public class FuncionesMatematicasWebController {

    @Autowired
    @Qualifier(value = "FuncionesMatematicasImpl")
    private FuncionesMatematicas funcionesMatematicas;

    /**
     * Enviando parámetro desde el path.
     *
     * @param number
     * @return
     */
    @RequestMapping(value = "/api/isPrimeNumber/{number}", method = RequestMethod.GET)
    @ResponseBody
    public boolean isPrimeNumber(@PathVariable("number") long number) {
        return funcionesMatematicas.isPrimeNumber(number);
    }


}
