package ua.service.impl;

import ua.entity.Ingredient;
import ua.service.IngredientService;
import ua.repository.IngredientRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.SimpleFilter;
import org.springframework.data.jpa.domain.Specification;

@Service
public class IngredientServiceImpl extends CrudServiceImpl<Ingredient, Integer> implements IngredientService {

	private IngredientRepository repository;
	
	@Autowired
	public IngredientServiceImpl(IngredientRepository repository){
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Ingredient> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@Override
	public Page<Ingredient> findAll(Pageable pageable, SimpleFilter filter){
		return repository.findAll(filter(filter), pageable);
	}
	
	public Specification<Ingredient> filter(SimpleFilter filter){
		return (root, cq, cb)->{
				if(filter.getSearch().isEmpty())return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
		};
	}
}
