package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.model.UrgencyAtention;
@Repository
public class AtentionRepository {

	private Map<Integer, UrgencyAtention> atentions;

	public AtentionRepository() {
		atentions = new HashMap<Integer, UrgencyAtention>();
	}

	public void addAtencion(UrgencyAtention atention) {
		atentions.put(atention.getId(), atention);
	}

	public UrgencyAtention getAtention(int id) {
		return atentions.get(id);
	}

	public List<UrgencyAtention> getAllAtentions() {
		return new ArrayList<UrgencyAtention>(atentions.values());
	}

}
