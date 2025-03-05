package java_basic_07_IO.kr.or.kosa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

//설계도 : 직렬화 가능한 클래스 (분해와 조립 가능)
@AllArgsConstructor
@Getter
@ToString
public class UserInfo implements Serializable {
    private String name;
    private String pwd;
    private int age;
}
