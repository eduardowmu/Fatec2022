package br.edu.fatec.crud.vh;

import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.vo.EntityVo;

public interface EntityVh {
	public abstract EntityDomain getEntityRequest(EntityVo e);
	public abstract EntityVo getEntityResponse(EntityDomain ed);
}
