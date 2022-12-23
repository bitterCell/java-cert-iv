package model;

import dao.GameSettingsDAOText;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * <p>
 * Title: Misc</p>
 * <p>
 * Description: </p>
 * <p>
 * Copyright: Copyright (c) 2005</p>
 * <p>
 * Company: TAFE SA</p>
 *
 * @author Santi Ruiz
 * @author Julie Ruiz
 * @author ADD YOUR NAME HERE
 * @version 1.0
 */
public class GameSettings implements Serializable {

//TODO add your code as in the signed-off Project Requirements document    
    
    
    
 
    public void saveData(UserDetails user) throws Exception {
        GameSettingsDAOText.saveData(user, this);
    }

    public void loadData(UserDetails user) throws Exception {
        GameSettingsDAOText.loadData(user, this);
    }
}
