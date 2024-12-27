package com.raysi.springexceptionhandeling.enitity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dev")
public class Developer {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "dev_seq"
    )
    @SequenceGenerator(
            name = "dev_seq",
            sequenceName = "dev_sequence",
            allocationSize = 116
    )
    private Long id;
    private String name;
    @Email
    private String email;
    private String position;
}
