package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
//import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.Impl.MovieServiceImpl;
import com.zee.zee5app.service.Impl.SeriesServiceImpl;
import com.zee.zee5app.service.Impl.SubscriptionServiceImpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);

		System.out.println("\nREGISTRATION DETAILS\n");

		UserService service = applicationContext.getBean(UserService.class);
		Register register;
		register = new Register("reg0001", "valika", "kannaiah", "valika@gmail.com", "sjdnjdfj3u78", null);
		register.setContactnumber(new BigDecimal("3485784798"));
		System.out.println(service.addUser(register));
		
		register = new Register("reg0002", "valika1", "kannaiah1", "valika1@gmail.com", "dfmnf4u89", null);
		register.setContactnumber(new BigDecimal("8487878484"));
		System.out.println(service.addUser(register));
		
		register = new Register("reg0003", "valika2", "kannaiah2", "valika2@gmail.com", "fdjbhfbhb", null);
		register.setContactnumber(new BigDecimal("9498475412"));
		System.out.println(service.addUser(register));
		
		register = new Register("reg0004", "valika3", "kannaiah3", "valika3@gmail.com", "fnjjkfhfbhb", null);
		register.setContactnumber(new BigDecimal("9445893412"));
		System.out.println(service.addUser(register));
		
		register = new Register("reg0005", "valika4", "kannaiah4", "valika4@gmail.com", "ggjjkhfhfbhb", null);
		register.setContactnumber(new BigDecimal("9447578812"));
		System.out.println(service.addUser(register));
		
		register = new Register("reg0006", "valika5", "kannaiah5", "valika5@gmail.com", "sdksjhfbhb", null);
		register.setContactnumber(new BigDecimal("9447547478"));
		System.out.println(service.addUser(register));

		Optional<Register> register1 = null;

		try {
			register1 = service.getUserById("reg0004");
			if (register1 != null) {
				System.out.println("Record found");
				System.out.println(register1.get());
			} else {
				System.out.println("record is not found");
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException
				| InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Register>> optional1;
		try {
			optional1 = service.getAllUserDetails();
			if (optional1.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional1.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service.deleteUserById("reg0003");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			for (Register register2 : service.getAllUsers()) {
				if (register2 != null)
					System.out.println(register2);
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}




		System.out.println("\n MOVIE DETAILS\n");

		MovieService service3 = applicationContext.getBean(MovieService.class);
		Movie movie;

		movie = new Movie("m00001", "Robot 1", "rajani", 150, "2020-12-01", null, "telugu", "13", "action");
		String result13 = service3.addMovie(movie);
		System.out.println(result13);

		movie = new Movie("m00002", "robot 2", "rajani", 134, "2020-12-02", null, "hindi", "13",
				"tamil");
		String result5 = service3.addMovie(movie);
		System.out.println(result5);

		movie = new Movie("m00003", "eternals", "xyzhdjh", 121, "2021-12-01", null, "english", "12", "superhero");
		String result6 = service3.addMovie(movie);
		System.out.println(result6);

		Optional<Movie> movie1 = null;

		try {
			movie1 = service3.getMovieById("m00001");
			System.out.println(movie1.get());
		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Movie>> optional2;
		try {
			optional2 = service3.getAllMovies();
			if (optional2.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional2.get().forEach(e -> System.out.println(e));
			}
		} catch (NameNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service3.deleteMovie("m00003");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Optional<List<Movie>> optional3;
		try {
			optional3 = service3.getAllMovies();
			if (optional3.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional3.get().forEach(e -> System.out.println(e));
			}
		} catch (NameNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		System.out.println("\n SERIES DETAILS\n");

		SeriesService service4 = applicationContext.getBean(SeriesService.class);
		Series series;

		series = new Series("show0001", "Stranger things", "vgdhgsh", "2018-01-01", null, "english", "13", "thriller", 36);
		String result1 = service4.addSeries(series);
		System.out.println(result1);

		series = new Series("show0002", "friends", "ross,joey", "1996-02-01", null, "english", "13", "sitcom",
				56);
		String result7 = service4.addSeries(series);
		System.out.println(result7);

		series = new Series("show0003", "the office", "michael scott", "2005-02-01", null, "english", "18", "sitcom",
				90);
		String result8 = service4.addSeries(series);
		System.out.println(result8);

		Optional<Series> series1 = null;

		try {
			series1 = service4.getSeriesById("show0001");
			System.out.println(series1.get());
		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Series>> optional4;
		try {
			optional4 = service4.getAllSeries();
			if (optional4.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional4.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		

		try {
			service4.deleteSeriesById("show0003");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Optional<List<Series>> optional5;
		try {
			optional5 = service4.getAllSeries();
			if (optional5.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional5.get().forEach(e -> System.out.println(e));
			}

		} catch (InvalidIdLengthException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		
		System.out.println("\n SUBSCRIPTION DETAILS\n");

		SubscriptionService service2 = applicationContext.getBean(SubscriptionService.class);
		Subscription subscription;

		
		try {
			subscription = new Subscription("s0001", "2021-01-01", 4599.0f, "credit", "2020-01-01", "active", "annual",
					"false", "reg0001");
			String result= service2.addSubscription(subscription);
			System.out.println(result);
			
			subscription = new Subscription("s0002", "2020-04-13", 2999.0f, "dedit", "2020-07-13", "active", "quaterly",
					"true", "reg0004");
			String result3 = service2.addSubscription(subscription);
			System.out.println(result3);

			subscription = new Subscription("s0003", "2020-06-01", 1499.0f, "netbanking", "2020-07-01", "inactive",
					"monthly", "false", "reg0005");
			String result4 = service2.addSubscription(subscription);
			System.out.println(result4);
		} catch (InvalidAmountException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Optional<Subscription> subscription1 = null;

		try {
			subscription1 = service2.getSubscriptionById("s0001");
			System.out.println(subscription1.get());
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidAmountException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		

		Optional<List<Subscription>> optional;
		try {
			optional = service2.getAllSubscriptions();
			if (optional.isEmpty()) {
				System.out.println("there are no records");
			} else {
				optional.get().forEach(e -> System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidAmountException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//
//		
//
		try {
			service2.deleteSubscription("s0003");
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}


		
		applicationContext.close();

	}

}