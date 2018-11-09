package io.nbe.tertara.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "form")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Form extends AuditModel {

    @Id
    @GeneratedValue(generator = "form_generator")
    @SequenceGenerator(
            name = "form_generator",
            sequenceName = "form_sequence",
            initialValue = 1000
    )
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Question> questions;

    @ColumnDefault("FALSE")
    private boolean started;

    @ColumnDefault("FALSE")
    private boolean over;
}
