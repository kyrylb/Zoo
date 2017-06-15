package kberezovchuk.hibtests.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import kberezovchuk.hibtests.types.PermissionType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;




@Entity
@Table(name = "permissions", schema = "myschema")
@Getter
@Setter
public class Permission implements Serializable {
    private static final long serialVersionUID = 4336337810549134191L;

    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="permissions")
    private final Set<User> users = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_id_seq")
    @SequenceGenerator(name = "permissions_id_seq", sequenceName = "myschema.permissions_id_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @NotNull
    @Column(name = "p_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PermissionType type;

    @Column(name = "p_instance_id")
    private Integer instanceId;
}
