package ua.service.impl;

import ua.entity.Place;
import ua.service.PlaceService;
import ua.repository.PlaceRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlaceServiceImpl extends CrudServiceImpl<Place, Integer>implements PlaceService{

	@Autowired
	public PlaceServiceImpl(PlaceRepository repository){
		super(repository);
	}
}