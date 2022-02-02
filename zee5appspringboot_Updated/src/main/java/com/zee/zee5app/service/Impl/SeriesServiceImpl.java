package com.zee.zee5app.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SeriesRepository;
//import com.zee.zee5app.repository.Impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService;

@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesRepository respository;
	
//	private SeriesServiceImpl() throws IOException {
//		
//	}
	//getting repository object through spring
    public SeriesServiceImpl() throws IOException {
		
	}
	
	
//	private static SeriesService service;
//	public static SeriesService getInstance() throws IOException{
//		if(service==null)
//			service = new SeriesServiceImpl();
//		return service;
//	}
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		//repository.save(series);
		Series register2 = respository.save(series);
		if(register2!=null) {
			return "success";
		}
		else {
			return "fail";
		}
			
		
	}


	@Override
	public String updateSeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return respository.findById(id);
	}


//	@Override
//	public Series[] getAllSeries() throws InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		
//		
//		List<Series> list = respository.findAll();
//		
//		Series[] array=new Series[list.size()];
//		return list.toArray(array);
//	}


	
	public String deleteSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		// can we cross check it with findById() ===> record exists?
		
		try {
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				respository.deleteById(id);
			return "success";}
		} catch (IdNotFoundException | InvalidIdLengthException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Series>> getAllSeries() throws InvalidIdLengthException{
		// TODO Auto-generated method stub
		return Optional.ofNullable(respository.findAll());
	}


	@Override
	public Optional<List<Series>> getAllSeriesDetails() throws NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return null;
	}








	

	
	

}