import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist{
  private String name;
  private int id;

  public Stylist(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static List<Stylist> all() {
    String sql = "SELECT id, name FROM stylist";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public int getId() {
    return id;
  }

   public static Stylist find(int id) {
       try(Connection con = DB.sql2o.open()) {
         String sql = "SELECT * FROM stylist where id=:id";
         Stylist stylist = con.createQuery(sql)
           .addParameter("id", id)
           .executeAndFetchFirst(Stylist.class);
         return stylist;
       }
     }
     public void update(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET name = :name, WHERE id = :id";
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void delete() {
   try(Connection con = DB.sql2o.open()) {
   String sql = "DELETE FROM stylists WHERE id = :id;";
   con.createQuery(sql).addParameter("id", id).executeUpdate();
   }
   try(Connection con = DB.sql2o.open()) {
   String sql = "UPDATE clients SET stylist_id = 0 WHERE stylist_id = :id;";
   con.createQuery(sql).addParameter("id", id).executeUpdate();
   }
 }

   public List<Client> getClient() {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM client where stylistid=:id";
       return con.createQuery(sql)
         .addParameter("id", this.id)
         .executeAndFetch(Client.class);
     }
   }
   public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylist(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

 }
