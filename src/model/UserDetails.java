package model;


import dao.UserDetailsDAOText;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * <p>
 * Title: UserDetails</p>
 * <p>
 * Description: This describes a user that can log into the game. A user has a user name and password, and an option to
 * turn the tutorial on or off.</p>
 * <p>
 * Copyright: Copyright (c) 2006</p>
 * <p>
 * Company: TAFE SA</p>
 *
 * @author Santi Ruiz
 * @author Julie Ruiz 
 * @version 2.0
 * @author Amos Chamberlain
 */
public class UserDetails implements Serializable {
    public static final String DEFAULT_USERNAME = "NO NAME";
    public static final String DEFAULT_PASSWORD = null;
    public static final boolean DEFAULT_INFO = true;
    
    /**
     * The players user name
     */
    private String userName;
    /**
     * The players password
     */
    private String password;
    /**
     * If the game shows the player the information or not
     */
    private boolean wantingIntroInfo;

    /*
     * ************************* constructors *********************************
     */
    public UserDetails() {
        this(DEFAULT_USERNAME, DEFAULT_PASSWORD, DEFAULT_INFO);
    }
    
    /**
     * Construct a user based on a user name, password, and if the player wants the introduction information.
     * @param userName String
     * @param password String
     * @param wantingIntroInfo boolean
     */
    public UserDetails(String userName, String password, boolean wantingIntroInfo) {
        this.userName = userName;
        this.password = password;
        this.wantingIntroInfo = wantingIntroInfo;
    }

    /**
     * Construct a user based on a user name and password.
     * @param userName String
     * @param password String
     */
    public UserDetails(String userName, String password) {
        this(userName, password, DEFAULT_INFO);
    }

    /**
     * Construct a user based on a user name.
     * @param userName String
     */
    public UserDetails(String userName) {
        this(userName, DEFAULT_PASSWORD, DEFAULT_INFO);
    }
    
    /**
     * Get the user name of the user.
     * @return userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * Set the user name of the user.
     * @param userName String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Get the user's password.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Get the users intro information preference.
     * @return wantingIntroInfo
     */
    public boolean isWantingIntroInfo() {
        return wantingIntroInfo;
    }

    /**
     * Set the users intro information preference
     * @param wantingIntroInfo boolean
     */
    public void setWantingIntroInfo(boolean wantingIntroInfo) {
        this.wantingIntroInfo = wantingIntroInfo;
    }
    
    /*
     * ************************* Usual Overrides*******************************
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserDetails)) {
            return false;
        }
        
        UserDetails userDetails = (UserDetails) o;
        return userDetails.getUserName().equals(this.getUserName());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" = [userName:");
        sb.append(this.userName);
        sb.append(", password:");
        sb.append(this.password);
        sb.append(", wantingIntroInfo:");
        sb.append(this.wantingIntroInfo);
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * saveData
     *
     * @param user UserDetails
     * @param con Connection
     * @throws SQLException
     */
    public void saveData() throws Exception {
        UserDetailsDAOText.saveData(this);
    }

    /**
     * loadData
     *
     * @param con Connection
     * @throws SQLException
     */
    public void loadData() throws Exception {
        UserDetailsDAOText.loadData(this);
    }

}
