package com.example.taxiexpressv2.Services;

import com.example.taxiexpressv2.Repositories.usr.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BaseServiceImp<T, id> implements BaseServiceInterface<T, id>{

	
	@Autowired
	BaseRepository<T, id> jpaRepo;

	@Override
	public List<T> retrieveAll() {
		 return new ArrayList<>(this.jpaRepo.findAll());
	}

	@Override
	public T add(T e) {
		 return this.jpaRepo.save(e);
	}

	@Override
	public T update(T e) {
		 return this.jpaRepo.save(e);
	}

	@Override
	public T retrieve(id id) {
		 return this.jpaRepo.findById(id).orElse(null);
	}

	@Override
	public void remove(id id) {
		 this.jpaRepo.deleteById(id);
		
	}


	



	


}
