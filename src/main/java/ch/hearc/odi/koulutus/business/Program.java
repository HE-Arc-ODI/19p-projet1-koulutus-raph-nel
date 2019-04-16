package ch.hearc.odi.koulutus.business;

import java.util.List;

@Entity
@Table(name = "Program")
public class Program {

  private Integer id;
  private String name;
  private String richDescritpion;
  private String field;
  private Integer price;
  private List<Course> cources;

  public Program() {
  }

  public Program(String name, String richDescritpion, String field, Integer price,
      List<Course> cources) {
    this.name = name;
    this.richDescritpion = richDescritpion;
    this.field = field;
    this.price = price;
    this.cources = cources;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRichDescritpion() {
    return richDescritpion;
  }

  public void setRichDescritpion(String richDescritpion) {
    this.richDescritpion = richDescritpion;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public List<Course> getCources() {
    return cources;
  }

  public void setCources(List<Course> cources) {
    this.cources = cources;
  }
}
