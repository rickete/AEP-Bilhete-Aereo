package Repositório_Bilhete_Aereo;

import java.sql.Date;

public class BilheteAereo {
	private final Integer voo;
	private final String origem;
	private final String destino;
	private final Date data;
	
	public BilheteAereo(Integer voo, String origem, String destino, Date data) {
		this.voo = voo;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
	}
	
	public Date getData() {
		return data;
	}
	public String getDestino() {
		return destino;
	}
	public String getOrigem() {
		return origem;
	}
	public Integer getVoo() {
		return voo;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + voo;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BilheteAereo other = (BilheteAereo) obj;
		if (voo != other.voo)
			return false;
		return true;
	}
	
	
}
