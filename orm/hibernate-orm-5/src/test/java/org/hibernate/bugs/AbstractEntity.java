package org.hibernate.bugs;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by liuq on 2017/3/6.
 */
@MappedSuperclass
public abstract class AbstractEntity {
    private String id;
    private String createdById;
    private Date createdOn;
    private String lastModifiedById;
    private Date lastModifiedOn;
    private Integer version;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (this.id == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        AbstractEntity entityBase = (AbstractEntity) obj;

        return this.id.equals(entityBase.getId());
    }

    @Override
    public int hashCode() {
        return this.id == null ? 0 : this.id.hashCode();
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Integer getVersion() {
        return version;
    }

    private void setVersion(Integer version) {
        this.version = version;
    }
}
