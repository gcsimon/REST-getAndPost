package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Todos {

    private String title;
	private Boolean completed;
	private int userId;
	private int id;


    public Todos() {
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }
	
	public Boolean getcompleted() {
        return completed;
    }

    public void setcompleted(Boolean completed) {
        this.completed = completed;
    }
	
	public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
	
	public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }	
	

    @Override
    public String toString() {
        return "{" +
                "'userId='" + userId + '\'' +
                ", id=" + id + '\'' +
				", title=" + title + '\'' +
				", completed=" + completed + '\'' +
                '}';
    }
}

