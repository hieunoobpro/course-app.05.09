package vn.techmaster.course.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String avatar;

    public User(Integer id, String name, String email, String phone, String avatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
    }
}
