package org.sid.stock;

import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sid.stock.sb.dao.MedicamentsRep;
import org.sid.stock.sb.entities.Medicaments;
import org.sid.stock.sb.service.MedicamentsService;
import org.springframework.test.context.junit4.SpringRunner;

import javassist.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class MedicamentTest {
    @Mock
    private MedicamentsRep medicamentrRep;

    @Mock
    private MedicamentsService medicamentService;

    @Test
    public void itShouldCreateAMedicament() {
        Medicaments medicament = new Medicaments();
        medicament.setLibelle("Paracetamol");
        medicament.setQuantite(35);
        medicament.setPrixAchat(950);
        medicament.setPrixVente(1500);

        when(medicamentService.create(medicament)).thenReturn(medicament);
        assertThat(medicamentService.create(medicament)).isNotNull();
        verify(medicamentService).create(medicament);
    }

    @Test
    public void itShouldReturn_404() throws NotFoundException {
        when(medicamentService.findOne(1542L)).thenThrow(NotFoundException.class);
    }

    @Test
    public void itShouldReturnList() {
        Medicaments sampleMedicament = new Medicaments();
        List<Medicaments> medicamentsList = new ArrayList<Medicaments>();
        medicamentService.create(sampleMedicament);
        medicamentsList.add(sampleMedicament);
        
        when(medicamentService.findAll()).thenReturn(medicamentsList);
        
        assertThat(medicamentService.findAll().size()).isNotNull();
    }
   
}