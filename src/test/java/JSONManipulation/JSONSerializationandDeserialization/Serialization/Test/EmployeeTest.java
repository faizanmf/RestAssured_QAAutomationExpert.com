package JSONManipulation.JSONSerializationandDeserialization.Serialization.Test;

import JSONManipulation.JSONSerializationandDeserialization.Serialization.POJOClass.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void serializationTest() {

        Employee employee = new Employee();
        employee.setFirstName("faizan");
        employee.setLastName("mf");
        employee.setAge(30);
        employee.setSalary(75000);
        employee.setDesignation("QA");

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert to compact JSON
            String employeeJson = mapper.writeValueAsString(employee);

            // Convert to pretty-printed JSON
            String employeePrettyJson =
                    mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

            System.out.println(employeeJson);
            System.out.println(employeePrettyJson);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
