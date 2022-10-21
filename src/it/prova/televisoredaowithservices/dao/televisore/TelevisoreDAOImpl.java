package it.prova.televisoredaowithservices.dao.televisore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import it.prova.televisoredaowithservices.dao.AbstractMySQLDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public class TelevisoreDAOImpl extends AbstractMySQLDAO implements TelevisoreDAO {

	
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	
	@Override
	public List<Televisore> list() throws Exception {
		
		if (isNotActive())
			throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");

		ArrayList<Televisore> result = new ArrayList<Televisore>();

		try (Statement ps = connection.createStatement(); ResultSet rs = ps.executeQuery("select * from televisore")) {

			while (rs.next()) {
				Televisore teleTemp = new Televisore();
				teleTemp.setMarca(rs.getString("marca"));
				teleTemp.setModello(rs.getString("modello"));
				teleTemp.setPollici(rs.getInt("pollici"));
				teleTemp.setDataProduzione(rs.getDate("dataproduzione"));
				teleTemp.setId(rs.getLong("ID"));
				result.add(teleTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Televisore get(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Televisore> televisoriProdottiIntervalloDate(Date dateBefore, Date dateAfter) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Televisore televisorePiuGrande() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> marcheTelevisoriUltimiSeiMesi() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
