package org.ekosutrisno.controller;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.ekosutrisno.model.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Path("/api/v1/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Person Service V1", description = "Handle Persons")
public class PersonController {

    Set<Person> personSet = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonController() {
        personSet.addAll(
                List.of(
                        new Person(1, "Eko Sutrisno", "Pendidikan Matematika", 20),
                        new Person(2, "Meiliana", "Pendidikan Bahasa Inggris", 24),
                        new Person(3, "Miaw", "Pendidikan Agama", 22)
                )
        );
    }

    @GET
    public Set<Person> list() {
        return personSet;
    }

    @GET
    @Path("/{userId}")
    public Person list(@PathParam(value = "userId") Integer userId) {
        return personSet.stream()
                .filter(person -> person.getUserId().equals(userId))
                .findFirst()
                .orElse(new Person());
    }

    @POST
    @Transactional
    public Set<Person> add(Person person) {
        personSet.add(person);
        return personSet;
    }

    @DELETE
    @Path("/{userId}")
    public Set<Person> delete(@PathParam("userId") Integer userId) {
        personSet.removeIf(existingPerson
                -> existingPerson.getUserId()
                .equals(userId)
        );
        return personSet;
    }

}
