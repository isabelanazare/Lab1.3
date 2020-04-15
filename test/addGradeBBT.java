import main.domain.Student;
import main.domain.Tema;
import main.domain.Nota;
import main.repository.*;
import main.service.*;
import main.validation.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Map;

public class addGradeBBT {
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
        this.studentValidator = new StudentValidator();
        this.temaValidator = new TemaValidator();
        this.temaRepo = new TemaXMLRepo("Teme.xml");
        this.studentRepository = new StudentXMLRepo("Studenti.xml");
        this.notaValidator = new NotaValidator(this.studentRepository, this.temaRepo);
        this.service = new Service(studentRepository,studentValidator,temaRepo,temaValidator,notaRepository,notaValidator);
    }

    @Test
    public void testAddGradeWithInvalidValue() throws ValidationException {
        LocalDate inputDate = LocalDate.of(2020,10,10);

        Nota nota = new Nota("100","23","2", 320,inputDate);
        try {
            this.service.addNota(nota,"great");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

}