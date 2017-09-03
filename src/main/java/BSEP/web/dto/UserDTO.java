package BSEP.web.dto;

import java.util.Set;

import BSEP.beans.User;

public class UserDTO {

	private int id;
	private String username;
	private String password;
	private String repeated_password; // samo za registraciju
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private LocationDTO locationDTO; 
	private ImageDTO imageDTO;
	private RoleDTO roleDTO;
	private StatusDTO statusDTO;
	private Boolean blocked;
	private Set<SnippetDTO> snippetsDTO;
	private Set<TeamDTO> leaderTeamsDTO;
	private Set<TeamDTO> teamsDTO;
	
	
	public UserDTO() {
		
	}

	public UserDTO(User user) {
		id = user.getId();
		username = user.getUsername();
		password = user.getPassword();
		name = user.getName();
		surname = user.getSurname();
		email = user.getEmail();
		roleDTO = new RoleDTO(user.getRole());
		blocked = user.getBlocked();
		if(user.getPhoneNumber() != null) { phoneNumber = user.getPhoneNumber(); } else { phoneNumber = "0"; };
		if(user.getLocation() != null) { locationDTO = new LocationDTO(user.getLocation()); } else { locationDTO = new LocationDTO(); }
		if(user.getImage() != null) { imageDTO = new ImageDTO(user.getImage()); } else { imageDTO = new ImageDTO(); }
		if(user.getStatus() != null) { statusDTO = new StatusDTO(user.getStatus()); } else { statusDTO = new StatusDTO(); }
		if(user.getBlocked() != null) { blocked = user.getBlocked(); } else { blocked = false; }
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeated_password() {
		return repeated_password;
	}

	public void setRepeated_password(String repeated_password) {
		this.repeated_password = repeated_password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

	public ImageDTO getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(ImageDTO imageDTO) {
		this.imageDTO = imageDTO;
	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}

	public StatusDTO getStatusDTO() {
		return statusDTO;
	}

	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Set<SnippetDTO> getSnippetsDTO() {
		return snippetsDTO;
	}

	public void setSnippetsDTO(Set<SnippetDTO> snippetsDTO) {
		this.snippetsDTO = snippetsDTO;
	}

	public Set<TeamDTO> getLeaderTeamsDTO() {
		return leaderTeamsDTO;
	}

	public void setLeaderTeamsDTO(Set<TeamDTO> leaderTeamsDTO) {
		this.leaderTeamsDTO = leaderTeamsDTO;
	}

	public Set<TeamDTO> getTeamsDTO() {
		return teamsDTO;
	}

	public void setTeamsDTO(Set<TeamDTO> teamsDTO) {
		this.teamsDTO = teamsDTO;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", repeated_password="
				+ repeated_password + ", name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", locationDTO=" + locationDTO + ", imageDTO=" + imageDTO + ", roleDTO="
				+ roleDTO + ", statusDTO=" + statusDTO + ", blocked=" + blocked + ", snippetsDTO=" + snippetsDTO + "]";
	}

	
	
	

}