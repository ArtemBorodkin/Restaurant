package ua.service.impl;

import ua.entity.Cuisine;
import ua.model.view.CuisineView;
import ua.service.CuisineService;
import ua.repository.CuisineRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CuisineServiceImpl extends CrudServiceImpl<Cuisine, Integer> implements CuisineService{

	private final CuisineRepository repository;
	
	@Autowired
	public CuisineServiceImpl(CuisineRepository repository){
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}

	@Override
	public List<CuisineView> findAllView() {
		return repository.findAllView();
	}
}
