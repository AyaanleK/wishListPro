package com.kea.projectwishlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

  @Entity
  @Table(name = "pro_details")
  @Data
  @AllArgsConstructor
  @NoArgsConstructor

  public class Wishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String myWishes;
    private String phoneNumber;


  }
