package it.prova.televisoredaowithservices.dao.televisore;

import java.util.Date;
import java.util.List;

import it.prova.televisoredaowithservices.dao.IBaseDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
	
	public List<Televisore> televisoriProdottiIntervalloDate(Date dateBefore, Date dateAfter) throws Exception;
	public Televisore televisorePiuGrande() throws Exception;
	public List<String> marcheTelevisoriUltimiSeiMesi() throws Exception;
	

}
