package Repositório_Bilhete_Aereo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BilheteAerioRepositoryMemoria implements BilheteAerioRepository {
	private Set<BilheteAereo> bilhetes = new HashSet<BilheteAereo>();
	
	
	@Override
	public void inserirBilhete(BilheteAereo bilhete) throws Exception {
		this.bilhetes.add(bilhete);
	}

	@Override
	public void excluirBilheteAereo(BilheteAereo bilhete) throws Exception {
		BilheteAereo excluirBilhete = null;
		for (BilheteAereo b : this.bilhetes) {
			if (b.getVoo() == bilhete.getVoo()) {
				excluirBilhete = b;
				break;
			}
		}
		if (excluirBilhete != null) {
			this.bilhetes.remove(excluirBilhete);
		}
		
	}

	@Override
	public void alterarBilheteAereo(BilheteAereo bilhete) throws Exception {
		this.excluirBilheteAereo(bilhete);
		this.inserirBilhete(bilhete);
		
	}
	
	public List<BilheteAereo> getBilhetes() {
		return Collections.unmodifiableList(new ArrayList<>(bilhetes));
	}

}
