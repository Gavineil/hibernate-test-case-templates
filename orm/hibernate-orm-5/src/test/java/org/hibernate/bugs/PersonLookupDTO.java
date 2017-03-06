package org.hibernate.bugs;

/**
 * Created by liuq on 2017/3/6.
 */
public class PersonLookupDTO {
    private String name;

    private Integer version;

    public PersonLookupDTO(String name, Integer version){
        this.name = name;
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
