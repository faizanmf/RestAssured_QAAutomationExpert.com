package JSONManipulation.JSONSerializationandDeserializationJacksonAPI.AnnotationinJacksonAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class AnnotationTest {

    @Test
    public void serializationTest() {

        Employee employee = new Employee();
        employee.setFirstName("Vibha");
        employee.setLastName("Singh");
        employee.setAge(30);
        employee.setSalary(75000);
        employee.setDesignation("Manager");
        employee.setContactNumber("+919999988822");
        employee.setEmailId("abc@test.com");
        employee.setMaritalStatus("married");
        employee.setGender("female");

        // Converting a Java class object to a JSON payload as string
        ObjectMapper mapper = new ObjectMapper();

        try {
            String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            System.out.println(employeePrettyJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("########################################");

    }

    @Test
    public void deserializationTest() throws JsonMappingException, JsonProcessingException  {

        String employeeString = "{\r\n"
                + "  \"firstName\" : \"Deserialization\",\r\n"
                + "  \"lastName\" : \"Test\",\r\n"
                + "  \"age\" : 30,\r\n"
                + "  \"salary\" : 75000.0,\r\n"
                + "  \"designation\" : \"Manager\",\r\n"
                + "  \"contactNumber\" : \"+919999988822\",\r\n"
                + "  \"emailId\" : \"abc@test.com\",\r\n"
                + "  \"gender\" : \"female\",\r\n"
                + "  \"maritalStatus\" : \"married\"\r\n"
                + " }";


        // Converting a Java class object to a JSON payload as string
        ObjectMapper mapper = new ObjectMapper();

        Employee employee2 = mapper.readValue(employeeString, Employee.class);
        System.out.println("First Name of employee : " + employee2.getFirstName());
        System.out.println("Last Name of employee : " + employee2.getLastName());
        System.out.println("Age of employee : " + employee2.getAge());
        System.out.println("Salary of employee : " + employee2.getSalary());
        System.out.println("Designation of employee : " + employee2.getDesignation());
        System.out.println("Contact Number of employee : " + employee2.getContactNumber());
        System.out.println("EmailId of employee : " + employee2.getEmailId());
        System.out.println("Marital Status of employee : " + employee2.getMaritalStatus());
        System.out.println("Gender of employee : " + employee2.getGender());

    }
}
