import org.sql2o.*;
/*import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

public class DB {
public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon", "abdilatif", "6823");

/*  private static URI dbUri;
    public static Sql2o sql2o;

    Logger logger = LoggerFactory.getLogger(DB.class);

    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://localhost:5432/hair_salon");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }

            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? "abdilatif" : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? "6823" : dbUri.getUserInfo().split(":")[1];

            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {

        }
    }
    */
}
