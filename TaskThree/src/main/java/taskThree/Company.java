package taskThree;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Company {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private String founded;
    private ArrayList<Security> securities;

}
