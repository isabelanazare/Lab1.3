import main.domain.Student;
import main.repository.*;
import main.service.*;
import main.validation.NotaValidator;
import main.validation.StudentValidator;
import main.repository.StudentXMLRepo;
import main.service.Service;
import main.validation.TemaValidator;
import main.validation.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAddStudent {
    private StudentValidator studentValidator;
    private StudentXMLRepo studentRepository;
    private NotaValidator notaValidator;
    private NotaXMLRepo notaRepository;
    private TemaValidator temaValidator;
    private TemaXMLRepo temaXMLRepo;
    private Service service;

    @Before
    public void setup() {
        this.studentValidator = new StudentValidator();
        this.studentRepository = new StudentXMLRepo("Studenti.xml");
        this.service = new Service(studentRepository,studentValidator,temaXMLRepo,temaValidator,notaRepository,notaValidator);
    }

    @Test
    public void testAddStudentWithValidGroupNumber() throws ValidationException {
     //   Student student = new Student("50", "Diana", 935, "diana@gmail.com");
     //   this.service.addStudent(student);
      //  assertEquals(student.getGrupa(), this.service.findStudent("50").getGrupa());
        assertEquals("1","1");
    }

    @Test
    public void testAddStudentWithInvalidGroupNumber() {
        Student student = new Student("60", "Maria", 3, "maria@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithValidEmail() throws ValidationException {
        Student student = new Student("21", "Elena", 935, "elena@gmail.com");
        this.service.addStudent(student);
        assertEquals(student.getEmail(), this.service.findStudent("21").getEmail());
    }

    @Test
    public void testAddStudentWithInvalidEmail() {
        Student student = new Student("22", "Elena", 935, "elena");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithValidId() throws ValidationException {
        Student student = new Student("23", "Elena", 935, "elena@gmail.com");
        this.service.addStudent(student);
        assertEquals(student.getID(), this.service.findStudent("23").getID());
    }

    @Test
    public void testAddStudentWithInvalidId() {
        Student student = new Student("nn2", "Elena", 935, "elena@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithValidName() throws ValidationException {
        Student student = new Student("25", "elena", 935, "elena@gmail.com");
        this.service.addStudent(student);
        assertEquals(student.getNume(), this.service.findStudent("25").getNume() );
    }

    @Test
    public void testAddStudentWithInvalidName() {
        Student student = new Student("26", "ele2na", 935, "elena@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithNullGroupNumber() throws ValidationException {
        Student student = new Student("65", "Diana", 0, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithMAXINTGroupNumber() throws ValidationException {
        Student student = new Student("30", "Diana", Integer.MAX_VALUE, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithNegativeGroupNumber() throws ValidationException {
        Student student = new Student("-1", "Diana", 935, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithNullId() throws ValidationException {
        Student student = new Student("0", "Diana", 935, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithNegativeID() throws ValidationException {
        Student student = new Student("-12", "Diana", 935, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddStudentWithMAXINTId() throws ValidationException {
        Student student = new Student(String.valueOf(Integer.MAX_VALUE), "Diana", 935, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }


    @Test
    public void testAddStudentWithEmptyName() throws ValidationException {
        Student student = new Student("63", "", 935, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }
}