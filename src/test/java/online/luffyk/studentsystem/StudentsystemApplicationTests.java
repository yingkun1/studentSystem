package online.luffyk.studentsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentsystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        String str = "123-456-789";
        String[] split = str.split("-");
        for(String value:split){
            System.out.println(value);
        }
    }

}
