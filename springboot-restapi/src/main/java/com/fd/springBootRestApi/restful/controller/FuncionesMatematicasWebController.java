package com.fd.springBootRestApi.restful.controller;

import com.fd.springBootRestApi.restful.servcie.FuncionesMatematicas;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * RestController para funciones matemáticas.
 *
 * @author Muguruza
 */
@AllArgsConstructor
@RestController
public class FuncionesMatematicasWebController {

    @Qualifier(value = "FuncionesMatematicasImpl")
    private final FuncionesMatematicas funcionesMatematicas;

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
