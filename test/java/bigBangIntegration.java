package java;

import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Service.ServiceStudent;
import Service.ServiceNote;
import Service.ServiceTeme;
import Validator.TemeValidator;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Domain.Teme;
import Domain.Nota;
import Domain.Student;
import Validator.ValidationException;
import org.junit.Before;
import org.junit.Test;
import java.util.AbstractMap;
import java.util.Map;

public class bigBangIntegration {

    private StudentValidator studentValidator;
    private StudentRepo studentRepository;
    private NotaValidator notaValidator;
    private NoteRepo notaRepository;
    private TemeValidator temaValidator;
    private TemeRepo temaRepository;
    private ServiceStudent serviceStudent;
    private ServiceTeme serviceTeme;
    private ServiceNote serviceNote;

    @Before
    public void setup() {
        this.studentValidator = new StudentValidator();
        this.temaValidator = new TemeValidator();
        this.notaValidator = new NotaValidator();
        this.temaRepository = new TemeRepo(temaValidator, "D:\\uni\\vvss\\Lab4\\teme.xml");
        this.studentRepository = new StudentRepo(studentValidator, "D:\\uni\\vvss\\Lab4\\studenti.xml");
        this.notaRepository = new NoteRepo(notaValidator);
        this.serviceNote = new ServiceNote(notaRepository);
        this.serviceStudent = new ServiceStudent(studentRepository);
        this.serviceTeme = new ServiceTeme(temaRepository);
    }


}
