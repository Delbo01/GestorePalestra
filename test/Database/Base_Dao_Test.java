package Database;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class Base_Dao_Test {
    static Base_Dao base_dao;

    @Test
    public void getConnection() {
        base_dao= new Base_Dao();
        assertNotNull(base_dao.connection);
    }
}
