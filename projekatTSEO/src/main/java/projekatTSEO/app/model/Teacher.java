package projekatTSEO.app.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Teacher extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String lastname;
	
	@ManyToMany(mappedBy = "teachers")
	private Set<Course> courses = new HashSet<Course>();

	private Title title;

	
	
	public Teacher(Long id, String name, String lastname, Set<Course> courses, Title title) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.courses = courses;
		this.title = title;
	}

	public Teacher() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Title getTitle() {
		return title;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Teacher t = (Teacher) o;
        if(t.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, t.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
	
	
	

}
