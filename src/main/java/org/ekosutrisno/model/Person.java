package org.ekosutrisno.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * The type Person.
 *
 * @author Eko Sutrisno
 * @create 13 /11/2020 14:35
 */
@RegisterForReflection
public class Person {
    private Integer userId;
    private String username;
    private String education;
    private Integer age;

    /**
     * Instantiates a new Person.
     */
    public Person() {
    }

    /**
     * Instantiates a new Person.
     *
     * @param userId    the user id
     * @param username  the username
     * @param education the education
     * @param age       the age
     */
    public Person(Integer userId, String username, String education, Integer age) {
        this.userId = userId;
        this.username = username;
        this.education = education;
        this.age = age;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets education.
     *
     * @return the education
     */
    public String getEducation() {
        return education;
    }

    /**
     * Sets education.
     *
     * @param education the education
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}