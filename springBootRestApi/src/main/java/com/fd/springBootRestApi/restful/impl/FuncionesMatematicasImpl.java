package com.fd.springBootRestApi.restful.impl;

import com.fd.springBootRestApi.restful.servcie.FuncionesMatematicas;
import org.springframework.stereotype.Service;

/**
 * @author Muguruza
 */
@Service(value = "FuncionesMatematicasImpl")
public class FuncionesMatematicasImpl implements FuncionesMatematicas {

    @Override
    public boolean isPrimeNumber(long number) {

        if (number < 2) return false;                                        /* Debe ser mayor a 1. */
        if (number == 2 || number == 3) return true;                            /* 2 & 3 son números primos. */
        if (number % 2 == 0 || number % 3 == 0)
            return false;                    /* Si se logra dividir entre 2 o 3 y el residuo es = 0, osea una división exacta. */
        long sqrtN = (long) Math.sqrt(number) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (number % (i - 1) == 0 || number % (i + 1) == 0) return false;
        }
        return true;
    }

}
