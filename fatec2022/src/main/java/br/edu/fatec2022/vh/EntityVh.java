package br.edu.fatec2022.vh;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.vo.EntityVo;

public interface EntityVh {
	public abstract EntityDomain getEntityRequest(EntityVo e);
	public abstract EntityVo getEntityResponse(Object obj);
}
