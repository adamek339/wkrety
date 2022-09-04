package pl.drukowanie3D.wkrety;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {


   @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);

        response.setDownloadUrl("/downloadFile/" + filecode);


        int reqestIdFromFile = Integer.parseInt(org.apache.commons.lang3.StringUtils.substringBefore(fileName, "_"));
       // int reqestIdFromFile2 = 18;

        jdbcTemplate.update("update request2 set linkToFile =? ,Status = 1 where id =?","http://127.0.0.1:8080/downloadFile/" + filecode ,reqestIdFromFile);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
