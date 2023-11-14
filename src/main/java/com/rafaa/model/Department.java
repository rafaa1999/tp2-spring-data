package com.rafaa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String title;
   @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
   List<Material> materials;
   @Override
   public String toString() {
      return "Department{" +
              "id=" + id +
              ", title='" + title + '\'' +
              '}';
   }
}
