package com.KPI.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KPI.backend.model.Records;
import com.KPI.backend.repository.RecordsRepository;

@Service
public class RecordService {
	@Autowired
	RecordsRepository record;
	public String addRecord(Records r)
	{
		record.save(r);
		return "Saved Successfully";
	}
}
