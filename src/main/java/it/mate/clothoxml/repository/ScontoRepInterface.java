package it.mate.clothoxml.repository;

import java.util.List;

import it.mate.clothoxml.domain.Sconto;

public interface ScontoRepInterface {
	public Sconto getSconto(Integer codice);
	public List<Sconto> findAllScontos();
	public void add(Sconto sconto);
	public void update(Sconto sconto, Integer codice);
	public void delete(Integer codice);
}
