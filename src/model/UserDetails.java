package model;


import dao.UserDetailsDAOText;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * <p>
 * Title: Misc</p>
 * <p>
 * Description: </p>
 * <p>
 * Copyright: Copyright (c) 2006</p>
 * <p>
 * Company: TAFE SA</p>
 *
 * @author Santi Ruiz
 * @author Julie Ruiz 
 * @version 2.0
 * @author ADD YOUR NAME HERE
 */
public class UserDetails implements Serializable {

    //TODO add your code as in the signed-off Project Requirements document
    
    
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
