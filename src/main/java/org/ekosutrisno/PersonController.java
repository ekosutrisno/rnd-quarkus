package org.ekosutrisno;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.ekosutrisno.model.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
    @Tag(name = "RnD Quarkus Development", description = "Get All Person")
    public Set<Person> list() {
        return personSet;
    }

    @POST
    @Tag(name = "RnD Quarkus Development", description = "Added Person")
    @Transactional
    public Set<Person> add(Person person) {
        personSet.add(person);
        return personSet;
    }

    @DELETE
    @Tag(name = "RnD Quarkus Development", description = "Delete Person")
    @Path("/{userId}")
    public Set<Person> delete(@PathParam("userId") Integer userId) {
        personSet.removeIf(existingPerson
                -> existingPerson.getUserId()
                .equals(userId)
        );
        return personSet;
    }

}
