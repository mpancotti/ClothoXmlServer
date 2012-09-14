package it.mate.clothoxml.repository;

import java.util.List;

import it.mate.clothoxml.domain.Prezzo;
import it.mate.clothoxml.domain.Sconto;

public interface PrezzoRepInterface {
	public Prezzo getPrezzo(Integer codice);
	public List<Prezzo> findAllPrezzi();
	public Integer add(Prezzo prezzo);
	public void update(Prezzo prezzo, Integer codice);
	public void delete(Integer codice);
	public List<Prezzo> findPrezziOfRule(Integer rule);
}
