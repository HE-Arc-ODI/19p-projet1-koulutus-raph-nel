package ch.hearc.odi.koulutus.business;

@Entity
@Table(name = "Session")
public class Session {

  private Integer id;
  private Date startDateTime;
  private Date endDateTime;
  private double price;
  private String room;

  public Session() {
  }

  public Session(Date startDateTime, Date endDateTime, double price, String room) {
    this.startDateTime = startDateTime;
    this.endDateTime = endDateTime;
    this.price = price;
    this.room = room;
  }

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
