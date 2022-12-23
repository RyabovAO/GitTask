package taskThree;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import java.util.ArrayList;

@Data
@JsonAutoDetect
public class Root {

    @JsonDeserialize
    private ArrayList<Company> companies;

}
