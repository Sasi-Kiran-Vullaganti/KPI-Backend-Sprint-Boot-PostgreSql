package com.KPI.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KPI.backend.repository.RecordsRepository;
import com.KPI.backend.service.RecordService;
import com.KPI.backend.exception.ResourceNotFoundException;
import com.KPI.backend.model.Records;

@RestController
@RequestMapping("/api/Records")
@CrossOrigin
public class RecordsController {
	
	@Autowired
	private RecordsRepository RecordsRepository;
	RecordService rs;
	
	//Get All Records
	@GetMapping("AllRecords")
	public List<Records> getAllRecords()
	{
		return this.RecordsRepository.findAll();
	}
	
	//Get Record by id
	@GetMapping("/GetRecord/{id}")
	public ResponseEntity<Records> getRecordById(@PathVariable(value = "id") Long recordId) throws ResourceNotFoundException
	{
		Records Record = RecordsRepository.findById(recordId).orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: "+recordId));
		return ResponseEntity.ok().body(Record);
		
	}
	
	//Save record
	@PostMapping("/addRecords")
	public String CreateRecord(@RequestBody Records Record)
	{
		this.RecordsRepository.save(Record);
		return "added succesfully";
	}
	
	//update record
	@PutMapping("/UpdateRecords/{id}")
	public ResponseEntity<Records> updateEmployee(@PathVariable(value = "id") Long recordId,
			@Validated @RequestBody Records RecordDetails) throws ResourceNotFoundException {
		Records Record = RecordsRepository.findById(recordId).orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: "+recordId));

		Record.setGroupName(RecordDetails.getGroupName());
		Record.setNoOfDefects(RecordDetails.getNoOfDefects());
		Record.setPartName(RecordDetails.getPartName());
		Record.setPLMKPI1(RecordDetails.getPLMKPI1());
		Record.setProjectCode(RecordDetails.getProjectCode());
		Record.setSQA(RecordDetails.getSQA());
		Record.setTeamName(RecordDetails.getTeamName());
		Record.setTimeTaken(RecordDetails.getTimeTaken());
		Record.setY21ProjectName(RecordDetails.getY21ProjectName());
		final Records updatedRecord = RecordsRepository.save(Record);
		return ResponseEntity.ok(updatedRecord);
	}
	
	//delete record
	@DeleteMapping("/DeleteRecords/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long recordId)
			throws ResourceNotFoundException {
		Records Record = RecordsRepository.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + recordId));

		RecordsRepository.delete(Record);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
