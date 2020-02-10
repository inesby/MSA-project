package model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserBean {

	@Id
    @GeneratedValue
    private int id;
    private String name;
    private int age ;
   

    
    //constructeur par défaut
    public UserBean() {
    }

    //constructeur pour nos tests
    public UserBean(int id, String nom, int age) {
        this.id = id;
        this.name = name;
        this.age = age ;
       
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



	

  
}