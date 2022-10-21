package it.prova.televisoredaowithservices.test;

import it.prova.televisoredaowithservices.service.MyServiceFactory;
import it.prova.televisoredaowithservices.service.televisore.TelevisoreService;

import java.util.List;

import it.prova.televisoredaowithservices.model.Televisore;

public class TestTelevisore {
	public static void main(String[] args) throws Exception {
		
		
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();
		
		try {
			
			List<Televisore> listaTelevisori = televisoreService.listAll();
			
			for (Televisore televisore : listaTelevisori) {
				System.out.println(televisore);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		//System.out.println(televisoreService.listAll());
	}

}
