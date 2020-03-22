package com.froyo.repository.impl;

import com.froyo.model.entity.AnimalsEntity;
import com.froyo.repository.AnimalsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Log
@AllArgsConstructor
@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<AnimalsEntity> find(Integer id) {

        try{
            String sql = "SELECT * FROM animals where id = ?";
            Object[] object = new Object[] {
                    id
            };
            BeanPropertyRowMapper beanPropertyRowMapper = new BeanPropertyRowMapper(AnimalsEntity.class);

            AnimalsEntity animalsEntity = (AnimalsEntity) jdbcTemplate.queryForObject(sql,object, beanPropertyRowMapper);

            return Optional.of(animalsEntity);

        }catch(Exception ex){
            log.log(Level.WARNING,"ERROR @@@ find() ",ex);
            return Optional.empty();
        }

    }

    @Override
    public void addAnimal(AnimalsEntity animalsEntity) {

        try{

            String sql = "INSERT INTO animals (id,name,origen,depredador,dato_curioso) VALUES (?, ?, ?, ?,?)";
            Object[] object = new Object[] {
                    animalsEntity.getId(),
                    animalsEntity.getName(),
                    animalsEntity.getOrigen(),
                    animalsEntity.getDepredador(),
                    animalsEntity.getDato_curioso()
            };

            jdbcTemplate.update(sql,object);
            log.info("SUCCESS: Animal Saved!!");

        }catch(Exception ex){
            log.log(Level.WARNING,"ERROR @@@ addAnimal() ",ex);
        }

    }

    @Override
    public void editAnimal(AnimalsEntity animalsEntity) {

        try{
            String sql = "UPDATE animals SET name = ? , origen = ? , depredador = ?, dato_curioso = ? WHERE id = ? ";
            Object[] object = new Object[] {
                    animalsEntity.getName(),
                    animalsEntity.getOrigen(),
                    animalsEntity.getDepredador(),
                    animalsEntity.getDato_curioso(),
                    animalsEntity.getId()
            };

            jdbcTemplate.update(sql,object);
            log.info("SUCCESS: Animal Updated!!");

        }catch(Exception ex){
            log.log(Level.WARNING,"ERROR @@@ editAnimal() ",ex);
        }


    }

    @Override
    public void deleteAnimal(int id) {

        try{
            String sql = "DELETE from animals WHERE id = ? ";
            jdbcTemplate.update(sql, id);

            log.info("Animal Deleted!!");

        }catch(Exception ex){
            log.log(Level.WARNING,"ERROR @@@ deleteAnimal() ",ex);
        }


    }

    @Override
    public List<AnimalsEntity> findAll() {

        try{
            String sql = "SELECT * FROM animals ";
            BeanPropertyRowMapper beanPropertyRowMapper = new BeanPropertyRowMapper(AnimalsEntity.class);

            return jdbcTemplate.query(sql,beanPropertyRowMapper);

        }catch(Exception ex){
            log.log(Level.WARNING,"ERROR @@@ findAll() ",ex);
            return null;
        }
    }

}
