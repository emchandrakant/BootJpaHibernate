package com.jdbc;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jdbc.entity.User;
import com.jdbc.repository.UserRepo;

@SpringBootApplication
public class BootJpaHibernateApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(BootJpaHibernateApplication.class, args);
		UserRepo userRepo=context.getBean(UserRepo.class);
		
//		User user=new User(109,"chandru",24,"kada");
//		User obj= userRepo.save(user);
//		System.out.println(obj);
		
//		//crud ops
//		//adding multiple users
//		User user1=new User(110,"chandri",25,"kada");
//		User user2=new User(111,"chandra",26,"kada");
//		List<User> users= List.of(user1, user2);
//		Iterable<User> result= userRepo.saveAll(users);
//		result.forEach(System.out::println);					//Method Referencing
//		//result.forEach(user->System.out.println(user));		//java8
//		
//		// To perform update ops
//		Optional<User> optional=userRepo.findById(110);
//		User user3=optional.get();
//		user3.setCity("pune");
//		User obj1= userRepo.save(user3);
//		System.out.println(obj1);
		
		Iterable<User> itr= userRepo.findAll();
//		Iterator<User> iterable=itr.iterator();					//Iterator
//		while(iterable.hasNext()) {								//
//			System.out.println(iterable.next());				//
//		}														//
		
		itr.forEach(new Consumer<User>() {						//Anonymous class
																//
			@Override											//
			public void accept(User t) {						//
				System.out.println(t);							//
			}													//
		});														//
		
		// Delete ops
		try {
			userRepo.deleteById(109);
			System.out.println("Deleted..");
		} catch (Exception e) {
			System.out.println("No user to deleted with that Id");
		}
		
		//Custom finder methods
		List<User> result2=userRepo.findByCity("kada");
		result2.forEach(e->System.out.println(e));
	
		List<User> result3=userRepo.findByNameAndCity("cs","akada");
		result3.forEach(e->System.out.println(e));
	}															
	
}
