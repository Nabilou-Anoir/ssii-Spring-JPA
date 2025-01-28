package ssii.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;
    private String pourcentage;
    @ManyToOne

    private Personne personne;

    @ManyToOne
    private Projet projet;
}

