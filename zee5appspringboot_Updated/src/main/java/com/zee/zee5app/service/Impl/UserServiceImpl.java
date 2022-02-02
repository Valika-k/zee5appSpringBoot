package com.zee.zee5app.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.repository.Impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
//	private UserServiceImpl() throws IOException {
//		
//	}
	//getting repository object through spring
    public UserServiceImpl() throws IOException {
		
	}
	
	
//	private static UserService service;
//	public static UserService getInstance() throws IOException{
//		if(service==null)
//			service = new UserServiceImpl();
//		return service;
//	}
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		//repository.save(register);
		Register register2 = userRepository.save(register);
		if(register2!=null) {
			return "success";
		}
		else {
			return "fail";
		}
			
		
	}


	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException,
			InvalidEmailException, InvalidPasswordException, InvalidNameException {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}


	@Override
	public Register[] getAllUsers()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		
		
		List<Register> list = userRepository.findAll();
		
		Register[] array=new Register[list.size()];
		return list.toArray(array);
	}


	
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		// can we cross check it with findById() ===> record exists?
		
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				userRepository.deleteById(id);
			return "success";}
		} catch (IdNotFoundException | InvalidIdLengthException| InvalidEmailException| InvalidPasswordException | InvalidNameException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}


	
	

}