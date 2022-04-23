package com.jm.eitec_back.services;

import com.jm.eitec_back.entity.Imagen;
import com.jm.eitec_back.implement.Imagenimpl;
import com.jm.eitec_back.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService implements Imagenimpl {

    @Autowired
    private ImagenRepository imagenRepository;

    @Override
    public void save(Imagen imagen) {
        imagenRepository.save(imagen);
    }
}
