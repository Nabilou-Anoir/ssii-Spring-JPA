package ssii.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssii.dao.PersonneRepository;
import ssii.dao.ProjetRepository;
import ssii.service.ParticipationService;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ParticipationServiceTest {
    @Autowired
    private ParticipationService participationService;

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Test
    void participationUnique() {
        // la règle 1
        assertThrows(RuntimeException.class, () -> {
            participationService.ajouterParticipation(1, 1, "Développeur JAVA", 50f);
            participationService.ajouterParticipation(1, 1, "Product Owner", 30f);
        });
    }

    @Test
    void totalPourcentage() {
        // la règle 2
        assertThrows(RuntimeException.class, () -> {
            participationService.ajouterParticipation(1, 1, "Développeur JAVA", 60f);
            participationService.ajouterParticipation(1, 2, "Développeur Python", 50f);
        });
    }

    @Test
    void nombreProjetsMax() {
        // la règle 3
        assertThrows(RuntimeException.class, () -> {
            participationService.ajouterParticipation(1, 1, "Développeur JAVA", 30f);
            participationService.ajouterParticipation(1, 2, "Developpeur Python", 30f);
            participationService.ajouterParticipation(1, 3, "Testeur", 30f);
            participationService.ajouterParticipation(1, 4, "Product Owner", 10f);
        });
    }
}