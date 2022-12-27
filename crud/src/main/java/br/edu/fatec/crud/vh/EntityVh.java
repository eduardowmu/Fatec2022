package br.edu.fatec.crud.vh;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.vo.EntityVo;

public interface EntityVh {
	public abstract EntityDomain getEntityRequest(EntityVo e);
	public abstract EntityVo getEntityResponse(EntityDomain ed);
}
