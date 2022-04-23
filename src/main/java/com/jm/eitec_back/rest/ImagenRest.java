package com.jm.eitec_back.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.jm.eitec_back.entity.Imagen;
import com.jm.eitec_back.services.CajaService;
import com.jm.eitec_back.services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value="/imagen")
@CrossOrigin(origins = "*")
public class ImagenRest {
    @Autowired
    private ImagenService imagenService;

    @Autowired
    private CajaService cajaService;

    @PostMapping(value = "/guardar", consumes = { "multipart/form-data" })
    public String guardar(@RequestParam("file") MultipartFile multiPart, @RequestParam("id") Long id) {

        Imagen img = new Imagen();

        try {

            img.setCaja(cajaService.findById(id));

        } catch (Exception e) {
            // TODO: handle exception
            return "Error el id no existe o no fue enviado como parametro";
        }


        if(!multiPart.isEmpty()) {

            Path rutaImg = Paths.get("src//main//resources//static");
            String rutaAbsoluta = rutaImg.toFile().getAbsolutePath();

            try {

                byte[] bytesImg = multiPart.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + multiPart.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                img.setRuta(rutaCompleta.toFile().getAbsolutePath());
                imagenService.save(img);
                return "Se registro con exito";

            } catch (IOException e) {
                // TODO Auto-generated catch block

                e.printStackTrace();
                return "Error";
            }

        }

        return "Error";
    }
}
