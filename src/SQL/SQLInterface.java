package SQL;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 * Created by Conor on 28-Oct-16.
 */
public interface SQLInterface {

    void executeStatement (String SQL, Connection mycon);

}
