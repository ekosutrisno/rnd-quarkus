package org.ekosutrisno.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Person {
    private Integer userId;
    private String username;
    private String education;
    private Integer age;

    public Person() {
    }

    public Person(Integer userId, String username, String education, Integer age) {
        this.userId = userId;
        this.username = username;
        this.education = education;
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}