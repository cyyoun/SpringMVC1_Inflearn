package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //아래 get, set 메서드와 동일한 기능
public class HelloData {
    private String username;
    private int age;

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
