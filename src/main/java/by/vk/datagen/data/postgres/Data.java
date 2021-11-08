package by.vk.datagen.data.postgres;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Objects;

@Table(schema = "datagen", name = "data")
@Entity
public class Data {

  public Data() {}

  public Data(DataHolder data) {
    this.data = data;
  }

  public Data(Long id, DataHolder data, ZonedDateTime created) {
    this.id = id;
    this.data = data;
    this.created = created;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column(columnDefinition = "jsonb")
  @Type(type = "jsonb")
  public DataHolder data;

  @CreationTimestamp public ZonedDateTime created;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DataHolder getData() {
    return data;
  }

  public void setData(DataHolder data) {
    this.data = data;
  }

  public ZonedDateTime getCreated() {
    return created;
  }

  public void setCreated(ZonedDateTime modified) {
    this.created = modified;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Data data1 = (Data) o;

    if (!Objects.equals(data, data1.data)) return false;
    return Objects.equals(created, data1.created);
  }

  @Override
  public int hashCode() {
    int result = data != null ? data.hashCode() : 0;
    result = 31 * result + (created != null ? created.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Data{" + "id=" + id + ", data=" + data + ", modified=" + created + '}';
  }
}
