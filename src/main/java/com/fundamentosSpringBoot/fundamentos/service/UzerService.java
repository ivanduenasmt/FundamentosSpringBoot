package com.fundamentosSpringBoot.fundamentos.service;

import com.fundamentosSpringBoot.fundamentos.entity.Uzer;
import com.fundamentosSpringBoot.fundamentos.repository.UzerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UzerService {
    private final Log LOG = LogFactory.getLog(UzerService.class);

    private UzerRepository uzerRepository;

    public UzerService(UzerRepository uzerRepository) {
        this.uzerRepository = uzerRepository;
    }

    @Transactional
    public void saveTransactional(List<Uzer> uzers) {
        uzers.stream()
                .peek(uzer -> LOG.info("usuario insertado: " + uzer))
                .forEach(uzerRepository::save);
    }

    public List<Uzer> getAllUzers(){
        return uzerRepository.findAll();
    }

    public Uzer save(Uzer newUzer) {
        return uzerRepository.save(newUzer);
    }

    public void delete(Long id) {
        uzerRepository.deleteById(id);
    }

    public Uzer update(Uzer newUzer, Long id) {
        return
        uzerRepository.findById(id)
                .map(
                        uzer -> {
                            uzer.setEmail(newUzer.getEmail());
                            uzer.setBirthday(newUzer.getBirthday());
                            uzer.setName(newUzer.getName());
                            return uzerRepository.save(uzer);
                        }
                ).get();
    }
}

