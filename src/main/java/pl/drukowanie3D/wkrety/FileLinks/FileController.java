package pl.drukowanie3D.wkrety.FileLinks;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.drukowanie3D.wkrety.Request;
import pl.drukowanie3D.wkrety.RequestRepository;

import java.util.List;
@CrossOrigin
@RestController
public class FileController {


    @Autowired
    FileRepository fileRepository;


    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/files")
    public List<File> getAll(){

        return    fileRepository.getAll();


    }
}
