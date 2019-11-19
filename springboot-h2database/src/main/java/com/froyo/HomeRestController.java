package com.froyo;

import com.froyo.inout.PersonaRequest;
import com.froyo.inout.PersonaResponse;
import com.froyo.messages.MessagePair;
import com.froyo.messages.MessagePairTypeCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@RestController
public class HomeRestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*
     * @PostConstruct Se ejecuta después de que se complete la inyección de dependencia.
     */
    @PostConstruct
    public void creatTablaPersona() {
        jdbcTemplate.execute("create table persona(id SERIAL,name VARCHAR(255),age VARCHAR(255) )");
    }

    @PostMapping(value = "/persona")
    public ResponseEntity altaPersona(@Valid @RequestBody PersonaRequest personaRequest, BindingResult bindingResult) {

        PersonaResponse personaResponse = new PersonaResponse();

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                personaResponse.addMessagePair(new MessagePair(objectError.getCode(), objectError.getDefaultMessage(), MessagePairTypeCode.ERROR));
            }
            return new ResponseEntity<>(personaResponse, HttpStatus.CONFLICT);
        }

        List<Object> params = List.of(personaRequest.getId(), personaRequest.getName(), personaRequest.getAge());
        StringBuilder sbQuery = new StringBuilder()
                .append("insert into persona(id,name,age) VALUES ")
                .append("(?,?,?)");


        jdbcTemplate.update(sbQuery.toString(), params);
        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        return new ResponseEntity<>(personaResponse, HttpStatus.OK);

    }

    @GetMapping("/persona/{idPersona}")
    public ResponseEntity obtenerPersonaPorId(@PathVariable("idPersona") Long idPersona) {

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        //jdbcTemplate.queryForObject()

        return new ResponseEntity<>(personaResponse, HttpStatus.OK);
    }

    @PatchMapping("/persona/{idPersona}/clientes/{idCliente}")
    public ResponseEntity editarDatosClienteEmpresa(@Valid @RequestBody PersonaRequest personaRequest, //
                                                    @PathVariable("idPersona") int idEmpresa, //
                                                    @PathVariable("idCliente") int idCliente, //
                                                    BindingResult bindingResult) { //

        PersonaResponse personaResponse = new PersonaResponse();

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                personaResponse.addMessagePair(new MessagePair(objectError.getCode(), objectError.getDefaultMessage(), MessagePairTypeCode.ERROR));
            }
            return new ResponseEntity<>(personaResponse, HttpStatus.CONFLICT);
        }


        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        //jdbcTemplate.queryForObject()

        return new ResponseEntity<>(personaResponse, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBazz(
            @PathVariable String id,
            @RequestParam("name") String name) {
        return new ResponseEntity<>(new Bazz(id, name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBazz(@PathVariable String id) {
        return new ResponseEntity<>(new Bazz(id), HttpStatus.OK);
    }

}
