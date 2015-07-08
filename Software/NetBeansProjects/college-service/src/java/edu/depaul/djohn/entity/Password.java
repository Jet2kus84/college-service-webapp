package edu.depaul.djohn.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "PASSWORD")
@Table(name="PASSWORD", schema="dbCourse") 
@XmlRootElement
public class Password implements Serializable, edu.depaul.djohn.entity.Entity{

	//type of user; Student, Professor, Advisor
        @Id
        @Column(name = "TYPE_ID", nullable = false) 
	private String type = " ";
        
        @Column(name = "USERNAME", nullable = false) 
        private String username;
        
        @Column(name = "PASSWORD", nullable = false) 
        private String password;
        
        @Transient
        private boolean passwordExcepted = false;
        
        @Transient
        private final String[] activePassword;
        
        public Password() {
            activePassword = new String[2];
        }
        /**
         * 
         * @param _type 
         */
	public void setType(String _type) {
		this.type = _type;
	}
	
        /**
         * 
         * @return 
         */
	public String getType() {
		return type;
	}

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setActivePassword(String username, String password) {
        this.activePassword[0] = username;
        this.activePassword[1] = password;
    }
    
    public String[] getActivePassword() {
        return activePassword;
    }
    
    public void setPasswordExcepted(boolean expected) {
        this.passwordExcepted = expected;
    }
    
    public boolean getPasswordExcepted() {
        return this.passwordExcepted;
    }

    @Override
    public String getId() {
       return type;
    }
}
