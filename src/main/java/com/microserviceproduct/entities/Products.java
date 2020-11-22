package com.microserviceproduct.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
public class Products implements Serializable {

    private static final long serialVersionUID=1285454306356845809L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String name;
    Double price;

    @Transient
    Integer portServer;//al anotarse una variable con este decorador simplemente se especifica
                       //que dicho atributo no esta mapeado a ninguna base de datos , sino que es mera
                        //,emte para informacion

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    Date dateCreated;

    public Long getId() {  return id; }
    public void setId(Long id) {  this.id = id; }

    public String getName() {  return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) {   this.price = price; }

    public Date getDateCreated() { return dateCreated;}
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public Integer getPortServer() { return portServer;}
    public void setPortServer(Integer portServer) {  this.portServer = portServer; }
}
