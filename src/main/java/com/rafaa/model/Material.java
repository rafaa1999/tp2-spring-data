package com.rafaa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Material {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   private String title;
   private String type;
   private Integer num_series;
   private Integer qte;
   private String state;
   @ManyToOne
   @JoinColumn(name = "id_dep")
   private Department department;
   @Override
   public String toString() {
      return "Material{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", type='" + type + '\'' +
              ", num_series=" + num_series +
              ", qte=" + qte +
              ", state='" + state + '\'' +
              '}';
   }
}
