package vn.techmaster.course.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.course.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
// Folder luu tru file
    private static String uploadDir = System.getProperty("user.dir")
        .concat(File.separator)
        .concat("uploads");

        private  void createFolder(String filePath){
            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
        }

    public FileServiceImpl() {
            createFolder(uploadDir);
    }

    @Override
    public String uploadFile(MultipartFile file) {
        String fileId = UUID.randomUUID().toString();
        File fileServer = new File(uploadDir.concat(File.separator).concat(fileId));
        try{
            file.transferTo(fileServer);
            return "/api/v1/files/".concat(fileId);
        } catch (IOException e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Lỗi khi upload file");
        }
    }

    @Override
    public byte[] readFile(String id) {
        File fileService = new File(uploadDir.concat(File.separator).concat(id));
        if(!fileService.exists()){
            throw  new RuntimeException("Lỗi khi đọc file");
        }
        try{
            return Files.readAllBytes(fileService.toPath());
        }catch(IOException e){
            throw  new RuntimeException("Lỗi khi đọc file");
        }
    }
}