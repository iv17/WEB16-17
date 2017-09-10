package BSEP;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import BSEP.beans.Access;
import BSEP.beans.Attachment;
import BSEP.beans.AttachmentType;
import BSEP.beans.Authority;
import BSEP.beans.Comment;
import BSEP.beans.Image;
import BSEP.beans.Language;
import BSEP.beans.Location;
import BSEP.beans.Rating;
import BSEP.beans.Role;
import BSEP.beans.Snippet;
import BSEP.beans.Status;
import BSEP.beans.User;
import BSEP.beans.UserAuthority;
import BSEP.beans.Visibility;

import BSEP.repository.AccessRepository;
import BSEP.repository.AttachmentRepository;
import BSEP.repository.AttachmentTypeRepository;
import BSEP.repository.AuthorityRepository;
import BSEP.repository.CommentRepository;
import BSEP.repository.ConversationRepository;
import BSEP.repository.ImageRepository;
import BSEP.repository.LanguageRepository;
import BSEP.repository.LocationRepository;
import BSEP.repository.PrivateConversationRepository;
import BSEP.repository.PrivateMessageRepository;
import BSEP.repository.RatingRepository;
import BSEP.repository.RoleRepository;
import BSEP.repository.SnippetRepository;
import BSEP.repository.StatusRepository;
import BSEP.repository.TeamRepository;
import BSEP.repository.UserAuthorityRepository;
import BSEP.repository.UserRepository;
import BSEP.repository.VisibilityRepository;

@SpringBootApplication
public class BsepApplication implements CommandLineRunner {
	
	@Autowired
	AccessRepository accessRepository;

	@Autowired
	AttachmentRepository attachmentRepository;

	@Autowired
	AttachmentTypeRepository attachmentTypeRepository;

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	CommentRepository commentRepository;

	@Autowired
	ConversationRepository conversationRepository;

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	LanguageRepository languageRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	PrivateMessageRepository privateMessageRepository;

	@Autowired
	PrivateConversationRepository privateConversationRepository;

	@Autowired
	RatingRepository ratingRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	SnippetRepository snippetRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	TeamRepository teamRepository;

	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserAuthorityRepository userAuthorityRepository;
	
	@Autowired
	VisibilityRepository visibilityRepository;

	
	public static void main(String[] args) {

		SpringApplication.run(BsepApplication.class, args);
		
		System.out.println("\n\n\n\t\t\t\t\t***BSEP***");
	}
	
