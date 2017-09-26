package ua.service.impl;

import ua.entity.Ms;
import ua.service.MsService;
import ua.repository.MsRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MsServiceImpl extends CrudServiceImpl<Ms, Integer> implements MsService {

	@Autowired
	public MsServiceImpl(MsRepository repository){
		super(repository);
	}
}
