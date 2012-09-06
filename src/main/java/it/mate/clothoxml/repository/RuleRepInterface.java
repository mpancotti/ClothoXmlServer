package it.mate.clothoxml.repository;

import java.util.List;

import it.mate.clothoxml.domain.Rule;
import it.mate.clothoxml.domain.Vendor;

public interface RuleRepInterface {
	public Rule getRule(Integer codice);
	public List<Rule> findAllRules();
	public void add(Rule rule);
	public void update(Rule rule, Integer codice);
	public void delete(Integer codice);
	public List<Rule> findRulesOfVendor(Vendor vendor);
}
