package com.majidim.easybankv4.easybankv4.newService;

import com.majidim.easybankv4.easybankv4.HibernateImps.DemandeCreditImpl;
import com.majidim.easybankv4.easybankv4.dto.DemendeCredit;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DemandeCreditServiceTests {
    private DemandeCreditService demandeCreditService;
    private DemandeCreditImpl demandeCreditImpl;

    @Before
    public void setUp() {
        demandeCreditImpl = mock(DemandeCreditImpl.class);
        demandeCreditService = new DemandeCreditService(demandeCreditImpl);
    }

    @Test
    public void testCreateValidDemandeCredit() {
        DemendeCredit demandeCredit = createValidDemendeCredit();

        double Taux = 0.12;
        demandeCredit.setSimulation(calculateExpectedSimulation(demandeCredit, Taux));

        when(demandeCreditImpl.create(demandeCredit)).thenReturn(Optional.of(demandeCredit));


        Optional<DemendeCredit> result = demandeCreditService.create(demandeCredit);

        assertTrue(result.isPresent());
        assertEquals(demandeCredit, result.get());
    }

    @Test
    public void testUpdateValidDemandeCredit() {
        DemendeCredit demandeCredit = createValidDemendeCredit();
        demandeCredit.setRemarque("Updated request");
        demandeCredit.setStatus("Approved");
        demandeCredit.setSimulation(5500.0);

        when(demandeCreditImpl.update(demandeCredit)).thenReturn(Optional.of(demandeCredit));

        Optional<DemendeCredit> result = demandeCreditService.update(demandeCredit);
        assertTrue(result.isPresent());
        assertEquals(demandeCredit, result.get());
    }

    @Test
    public void testDelete() {
        String numero = "123";
        when(demandeCreditImpl.delete(numero)).thenReturn(true);

        boolean result = demandeCreditService.delete(numero);
        assertTrue(result);
    }

    @Test
    public void testFindByCode() {
        String code = "123";
        DemendeCredit demandeCredit = createValidDemendeCredit();

        when(demandeCreditImpl.findByID(code)).thenReturn(Optional.of(demandeCredit));

        Optional<DemendeCredit> result = demandeCreditService.findByCode(code);
        assertTrue(result.isPresent());
        assertEquals(demandeCredit, result.get());
    }

    @Test
    public void testFindByCodeNotFound() {
        String code = "123";
        when(demandeCreditImpl.findByID(code)).thenReturn(Optional.empty());

        Optional<DemendeCredit> result = demandeCreditService.findByCode(code);
        assertFalse(result.isPresent());
    }

    private DemendeCredit createValidDemendeCredit() {
        DemendeCredit demandeCredit = new DemendeCredit();
        demandeCredit.setNumero("123");
        demandeCredit.setMontant(10000.0);
        demandeCredit.setDuree("12");
        demandeCredit.setRemarque("Valid request");
        demandeCredit.setStatus("Pending");
        demandeCredit.setSimulation(5000.0);
        return demandeCredit;
    }

    private double calculateExpectedSimulation(DemendeCredit demandeCredit, double Taux) {
        return (demandeCredit.getMontant() * Taux / 12) / (1 - Math.pow(1 + (Taux / 12), -Integer.parseInt(demandeCredit.getDuree())));
    }
}
