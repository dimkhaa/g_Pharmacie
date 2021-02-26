package org.sid.stock;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sid.stock.sb.dao.CommandeRep;
import org.sid.stock.sb.entities.Commande;
import org.sid.stock.sb.entities.LigneCommande;
import org.sid.stock.sb.service.CommandeService;
import org.springframework.test.context.junit4.SpringRunner;

import javassist.NotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class CommandeTest {
    @Mock
    private CommandeRep commandeRep;

    @Mock
    private CommandeService commandeService;

    @Test
    public void itShouldReturnCreateCommande_404() throws NotFoundException {
        Commande commande = new Commande();
        commande.setDateCommande(new Date());
        commande.setMontant(3500);
        LigneCommande ligneCommande = new LigneCommande();
        
        when(commandeService.ajoutCommande(commande, ligneCommande, 5L, 4L)).thenThrow(NotFoundException.class);
    }


    @Test
    public void itShouldReturnListCommande() throws NotFoundException {
        Commande commande = new Commande();
        commande.setDateCommande(new Date());
        commande.setMontant(3500);
        
        List<Commande> commandeList = new ArrayList<Commande>();
        commandeService.ajoutCommande(commande, null, null, null);
        commandeList.add(commande);
        
        when(commandeService.allCommandes()).thenReturn(commandeList);
        
        assertThat(commandeService.allCommandes().size()).isNotNull();
    }
   
}