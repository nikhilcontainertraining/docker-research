package com.nikhil.containers.dockerresearch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikhil.containers.dockerresearch.model.User;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

@Service
public class FileHandler {

    static Logger log = LogManager.getLogger(FileHandler.class);

    public boolean createJsonFile(User user) {
        ObjectMapper mapper = new ObjectMapper();
        String fileName = user.getMessage() + ".json";

        byte[] content = new byte[0];

        try {
            content = mapper.writeValueAsString(user).getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            writeToFile("joke_vol", fileName, content);

//            copyToLocation("src/main/resources/static/json-files/"+fileName,
//                    "/app/joke_vol"+fileName);
        } catch (Exception e) {
            log.error("------ ------ Exception occurred");
            e.printStackTrace();
        }

        log.info("filename: " + fileName);

        return true;
    }

    private void copyToLocation(String source, String destination) {
        Path src = Paths.get(source);
        Path dest = Paths.get(destination);
        try {
            Files.copy(src, dest,
                    StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES, NOFOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String rootDir, String fileName, byte[] bytes) {
        log.info("------------------------------------------------------------");
        FileOutputStream fos = null;
        File file = null;
        try {
            file = new File(rootDir, fileName);
            fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();

        } catch (FileNotFoundException e) {
            log.error("------ ------ FileNotFoundException occurred");
            log.error(e.getStackTrace());
        } catch (IOException e) {
            log.error("------ ------ IOException occurred");
            log.error(e.getStackTrace());
        }
        log.info("-- file rel path -- " + file.getPath());
        log.info("-- file abs path -- " + file.getAbsolutePath());

    }

    public InputStream getFile(String fileName) throws IOException {
        return new FileInputStream("joke_vol/"+fileName);
        //return new FileInputStream("/app/joke_vol/"+fileName);
    }






//    public InputStream getFile(String fileName) throws IOException {
//        InputStream in = getClass()
//                .getResourceAsStream("src/main/resources/static/json-files/"+fileName+".json");
//        return in;
//        return in.readAllBytes();
//        return getClass()
//                .getResourceAsStream("/src/main/resources/static/json-files/"+fileName+".json");
//        return getClass()
//                .getResourceAsStream("/app/app_voltest/"+fileName+".json");

//        return new FileInputStream("/app/app_voltest/"+fileName+".json");
        //String data = IOUtils.toString(fis, "UTF-8");

//        return new FileInputStream("app/joke_vol/"+fileName);
//    }
}
