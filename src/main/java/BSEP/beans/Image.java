package BSEP.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "image")
public class Image implements Serializable {

	
	private static final long serialVersionUID = 7619395521364674488L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;	
	
	@Column(name = "name", unique = false, nullable = true)
	private String name;
	
	@Column(name = "file", unique = false, nullable = true, columnDefinition = "LONGTEXT")
	private byte [] file;
	
	@Column(name = "mimeType", unique = false, nullable = true)
	private String mimeType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "image") @JsonIgnore
	Set<User> users;


	public Image() {
		
	}

	public Image(String name, byte [] file) {
		this.name = name;
		this.file = file;
	}

	public Image(String name, byte [] file, String mimeType) {
		this.name = name;
		this.file = file;
		this.mimeType = mimeType;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Image [name=" + name + ", file=" + new String(file) + ", mimeType=" + mimeType + "]";
	}
	
	
}
