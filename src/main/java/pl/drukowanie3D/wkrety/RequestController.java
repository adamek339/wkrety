package pl.drukowanie3D.wkrety;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin//(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/requests")
public class RequestController {

    @Autowired
    RequestRepository requestRepository;


  //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/requests")
    public List<Request> getAll(){
      return    requestRepository.getAll();
    }



  //@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/requests")
    public ResponseEntity add(@RequestBody Request request){   // to @ReqestBody oznacza ze ten obiek w parametrze to bedzie przysłany w reqescie
     requestRepository.save(request);
    return ResponseEntity.ok(request);



    }
}
