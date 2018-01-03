import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private boolean completed;
  private LocalDateTime createdAt;
  private int id;
  private int stylistId;

  public Client(String name, int stylistId) {
    this.description = name;
    completed = false;
    createdAt = LocalDateTime.now();
    this.stylistId = stylistId;
  }

  public String getName() {
    return name;
  }

  public boolean isCompleted() {
    return completed;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public int getStylistId() {
    return stylistId;
  }

  public int getId() {
    return id;
  }

  public static List<Client> all() {
    String sql = "SELECT id, name, stylistid FROM client";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO client(name, stylistid) VALUES (:name, :stylistid)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("stylistid", this.stylistId)
      .executeUpdate()
      .getKey();
  }
}

public static Client find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM client where id=:id";
    Client client = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
    return client;
  }
}

public void update(String name) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE client SET name = :name WHERE id = :id";
    con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
