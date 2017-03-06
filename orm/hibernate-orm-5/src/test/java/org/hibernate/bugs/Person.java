package org.hibernate.bugs;

import java.util.Date;

/**
 * Created by liuq on 2017/3/6.
 */
public class Person extends AbstractEntity {
    public Person() {
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person(String name, String createdById, Date createdOn) {
        this(name);
        this.setCreatedById(createdById);
        this.setCreatedOn(createdOn);
    }

    private String name;

    private String idNo;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
