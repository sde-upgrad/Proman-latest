package apps.proman.service.user.entity;

import static apps.proman.service.common.entity.Entity.SCHEMA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import apps.proman.service.common.entity.Identifier;
import apps.proman.service.common.entity.MutableEntity;
import apps.proman.service.common.entity.UniversalUniqueIdentifier;
import apps.proman.service.common.entity.ext.EntityEqualsBuilder;
import apps.proman.service.common.entity.ext.EntityHashCodeBuilder;

@Entity
@Table(name = "ROLES", schema = SCHEMA)
public class RoleEntity extends MutableEntity implements Identifier<Integer>, UniversalUniqueIdentifier<Integer>, Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "UUID")
    @NotNull
    private int uuid;

    @Column(name = "NAME")
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(name = "DESCRIPTION")
    @NotNull
    @Size(max = 200)
    private String description;

    @Column(name = "STATUS")
    @NotNull
    private boolean active;

    @OneToMany
    @JoinColumn(name = "ROLE_ID")
    private List<RolePermissionEntity> permissions;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<RolePermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermissionEntity> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object obj) {
        return new EntityEqualsBuilder<Integer>().equalsById(this, obj);
    }

    @Override
    public int hashCode() {
        return new EntityHashCodeBuilder<Integer>().hashCodeById(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
