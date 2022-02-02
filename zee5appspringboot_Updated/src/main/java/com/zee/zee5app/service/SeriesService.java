package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SeriesRepository;

public interface SeriesService {
	
	public String addSeries(Series movie);
	public String deleteSeriesById(String id) throws IdNotFoundException;
	public String updateSeries(String id, Series movie) throws IdNotFoundException;
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException;
	public Optional<List<Series>> getAllSeriesDetails() throws NameNotFoundException, InvalidIdLengthException;
	public Optional<List<Series>> getAllSeries() throws InvalidIdLengthException;
	
	
}