package it.mate.clothoxml.repository;

import java.util.List;

import it.mate.clothoxml.domain.Prezzo;
import it.mate.clothoxml.domain.Prezzofisso;

public interface PrezzofissoRepInterface {
	public Prezzofisso getPrezzofisso(Integer codice);
	public List<Prezzofisso> findAllPrezzofisso();
	public void add(Prezzofisso prezzofisso);
	public void update(Prezzofisso prezzofisso, Integer codice);
	public void delete(Integer codice);
	public List<Prezzofisso> findPrezzifissiOfRule(Integer rule);
}
