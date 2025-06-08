package com.biapay.core.model;

import com.biapay.core.model.views.UserView;
import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_loyalty_group")
@JsonView(UserView.SearchView.class)
public class UserLoyaltyGroup extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "user_loyalty_group_mapping",
      joinColumns = @JoinColumn(name = "user_loyalty_group_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  @JsonView(UserView.SearchView.class)
  private List<User> users;
}
