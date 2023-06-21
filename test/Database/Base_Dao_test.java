package Database;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class Base_Dao_test {
    static Base_Dao base_dao;

    @Test
    public void getConnection() {
        base_dao= new Base_Dao();
        assertNotNull(base_dao.connection);
    }
}
