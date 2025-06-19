package deel_automation.tests;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        // Create TestNG instance
        TestNG testng = new TestNG();
        
        // Create listener adapter
        TestListenerAdapter tla = new TestListenerAdapter();
        
        // Define test classes to run
        List<Class<?>> testClasses = new ArrayList<>();
        testClasses.add(deel_automation.tests.SalaryInsightTests.class);
        // Add more test classes as needed
        
        // Configure TestNG
        testng.setTestClasses(testClasses.toArray(new Class[0]));
        testng.setOutputDirectory("test-output"); // Set report directory
        
        // Run tests
        testng.run();
        
        // Print status
        System.out.println("Tests run: " + tla.getPassedTests().size() + " passed, " + 
                         tla.getFailedTests().size() + " failed");
    }
}