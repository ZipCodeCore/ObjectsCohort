import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testGetName() {
        String testName = "Joe";
        Person p = new Person(testName, 5);

        assertEquals(p.getName(), testName);
    }

    @Test
    void testSetName() {
        String testName = "Joe";
        Person p = new Person("foo", 5);

        p.setName(testName); //change to see failure...

        assertEquals(p.getName(), testName);
    }
}