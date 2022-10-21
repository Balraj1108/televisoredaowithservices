package it.prova.televisoredaowithservices.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Televisore {
	
	private Long id;
	private String marca;
	private String modello;
	private int pollici;
	private Date dataProduzione;
	
	public Televisore () {
		
	}

	public Televisore(String marca, String modello, int pollici, Date dataProduzione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.pollici = pollici;
		this.dataProduzione = dataProduzione;
	}

	public Televisore(Long id, String marca, String modello, int pollici, Date dataProduzione) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.pollici = pollici;
		this.dataProduzione = dataProduzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getPollici() {
		return pollici;
	}

	public void setPollici(int pollici) {
		this.pollici = pollici;
	}

	public Date getDataProduzione() {
		return dataProduzione;
	}

	public void setDataProduzione(Date dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	
	@Override
	public String toString() {
		
		String dataProduzioneString = dataProduzione!=null?new SimpleDateFormat("dd/MM/yyyy").format(dataProduzione):" N.D.";
		
		return "Televisore [id= " + id + ", marca= " + marca + ", modello= " + modello + ", pollici= " + pollici 
				+ ", dataproduzione= " + dataProduzioneString + "]";
	}
	
	

}