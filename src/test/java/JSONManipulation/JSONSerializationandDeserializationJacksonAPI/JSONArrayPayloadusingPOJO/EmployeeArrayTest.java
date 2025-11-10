package JSONManipulation.JSONSerializationandDeserializationJacksonAPI.JSONArrayPayloadusingPOJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayTest {

    @Test
    public void createEmployeeArray() {
        Employee emp1 = new Employee();
        emp1.setFirstName("Vibha");
        emp1.setLastName("Singh");
        emp1.setAge(30);
        emp1.setSalary(75000);
        emp1.setDesignation("Manager");
        emp1.setContactNumber("+919999988822");
        emp1.setEmailId("abc@test.com");

        Employee emp2 = new Employee();
        emp2.setFirstName("Neha");
        emp2.setLastName("Verms");
        emp2.setAge(35);
        emp2.setSalary(60000);
        emp2.setDesignation("Lead");
        emp2.setContactNumber("+914442266221");
        emp2.setEmailId("xyz@test.com");

        Employee emp3 = new Employee();
        emp3.setFirstName("Rajesh");
        emp3.setLastName("Gupta");
        emp3.setAge(20);
        emp3.setSalary(40000);
        emp3.setDesignation("Intern");
        emp3.setContactNumber("+919933384422");
        emp3.setEmailId("pqr@test.com");

        // Creating a List of Employees
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        // Converting a Java class object to a JSON Array Payload as string
        ObjectMapper mapper = new ObjectMapper();
        try {
            String allEmployeeJson = mapper.writeValueAsString(employeeList);
            String employeeListPrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);
            System.out.println(allEmployeeJson);
            System.out.println(employeeListPrettyJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getEmployeeArray() {

        Employee emp1 = new Employee();
        emp1.setFirstName("Vibha");
        emp1.setLastName("Singh");
        emp1.setAge(30);
        emp1.setSalary(75000);
        emp1.setDesignation("Manager");
        emp1.setContactNumber("+919999988822");
        emp1.setEmailId("abc@test.com");

        Employee emp2 = new Employee();
        emp2.setFirstName("Neha");
        emp2.setLastName("Verms");
        emp2.setAge(35);
        emp2.setSalary(60000);
        emp2.setDesignation("Lead");
        emp2.setContactNumber("+914442266221");
        emp2.setEmailId("xyz@test.com");

        Employee emp3 = new Employee();
        emp3.setFirstName("Rajesh");
        emp3.setLastName("Gupta");
        emp3.setAge(20);
        emp3.setSalary(40000);
        emp3.setDesignation("Intern");
        emp3.setContactNumber("+919933384422");
        emp3.setEmailId("pqr@test.com");

        // Creating a List of Employees
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        // Converting a Java class object to a JSON Array Payload as string

        ObjectMapper mapper = new ObjectMapper();
        String allEmployeeJson = null;

        try {
            allEmployeeJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<Employee> allEmployeeDetails = null;
        try {
            allEmployeeDetails = mapper.readValue(allEmployeeJson, new TypeReference<List<Employee>>() {
            });
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (Employee emp : allEmployeeDetails) {

            System.out.println("===================================");

            System.out.println("First Name of employee : " + emp.getFirstName());
            System.out.println("Last Name of employee : " + emp.getLastName());
            System.out.println("Age of employee : " + emp.getAge());
            System.out.println("Salary of employee : " + emp.getSalary());
            System.out.println("Designation of employee : " + emp.getDesignation());
            System.out.println("Contact Number of employee : " + emp.getContactNumber());
            System.out.println("EmailId of employee : " + emp.getEmailId());
        }
    }

    @Test
    public void readArrayJsonFromFile() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Converting Employee json string to Employee class object
        List<Employee> allEmployeeDetails = null;
        try {
            allEmployeeDetails = mapper.readValue(new File(
                            "src/test/resources/JsonManipulation/EmployeeList.json"),
                    new TypeReference<List<Employee>>() {
                    });
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Employee emp : allEmployeeDetails) {

            System.out.println("######################################");

            System.out.println("First Name of employee : " + emp.getFirstName());
            System.out.println("Last Name of employee : " + emp.getLastName());
            System.out.println("Age of employee : " + emp.getAge());
            System.out.println("Salary of employee : " + emp.getSalary());
            System.out.println("Designation of employee : " + emp.getDesignation());
            System.out.println("Contact Number of employee : " + emp.getContactNumber());
            System.out.println("EmailId of employee : " + emp.getEmailId());
        }
    }
}

