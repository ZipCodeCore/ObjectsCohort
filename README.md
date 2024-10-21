# ObjectsCohort

a simple app to describe what coding looks like.
adds a cohort class.

Build a Swing JFrame based Table UI in java. KISS.

### // what do we need to do?

- Using a Person object.
- Create a simple Frame/Table interface.
- Add the ability to use Person object
- Add Cohort class
- Add the ability to write a `cohortdata.json` file.



Start with Person class

- name
- birthdayDay
- birthdayMonth
- favoriteColor 
- leftHandedWriter
- rightHandedWriter
- canDoVulcanGreeting
- numberOfPets

need a list of the field names

```java
    String[] fieldNames = { "Name", "BirthDay",
        "BirthdayMonth", "FavoriteColor",
        "LeftHandedWriter", "RightHandedWriter",
        "CanDoVulcanGreeting", "NumberOfPets" };
```

Cohort class

- studentData
- listOfStudents (arraylist)
- addStudent

```java
import java.util.ArrayList;
// higher level *abstraction* for a list
// of students of class Person
class Cohort { 
    ArrayList<Person> studentData = new ArrayList<>();
    
    public void addStudent(Person student) {
        this.studentData.add(student);
    }
    public ArrayList<Person> listOfStudents() {
        return studentData;
    }
}

```

A Simple table 

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SimpleTableExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Table");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create a table model
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Name");
            model.addColumn("Age");

            // Add some data to the model
            model.addRow(new Object[]{"John", 20});
            model.addRow(new Object[]{"Mary", 25});
            model.addRow(new Object[]{"Bob", 30});

            // Create a table using the model
            JTable table = new JTable(model);

            // Add the table to a scroll pane
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);

            // Set frame size and make it visible
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
```
```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.*;
import java.io.FileWriter;
import java.io.IOException;

public class JTableToJsonExample {

    public static void main(String[] args) {
        // Create a simple JTable
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Age");
        model.addRow(new Object[]{"Alice", 25});
        model.addRow(new Object[]{"Bob", 30});

        JTable table = new JTable(model);

        // Convert JTable data to JSON
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < model.getRowCount(); i++) {
            JSONObject jsonObject = new JSONObject();
            for (int j = 0; j < model.getColumnCount(); j++) {
                jsonObject.put(model.getColumnName(j), model.getValueAt(i, j));
            }
            jsonArray.put(jsonObject);
        }

        // Save JSON to file
        try (FileWriter file = new FileWriter("cohort-data.json")) {
            file.write(jsonArray.toString(4));
            System.out.println("JTable data saved to table_data.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```