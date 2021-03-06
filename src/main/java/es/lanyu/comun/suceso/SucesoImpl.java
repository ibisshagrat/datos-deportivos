package es.lanyu.comun.suceso;

import es.lanyu.commons.servicios.entidad.ServicioEntidad;
import es.lanyu.commons.tiempo.DatableInstant;
import es.lanyu.participante.Participante;

public abstract class SucesoImpl extends DatableInstant implements Suceso {
	protected transient Participante participante;
	protected String idParticipante;
	protected String actor;
	transient protected ServicioEntidad servicioEntidad;

	@Override
	public Participante getParticipante() {
		if(participante == null)
			participante = servicioEntidad.getIdentificable(Participante.class, idParticipante);
		return participante;
	}
	
	@Override
	public void setParticipante(Participante participante) {
		this.participante = participante;
		this.idParticipante = (participante != null) ? participante.getIdentificador() : null;
	}

	@Override
	public String getActor() {
		return actor;
	}
	
	public void setActor(String actor) {
		this.actor = actor;
	}
	
}
