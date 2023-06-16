package com.br.cw.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
        public interface CreateUser{}
        public interface UpdateUser{}
        public static final String TABLE_NAME = "user";

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY )
        @Column(name = "id", unique = true)
        private Long id;

        @Column(name = "username", length = 40, nullable = false, unique = true)
        @NotBlank(groups = {CreateUser.class, UpdateUser.class})
        @Size(groups = {CreateUser.class, UpdateUser.class}, min = 7, max = 40)
        private String username;

        @Column(name = "password", length = 40, nullable = false)
        @NotBlank@NotBlank(groups = {CreateUser.class, UpdateUser.class})
        @Size(groups = {CreateUser.class, UpdateUser.class}, min = 7, max = 40)
        private String password;

        public User (){
        }

        public  User(Long id, String username, String password) {
                this.id = id;
                this.username = username;
                this.password = password;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                User user = (User) obj;
                return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, username, password);
        }
}
