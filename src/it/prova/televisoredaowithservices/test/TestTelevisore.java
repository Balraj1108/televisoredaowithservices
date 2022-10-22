package it.prova.televisoredaowithservices.test;

import it.prova.televisoredaowithservices.service.MyServiceFactory;
import it.prova.televisoredaowithservices.service.televisore.TelevisoreService;

import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.model.Televisore;

public class TestTelevisore {
	public static void main(String[] args) throws Exception {
		
		
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();
		
		try {
			
			
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

			testInserimentoNuovoTelevisore(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

			testRimozioneTelevisore(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

			testFindByExample(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

			testUpdateTelevisore(televisoreService);
			System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//System.out.println(televisoreService.listAll());
	}
	
	private static void testInserimentoNuovoTelevisore(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testInserimentoNuovoTelevisore inizio.............");
		Televisore nuovoTelevisore = new Televisore("LG", "k400", 20, new Date());
		if (televisoreService.inserisciNuovo(nuovoTelevisore) != 1)
			throw new RuntimeException("testInserimentoNuovoUser FAILED ");

		System.out.println(".......testInserimentoNuovoTelevisore PASSED.............");
	}

	private static void testRimozioneTelevisore(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testRimozioneTelevisore inizio.............");
		// recupero tutti gli user
		List<Televisore> interoContenutoTabella = televisoreService.listAll();
		if (interoContenutoTabella.isEmpty() || interoContenutoTabella.get(0) == null)
			throw new Exception("Non ho nulla da rimuovere");

		Long idDelPrimo = interoContenutoTabella.get(0).getId();
		// ricarico per sicurezza con l'id individuato
		Televisore toBeRemoved = televisoreService.findById(idDelPrimo);
		if (televisoreService.rimuovi(toBeRemoved) != 1)
			throw new RuntimeException("testRimozioneUser FAILED ");

		System.out.println(".......testRimozioneTelevisore PASSED.............");
	}

	private static void testFindByExample(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testFindByExample inizio.............");
		// inserisco i dati che poi mi aspetto di ritrovare
		televisoreService.inserisciNuovo(new Televisore("sam", "t500", 25 ,new Date()));
		//televisoreService.inserisciNuovo(new Televisore("hp", "y100", 15 ,new Date()));

		// preparo un example che ha come nome 'as' e ricerco
		Televisore televisoreProva = new Televisore("sam", "t500", 25 ,new Date());
		//televisoreProva.setMarca("a");
		List<Televisore> risultatifindByExample = televisoreService.findByExample(televisoreProva);
		if (risultatifindByExample.size() != 1)
			throw new RuntimeException("testFindByExample FAILED ");

		// se sono qui il test è ok quindi ripulisco i dati che ho inserito altrimenti
		// la prossima volta non sarebbero 2 ma 4, ecc.
		for (Televisore televisoreItem : risultatifindByExample) {
			televisoreService.rimuovi(televisoreItem);
		}

		System.out.println(".......testFindByExample PASSED.............");
	}
	
	

	private static void testUpdateTelevisore(TelevisoreService televisoreService) throws Exception {
		System.out.println(".......testUpdateTelevisore inizio.............");

		// inserisco i dati che poi modifico
		if (televisoreService.inserisciNuovo(new Televisore("samsung", "k652", 5, new Date())) != 1)
			throw new RuntimeException("testUpdateUser: inserimento preliminare FAILED ");

		// recupero col findbyexample e mi aspetto di trovarla
		List<Televisore> risultatifindByExample = televisoreService.findByExample(new Televisore("samsung", "k652", 5, new Date()));
		if (risultatifindByExample.size() != 1)
			throw new RuntimeException("testUpdateUser: testFindByExample FAILED ");

		//mi metto da parte l'id su cui lavorare per il test
		Long idGiovanna = risultatifindByExample.get(0).getId();
		
		// ricarico per sicurezza con l'id individuato e gli modifico un campo
		String nuovaMarca = "ace";
		Televisore toBeUpdated = televisoreService.findById(idGiovanna);
		toBeUpdated.setMarca(nuovaMarca);
		if (televisoreService.aggiorna(toBeUpdated) != 1)
			throw new RuntimeException("testUpdateUser FAILED ");

		System.out.println(".......testUpdateTelevisore PASSED.............");
	}
	
	

}
