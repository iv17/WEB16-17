package BSEP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import BSEP.beans.Image;
import BSEP.beans.Location;
import BSEP.beans.Role;
import BSEP.beans.Status;
import BSEP.beans.User;
import BSEP.repository.ImageRepository;
import BSEP.repository.LocationRepository;
import BSEP.repository.RoleRepository;
import BSEP.repository.StatusRepository;
import BSEP.repository.UserRepository;

@SpringBootApplication
public class BsepApplication implements CommandLineRunner {

	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(BsepApplication.class, args);
		
		System.out.println("\n\n\n\t\t\t\t\t***BSEP***");
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Location location1 = new Location();
		locationRepository.save(location1);
		
		Image image1 = new Image();
		imageRepository.save(image1);
		
		Role role1 = new Role();
		roleRepository.save(role1);
		
		Status status1 = new Status();
		statusRepository.save(status1);
		
		
		User user1 = new User("iv17", "nikola99", "Ivana", "Savin", "068476018", "ivana.unitedforce@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user1);
		
	}
}
