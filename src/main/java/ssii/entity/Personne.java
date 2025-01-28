package ssii.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricule;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String poste;

    @ManyToOne
    private Personne superieur;

    @OneToMany(mappedBy = "superieur")
    private List<Personne> subordonnes = new ArrayList<>();

    @OneToMany(mappedBy = "personne")
    private List<Participation> participations = new ArrayList<>();
}