	@Override
	public void run(String... arg0) throws Exception {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Access access1 = new Access("READ");
		accessRepository.save(access1);
		Access access2 = new Access("WRITE");
		accessRepository.save(access2);
		Access access3 = new Access("RW");
		accessRepository.save(access3);

		AttachmentType attachmentType1 = new AttachmentType("DOCUMENT");
		attachmentTypeRepository.save(attachmentType1);
		AttachmentType attachmentType2 = new AttachmentType("LINK");
		attachmentTypeRepository.save(attachmentType2);

		Visibility visibility1 = new Visibility("PRIVATE");
		visibilityRepository.save(visibility1);
		Visibility visibility2 = new Visibility("PUBLIC");
		visibilityRepository.save(visibility2);
		Visibility visibility3 = new Visibility("GROUP");
		visibilityRepository.save(visibility3);
		Visibility visibility4 = new Visibility("SHARED");
		visibilityRepository.save(visibility4);

		Attachment attachment1 = new Attachment("aaa", "...", "aaa".getBytes(), attachmentType1, access1, visibility1);
		attachmentRepository.save(attachment1);

		Language language1 = new Language("UNDEFINED");
		languageRepository.save(language1);
		Language language2 = new Language("C#");
		languageRepository.save(language2);
		Language language3 = new Language("Python");
		languageRepository.save(language3);
		Language language4 = new Language("C++");
		languageRepository.save(language4);
		Language language5 = new Language("JavaScript");
		languageRepository.save(language5);
		Language language6 = new Language("HTML");
		languageRepository.save(language6);
		Language language7 = new Language("XML");
		languageRepository.save(language7);
		Language language8 = new Language("Java");
		languageRepository.save(language8);
		
		Location location1 = new Location(44.8023505, 20.4719586, "Beograd", "Vračar", "Krunska", "11000");
		locationRepository.save(location1);
		Location location2 = new Location(44.8192953, 20.4486969, "Beograd", "Beton hala", "Karađorđeva 2-4", "11000");
		locationRepository.save(location2);
		Location location3 = new Location(44.8213953, 20.4665717, "Beograd", "Dorćol", "Žorža Klemansoa 10", "11000");
		locationRepository.save(location3);
		Location location4 = new Location(44.7970585, 20.4664927, "Beograd", "Vračar", "Bore Stankovića 17", "11000");
		locationRepository.save(location4);
		Location location5 = new Location(44.7888501, 20.4368326, "Beograd", "Senjak", "Andre Nikolića 1", "11000");
		locationRepository.save(location5);
		Location location6 = new Location(44.7664883, 20.4086425, "Beograd", "Julino brdo", "Katarine Bogdanović",
				"11000");
		locationRepository.save(location6);
		Location location7 = new Location(44.773251, 20.4550609, "Beograd", "Dedinje", "Vladimira Gaćinovića 15",
				"11000");
		locationRepository.save(location7);
		Location location8 = new Location(44.7780874, 20.4693926, "Beograd", "Voždovac", "Koste Jovanovića 87",
				"11000");
		locationRepository.save(location8);
		Location location9 = new Location(44.8150947, 20.5048786, "Beograd", "Karaburma", "Patrisa Lumumbe 4", "11000");
		locationRepository.save(location9);
		Location location10 = new Location(44.7823568, 20.4166448, "Beograd", "Banovo Brdo", "Požeška 40", "11000");
		locationRepository.save(location10);

		Image image1 = new Image("guy-1.jpg", "app/images/guy-1.jpg".getBytes(), "image/jpeg");
		imageRepository.save(image1);
		Image image2 = new Image("guy-2.jpg", "app/images/guy-2.jpg".getBytes(), "image/jpeg");
		imageRepository.save(image2);
		Image image3 = new Image("woman-1.jpg", "app/images/woman-1.jpg".getBytes(), "image/jpeg");
		imageRepository.save(image3);
		Image image4 = new Image("woman-2.jpg", "app/images/woman-2.jpg".getBytes(), "image/jpeg");
		imageRepository.save(image4);

		Role role1 = new Role("REGISTRED_USER");
		roleRepository.save(role1);
		Role role2 = new Role("TEAM_MEMBER");
		roleRepository.save(role2);
		Role role3 = new Role("TEAM_LEADER");
		roleRepository.save(role3);
		Role role4 = new Role("ADMIN");
		roleRepository.save(role4);

		Authority authority1 = new Authority("ROLE_ADMIN");
		authorityRepository.save(authority1);
		Authority authority2 = new Authority("ROLE_REG_USER");
		authorityRepository.save(authority2);
		Authority authority3 = new Authority("ROLE_GUEST");
		authorityRepository.save(authority3);
		
		Status status1 = new Status("ONLINE");
		statusRepository.save(status1);
		Status status2 = new Status("OFFLINE");
		statusRepository.save(status2);
		Status status3 = new Status("AT A MEETING");
		statusRepository.save(status3);
		
		
		User user1 = new User("iv17", encoder.encode("nikola99"), "Ivana", "Savin", "068476018", "ivana.unitedforce@gmail.com",
				location1, image3, role1, status1, false);
		userRepository.save(user1);
		UserAuthority userAuthority1 = new UserAuthority(user1, authority2);
		userAuthorityRepository.save(userAuthority1);
		
		User user2 = new User("matthew", encoder.encode("123"), "Matthew", "McConaughey", "065-456-789", "iva17.igodina@gmail.com",
				location1, image2, role1, status1, false);
		userRepository.save(user2);
		User user3 = new User("bradley", encoder.encode("123"), "Bradley", "Cooper", "065-789-123", "iva17.iigodina@gmail.com",
				location1, image3, role1, status1, false);
		userRepository.save(user3);
		User user4 = new User("leonardo", encoder.encode("123"), "Leonardo", "DiCaprio", "063-123-456", "iva17.iiigodina@gmail.com",
				location1, image1, role1, status1, false);
		userRepository.save(user4);
		User user5 = new User("blake", encoder.encode("123"), "Blake", "Lively", "063-456-789", "blake.lively@gmail.com", location1,
				image1, role4, status1, false);
		userRepository.save(user5);
		User user6 = new User("ryan", encoder.encode("123"), "Ryan", "Reynolds", "063-789-123", "ryan.reynolds@gmail.com", location1,
				image1, role1, status1, false);
		userRepository.save(user6);
		User user7 = new User("jessica", encoder.encode("123"), "Jessica", "Alba", "062-123-456", "jessica.alba@gmail.com", location1,
				image1, role4, status1, false);
		userRepository.save(user7);
		User user8 = new User("eva", encoder.encode("123"), "Eva", "Mendes", "062-456-789", "eva.mendes@gmail.com", location1, image1,
				role1, status1, false);
		userRepository.save(user8);
		User user9 = new User("jessica", encoder.encode("123"), "Jessica", "Alba", "062-123-456", "jessica.alba@gmail.com", location1,
				image1, role4, status1, false);
		userRepository.save(user9);
		User user10 = new User("natalie", encoder.encode("123"), "Natalie", "Portman", "062-456-789", "natalie.portman@gmail.com",
				location1, image3, role4, status1, false);
		userRepository.save(user10);
		
		UserAuthority userAuthority10 = new UserAuthority(user10, authority1);
		userAuthorityRepository.save(userAuthority10);

		Snippet snippet1 = new Snippet("mapiranje zahteva u controller-u", 
				"@RequestMapping(\n" + 
				"			method = RequestMethod.GET\n" + 
				"			)", 
				language8, "...", 30, new Date(), false, access1, visibility1, user1);
		snippetRepository.save(snippet1);
		Snippet snippet2 = new Snippet("pozivanje angulara na html-u", 
				"<body ng-app=\"bsepApp\">\n" + 
				"\n" + 
				"	<div ui-view=\"content\"></div>" +
				"</body>",
				language6, "...", 30, new Date(),  false, access1, visibility1, user2);
		snippetRepository.save(snippet2);
		Snippet snippet3 = new Snippet("JavaScript objekat", 
				"var config = {\n" + 
				"      theme: \"admin\",\n" + 
				"      skins: {\n" + 
				"        \"default\": {\n" + 
				"          \"primary-color\": \"#3498db\"\n" + 
				"        }\n" + 
				"      }\n" + 
				"    };",
				language5, "...", 30, new Date(), false, access1, visibility1, user3);
		snippetRepository.save(snippet3);

		
		Comment comment1 = new Comment("Odlican primer!", new Date(), snippet1, user1);
		commentRepository.save(comment1);
		Comment comment2 = new Comment("Pomoglo!", new Date(), snippet1, user3);
		commentRepository.save(comment2);
		Comment comment3 = new Comment("Hvala!", new Date(), snippet1, user4);
		commentRepository.save(comment3);
		Comment comment4 = new Comment("Komentar br. 4!", new Date(), snippet2, user5);
		commentRepository.save(comment4);
		Comment comment5 = new Comment("Neki tamo komentar!", new Date(), snippet2, user6);
		commentRepository.save(comment5);
		Comment comment6 = new Comment("Hvala!", new Date(), snippet3, user7);
		commentRepository.save(comment6);
		
		
		Rating rating1 = new Rating(1, 0, new Date(), comment1, user3);
		ratingRepository.save(rating1);
		Rating rating2 = new Rating(1, 0, new Date(), comment1, user4);
		ratingRepository.save(rating2);
		Rating rating3 = new Rating(1, 0, new Date(), comment1, user5);
		ratingRepository.save(rating3);
		Rating rating4 = new Rating(1, 0, new Date(), comment1, user6);
		ratingRepository.save(rating4);
		Rating rating5 = new Rating(1, 0, new Date(), comment1, user7);
		ratingRepository.save(rating5);
		Rating rating6 = new Rating(0, 1, new Date(), comment1, user8);
		ratingRepository.save(rating6);
		Rating rating7 = new Rating(0, 1, new Date(), comment1, user9);
		ratingRepository.save(rating7);
		
		
		Rating rating8 = new Rating(1, 0, new Date(), comment2, user6);
		ratingRepository.save(rating8);
		Rating rating9 = new Rating(1, 0, new Date(), comment2, user7);
		ratingRepository.save(rating9);
		Rating rating10 = new Rating(0, 1, new Date(), comment2, user8);
		ratingRepository.save(rating10);
		Rating rating11 = new Rating(0, 1, new Date(), comment2, user9);
		ratingRepository.save(rating11);
		
		Rating rating12 = new Rating(1, 0, new Date(), comment3, user6);
		ratingRepository.save(rating12);
		Rating rating13 = new Rating(1, 0, new Date(), comment3, user7);
		ratingRepository.save(rating13);
		Rating rating14 = new Rating(0, 1, new Date(), comment4, user8);
		ratingRepository.save(rating14);
		Rating rating15 = new Rating(0, 1, new Date(), comment5, user9);
		ratingRepository.save(rating15);
		
		
		
	}

}
