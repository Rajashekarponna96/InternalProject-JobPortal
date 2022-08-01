package com.anil.example.springboot.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anil.example.springboot.entity.Panel;
import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.PanelRepository;
import com.anil.example.springboot.repository.StudentRepository;
import com.anil.example.springboot.service.PanelService;

@Service
public class PanelServiceImpl implements PanelService {

	@Autowired
	private PanelRepository panelRepository;

	@Override
	public List<Panel> getAllPanel() {
		List<Panel> Panels = new ArrayList<>();
		panelRepository.findAll().forEach(Panels::add);
		return Panels;
	}

	@Override
	public void deletePaneltById(long id) {
		panelRepository.deleteById(id);

	}

	@Override
	public Panel getPanel(Long id) {
		return panelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	}

	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Panel findByPhoneNo(String phoneNo) {
		return panelRepository.findByPhoneNo(phoneNo);
	}

	@Override
	public void save(@Valid Panel panel) {
		// TODO Auto-generated method stub

	}

	public Panel getPanel(long id) {
		return panelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	}

	@Override
	public Panel findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Panel addPanel(Panel panel) {
		return panelRepository.save(panel);
	}

	@Override
	public Panel findByEmail(String email) {
		return panelRepository.findByEmail(email);
	}

	@Override
	public void deleteStudentById(long id) {
		// TODO Auto-generated method stub
		
	}

}
