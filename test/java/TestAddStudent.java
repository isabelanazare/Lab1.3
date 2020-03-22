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
        Student student = new Student("1", "Diana", 935, "diana@gmail.com");
        this.service.addStudent(student);
        assertEquals(this.service.findStudent("1"), student);
    }

    @Test
    public void testAddStudentWithInvalidGroupNumber() {
        Student student = new Student("1", "Diana", 3, "diana@gmail.com");
        try {
            this.service.addStudent(student);
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }
}