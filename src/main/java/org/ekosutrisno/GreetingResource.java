package org.ekosutrisno;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.ekosutrisno.model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * The type Greeting resource.
 */
@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    /**
     * The Person set.
     */
    Set<Person> personSet = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    /**
     * Instantiates a new Greeting resource.
     */
    public GreetingResource() {
        personSet.addAll(
                List.of(
                        new Person(1, "Eko Sutrisno", "Pendidikan Matematika", 20),
                        new Person(2, "Meiliana", "Pendidikan Bahasa Inggris", 24),
                        new Person(3, "Miaw", "Pendidikan Agama", 22)
                )
        );
    }

    /**
     * List response.
     *
     * @return the response
     */
    @GET
    @Tag(name = "RnD Quarkus Development", description = "Get All Person")
    public Response list() {
        return Response.ok(personSet).build();
    }

    /**
     * Add set.
     *
     * @param person the person
     * @return the set
     */
    @POST
    @Tag(name = "RnD Quarkus Development", description = "Added Person")
    public Set<Person> add(Person person) {
        System.out.println(person.toString());
        personSet.add(person);
        return personSet;
    }

    /**
     * Delete set.
     *
     * @param userId the user id
     * @return the set
     */
    @DELETE
    @Tag(name = "RnD Quarkus Development", description = "Delete Person")
    @Path("/{userId}")
    public Set<Person> delete(@PathParam("userId") Integer userId) {
        personSet.removeIf(existingPerson
                -> existingPerson.getUserId()
                .equals(userId)
        );
        System.out.println(userId);

        return personSet;
    }

}
