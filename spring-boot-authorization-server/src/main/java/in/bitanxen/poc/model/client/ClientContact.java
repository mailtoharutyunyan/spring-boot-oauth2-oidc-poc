package in.bitanxen.poc.model.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "TB_CLIENT_CONTACT")
public class ClientContact {

    @Id
    @GenericGenerator(name = "Application-Generic-Generator",
            strategy = "in.bitanxen.poc.config.ApplicationGenericGenerator"
    )
    @GeneratedValue(generator = "Application-Generic-Generator")
    @Column(name = "CLIENT_CONTACT_ID", nullable = false, unique = true)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ENTITY", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENT_CONTACT_CLIENT"))
    private ClientEntity clientEntity;

    @Column(name = "CONTACT", length = 1000, nullable = false)
    private String contact;

    public ClientContact(ClientEntity clientEntity, String contact) {
        this.clientEntity = clientEntity;
        this.contact = contact;
    }
}
