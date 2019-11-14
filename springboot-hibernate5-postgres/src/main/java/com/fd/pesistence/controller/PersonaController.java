package com.fd.pesistence.controller;

import com.fd.pesistence.entity.Persona;
import com.fd.pesistence.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Froy
 */
@RestController
public class PersonaController {

    /**
     * Un ejemplo para insertar en la BD por medio de GET y @PathVariable
     *
     * @return
     */
    @RequestMapping(value = "/insertPersona/{nombre}/{rfc}", method = RequestMethod.GET)
    public String insertPersona(@PathVariable("nombre") String nombre, @PathVariable("rfc") String rfc) {

        // creamos el objeto a insertar.
        Persona persona = new Persona();
        persona.setNombreCompleto(nombre);
        persona.setRfc(rfc);
        persona.setFechaUpdate(new Timestamp(new Date().getTime()));

        // abrimos la session
        Session session = HibernateUtil.getSessionfactory().openSession();
        session.beginTransaction(); // Iniciamos la transacción.

        // insertamos la persona.
        session.save(persona);

        session.getTransaction().commit(); // Damos commit a la transacción para que efectue el insert.
        session.close(); // cerramos la session.

        return "La nueva persona se ha insertado correctamente: " + persona;
    }

    @RequestMapping(value = "/selectPersonaHQL", method = RequestMethod.GET)
    public String selectPersonaHQL() {

        // abrimos la session
        Session session = HibernateUtil.getSessionfactory().openSession();
        session.beginTransaction(); // Iniciamos la transacción.

        @SuppressWarnings("unchecked")
        Query<Persona> query = session.createQuery(" from Persona "); // from [nombre del POJO con CaSe]
        List<Persona> ltsPersona = query.getResultList();

        session.getTransaction().commit(); // Damos commit a la transacción para
        // que efectue el insert.
        session.close(); // cerramos la session.

        return "La nueva persona se ha insertado correctamente: " + ltsPersona;
    }

    /**
     * Haciendo un select con la interfaz criteria, se debería de usar asi pues
     * es de tipo seguro. Nota: Ejemplos con criteria ->
     * https://www.boraji.com/hibernate-5-criteria-query-example
     * <p>
     * "Annotation Proccessing": hibernate-jpamodelgen
     * <p>
     * https://immutables.github.io/apt.html
     *
     * @return
     */
    @RequestMapping(value = "/selectPersonaCriteria", method = RequestMethod.GET)
    public String selectPersonaCriteria() {

        List<Persona> personas = new ArrayList<>();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = builder.createQuery(Persona.class);

            Root<Persona> root = query.from(Persona.class);
            query.select(root).where(builder.equal(root.get("rid"), 10));
            //query.select(root).where(builder.equal(root.get(Persona_.rid), 10));

            Query<Persona> q = session.createQuery(query);
            personas = q.getResultList();

            for (Persona persona : personas) {
                System.out.println(persona.getNombreCompleto());
            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return personas.toString();
    }

    /**
     * Actualizando en Hibernate
     *
     * @return
     */
    @RequestMapping(value = "/updatePersona", method = RequestMethod.GET)
    public String updatePersona() {

        Persona persona = new Persona();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Persona> query = builder.createQuery(Persona.class);

            Root<Persona> root = query.from(Persona.class);
            query.select(root).where(builder.equal(root.get("rid"), 10));
            //query.select(root).where(builder.equal(root.get(Persona_.rid), 10));

            Query<Persona> q = session.createQuery(query);
            persona = q.getSingleResult();

            persona.setNombreCompleto("Fernando");
            session.saveOrUpdate(persona);

            Persona persona2 = new Persona();
            persona2.setNombreCompleto("Sandra Pascual");
            persona2.setRfc("USHE038948");
            persona2.setFechaUpdate(new Timestamp(new Date().getTime()));
            session.saveOrUpdate(persona2);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return persona.toString();
    }

    @RequestMapping(value = "/eliminarPersona/{rid}", method = RequestMethod.GET)
    public String eliminarPersona(@PathVariable("rid") int rid) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            transaction = session.beginTransaction();

            Persona personaDelete = new Persona();
            personaDelete.setRid(rid);

            session.delete(personaDelete);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return selectPersonaHQL();
    }
}
