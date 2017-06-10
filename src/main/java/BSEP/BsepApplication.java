package BSEP;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import BSEP.beans.Access;
import BSEP.beans.Attachment;
import BSEP.beans.AttachmentType;
import BSEP.beans.Comment;
import BSEP.beans.Image;
import BSEP.beans.Language;
import BSEP.beans.Location;
import BSEP.beans.Message;
import BSEP.beans.PrivateConversation;
import BSEP.beans.PrivateMessage;
import BSEP.beans.Role;
import BSEP.beans.Snippet;
import BSEP.beans.Status;
import BSEP.beans.User;
import BSEP.beans.Visibility;
import BSEP.repository.AccessRepository;
import BSEP.repository.AttachmentRepository;
import BSEP.repository.AttachmentTypeRepository;
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
	
	/*@Autowired
	TeamConversation teamConversation;
	
	@Autowired
	TeamMessageRepository teamMessageRepository;
	*/
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VisibilityRepository visibilityRepository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(BsepApplication.class, args);
		
		System.out.println("\n\n\n\t\t\t\t\t***BSEP***");
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		
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
		
		Language language1 = new Language("Java");
		languageRepository.save(language1);
		Language language2 = new Language("C#");
		languageRepository.save(language2);
		Language language3 = new Language("Python");
		languageRepository.save(language3);
		Language language4 = new Language("C++");
		languageRepository.save(language4);
		
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
		Location location6  = new Location(44.7664883, 20.4086425, "Beograd", "Julino brdo", "Katarine Bogdanović", "11000");
		locationRepository.save(location6);
		Location location7  = new Location(44.773251, 20.4550609, "Beograd", "Dedinje", "Vladimira Gaćinovića 15", "11000");
		locationRepository.save(location7);
		Location location8  = new Location(44.7780874, 20.4693926, "Beograd", "Voždovac", "Koste Jovanovića 87", "11000");
		locationRepository.save(location8);
		Location location9  = new Location(44.8150947, 20.5048786, "Beograd", "Karaburma", "Patrisa Lumumbe 4", "11000");
		locationRepository.save(location9);
		Location location10  = new Location(44.7823568, 20.4166448, "Beograd", "Banovo Brdo", "Požeška 40", "11000");
		locationRepository.save(location10);
		
		
		Image image1 = new Image("...", "...");
		imageRepository.save(image1);
		
		Role role1 = new Role("REGISTRED_USER");
		roleRepository.save(role1);
		Role role2 = new Role("TEAM_MEMBER");
		roleRepository.save(role2);
		Role role3 = new Role("TEAM_LEADER");
		roleRepository.save(role3);
		
		Status status1 = new Status("ONLINE");
		statusRepository.save(status1);
		Status status2 = new Status("OFFLINE");
		statusRepository.save(status2);
		Status status3 = new Status("AT A MEETING");
		statusRepository.save(status3);
		
		
		User user1 = new User("iv17", "nikola99", "Ivana", "Savin", "068476018", "ivana.unitedforce@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user1);
		User user2 = new User("matthew", "123", "Matthew", "McConaughey", "065-456-789", "iva17.igodina@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user2);
		User user3 = new User("bradley", "123", "Bradley", "Cooper",  "065-789-123", "iva17.iigodina@gmail.com",  location1, image1, role1, status1, false);
		userRepository.save(user3);
		User user4 = new User("leonardo", "123", "Leonardo", "DiCaprio", "063-123-456", "iva17.iiigodina@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user4);
		User user5 = new User("blake", "123", "Blake", "Lively", "063-456-789", "blake.lively@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user5);
		User user6 = new User("ryan", "123", "Ryan", "Reynolds", "063-789-123", "ryan.reynolds@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user6);
		User user7 = new User("jessica", "123", "Jessica", "Alba", "062-123-456", "jessica.alba@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user7);
		User user8 = new User("eva", "123", "Eva", "Mendes", "062-456-789", "eva.mendes@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user8);
		User user9 = new User("jessica", "123", "Jessica", "Alba", "062-123-456", "jessica.alba@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user9);
		User user10 = new User("natalie", "123", "Natalie", "Portman", "062-456-789", "natalie.portman@gmail.com", location1, image1, role1, status1, false);
		userRepository.save(user10);
		
		
		Snippet snippet1 = new Snippet("...", "...".getBytes(), language1, "...", 1, false, access1, visibility1, user1);
		snippetRepository.save(snippet1);
		Snippet snippet2 = new Snippet("...", "...".getBytes(), language1, "...", 1, false, access1, visibility1, user1);
		snippetRepository.save(snippet2);
		Snippet snippet3 = new Snippet("...", "...".getBytes(), language1, "...", 1, false, access1, visibility1, user1);
		snippetRepository.save(snippet3);
		
		Comment comment1 = new Comment("...", new Date(), snippet1, user2);	
		commentRepository.save(comment1);
		Comment comment2 = new Comment("...", new Date(), snippet1, user3);	
		commentRepository.save(comment2);
		Comment comment3 = new Comment("...", new Date(), snippet1, user4);	
		commentRepository.save(comment3);
		
		
		Message message1 = new Message("aaa", new Date());
		Message message2 = new Message("bbb", new Date());
		Message message3 = new Message("ccc", new Date());
		Message message4 = new Message("ddd", new Date());
		PrivateMessage privateMessage1 = new PrivateMessage(message1, user1, user2);
		privateMessageRepository.save(privateMessage1);
		PrivateMessage privateMessage2 = new PrivateMessage(message2, user2, user1);
		privateMessageRepository.save(privateMessage2);
		PrivateMessage privateMessage3 = new PrivateMessage(message3, user1, user2);
		privateMessageRepository.save(privateMessage3);
		PrivateMessage privateMessage4 = new PrivateMessage(message4, user2, user1);
		privateMessageRepository.save(privateMessage4);
		
		Set<PrivateMessage> privateMessages1 = new HashSet<>();
		privateMessages1.add(privateMessage1);
		privateMessages1.add(privateMessage2);
		privateMessages1.add(privateMessage3);
		privateMessages1.add(privateMessage4);
		PrivateConversation privateConversation1 = new PrivateConversation(user1, user2);
		privateConversationRepository.save(privateConversation1);
		
		
		Set<User> members1 = new HashSet<>();
		members1.add(user2);
		members1.add(user3);
		members1.add(user4);
		
		
	}
}
