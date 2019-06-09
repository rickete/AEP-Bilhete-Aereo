package Repositório_Bilhete_Aereo;

public interface BilheteAerioRepository {
	void inserirBilhete(BilheteAereo bilhete) throws Exception;
	void excluirBilheteAereo(BilheteAereo bilhete) throws Exception;
	void alterarBilheteAereo(BilheteAereo bilhete) throws Exception;

}
