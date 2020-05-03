package com.froyo;

import com.froyo.inout.PersonaRequest;
import com.froyo.inout.PersonaResponse;
import com.froyo.mapper.PersonaMapper;
import com.froyo.messages.MessagePair;
import com.froyo.messages.MessagePairTypeCode;
import com.froyo.model.Persona;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persona")
@AllArgsConstructor
public class HomeRestController {

    private final JdbcTemplate jdbcTemplate;

    /*
     * @PostConstruct Se ejecuta después de que se complete la inyección de dependencia.
     */
    @PostConstruct
    public void creatTablaPersona() {
        jdbcTemplate.execute("create table persona(id SERIAL,name varchar(255),age int )");
    }

    @PostMapping(value = "/altaPersona")
    public PersonaResponse altaPersona(@Valid @RequestBody PersonaRequest personaRequest, BindingResult bindingResult) {

        PersonaResponse personaResponse = new PersonaResponse();

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                personaResponse.addMessagePair(new MessagePair(objectError.getCode(), objectError.getDefaultMessage(), MessagePairTypeCode.ERROR));
            }
            return personaResponse;
        }


        String sbQuery = "INSERT INTO persona(name,age) VALUES " +
                "(?,?)";
        jdbcTemplate.update(sbQuery, personaRequest.getName(), personaRequest.getAge());
        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        return personaResponse;

    }

    @GetMapping("/obtenerPersonaPorId/{idPersona}")
    public PersonaResponse obtenerPersonaPorId(@PathVariable("idPersona") Long idPersona) {

        String query = "SELECT id,name,age FROM persona WHERE id = ? ";

        List<Persona> personas = jdbcTemplate.query(query, List.of(idPersona).toArray(), new PersonaMapper());

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setPersonas(personas);

        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        return personaResponse;
    }

    @PatchMapping("/editPersonaName")
    public PersonaResponse editPersonaName(@RequestBody PersonaRequest personaRequest, BindingResult bindingResult) {


        String sbQuery = "UPDATE persona SET name = ? WHERE id = ? ";
        jdbcTemplate.update(sbQuery, personaRequest.getName(), personaRequest.getId());

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        return personaResponse;

    }

    @PutMapping(value = "/editPersona")
    public PersonaResponse editPersona(@RequestBody PersonaRequest personaRequest, BindingResult bindingResult) {


        String sbQuery = "UPDATE persona SET name = ?, age = ? WHERE id = ? ";
        jdbcTemplate.update(sbQuery, personaRequest.getName(), personaRequest.getAge(), personaRequest.getId());

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        return personaResponse;

    }


    @DeleteMapping(value = "/deletePersona")
    public PersonaResponse deletePersona(@RequestBody PersonaRequest personaRequest, BindingResult bindingResult) {

        String query = "DELETE FROM persona WHERE id = ? ";

        jdbcTemplate.update(query, personaRequest.getId());

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.addMessagePair(new MessagePair(null, "OK", MessagePairTypeCode.SUCCESS));

        return personaResponse;
    }

}
