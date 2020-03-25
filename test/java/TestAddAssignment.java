import main.domain.Student;
import main.domain.Tema;
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

public class TestAddAssignment {
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
    public void testAddAssignmentWithInvalidReceivingWeek() throws ValidationException {
        Tema tema = new Tema("1","tema 1", 5,40);
        try {
            this.service.addTema(tema);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignmentWithValidReceivingWeek() {
        Tema tema = new Tema("1","tema 1", 5,3);
        try {
            this.service.addTema(tema);
            assertEquals(this.service.findTema("1"), tema);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}