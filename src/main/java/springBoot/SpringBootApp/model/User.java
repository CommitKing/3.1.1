package springBoot.SpringBootApp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Getter
    @Setter
    @NotNull(message = "Username cannot be null")
    @Size(min = 5, max = 20)
    @Column
    private String username;

    @Setter
    @Getter
    @NotNull(message = "Password cannot be null")
    @Size(min = 5, max = 50)
    @Column
    private String password;

    @Getter
    @Setter
    @NotNull(message = "Email cannot be null")
    @Email
    @Column
    private String email;

    @Getter
    @Setter
    @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Invalid phone number")
    @Column
    private String phoneNumber;

    @Getter
    @Setter
    @NotNull(message = "Age cannot be null")
    @Min(value = 7, message = "Age must be at least 7")
    @Column
    private int age;

    @Getter
    @Setter
    @NotNull(message = "Sex cannot be null")
    @Column
    private String sex;

    public User() {
    }

    public User(String username, String password,
                String email, String phone, int age, String sex) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phone;
        this.age = age;
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", age=" + age + ", sex=" + sex + "]";
    }
}
