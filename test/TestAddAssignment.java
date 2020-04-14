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
    private TemaXMLRepo temaRepo;
    private Service service;

    @Before
    public void setup() {
        this.studentValidator = new StudentValidator();
        this.temaValidator = new TemaValidator();
        this.temaRepo = new TemaXMLRepo("Teme.xml");
        this.studentRepository = new StudentXMLRepo("Studenti.xml");
        this.service = new Service(studentRepository,studentValidator,temaRepo,temaValidator,notaRepository,notaValidator);
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
        Tema tema = new Tema("20","tema 1", 5,3);
        try {
            this.service.addTema(tema);
            assertEquals(this.service.findTema("20").getPrimire(), tema.getPrimire());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignmentWithWithNULLid() {
        Tema tema = new Tema(null,"tema 1", 5,3);
        try {
            this.service.addTema(tema);
         } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignmentWithWithEmptyid() {
        Tema tema = new Tema("","tema 1", 5,3);
        try {
            this.service.addTema(tema);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignmentWithWithEmptyDescription() {
        Tema tema = new Tema("40","", 5,3);
        try {
            this.service.addTema(tema);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddAssignmentWithWithInvalidDeadline() {
        Tema tema = new Tema("50","tema 1", 50,3);
        try {
            this.service.addTema(tema);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void testAddExistingAssignment() {
        Tema tema = new Tema("20","descriere", 4,3);
        assertNotEquals(tema.getDescriere(),this.service.findTema("20").getDescriere());
    }
}