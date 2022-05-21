package com.fundamentosSpringBoot.fundamentos.controller;

import com.fundamentosSpringBoot.fundamentos.casesUse.CreateUzer;
import com.fundamentosSpringBoot.fundamentos.casesUse.DeleteUzer;
import com.fundamentosSpringBoot.fundamentos.casesUse.GetUzer;
import com.fundamentosSpringBoot.fundamentos.casesUse.UpdateUzer;
import com.fundamentosSpringBoot.fundamentos.entity.Uzer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uzers")
public class UzerRestController {

    private DeleteUzer deleteUzer;
    private CreateUzer createUzer;
    private GetUzer getUzer;
    private UpdateUzer updateUzer;

    public UzerRestController(DeleteUzer deleteUzer, CreateUzer createUzer, GetUzer getUzer, UpdateUzer updateUzer) {
        this.deleteUzer = deleteUzer;
        this.createUzer = createUzer;
        this.getUzer = getUzer;
        this.updateUzer = updateUzer;
    }

    @PostMapping("/")
    ResponseEntity<Uzer> newUzer(@RequestBody Uzer newUzer) {
        return new ResponseEntity<>(createUzer.save(newUzer), HttpStatus.CREATED);
    }

    @GetMapping("/")
    List<Uzer> get() {
        return getUzer.getAll();
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUzer(@PathVariable Long id){
        deleteUzer.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<Uzer> replaceUzer(@RequestBody Uzer newUzer, @PathVariable Long id){
        return new ResponseEntity<>(updateUzer.update(newUzer, id), HttpStatus.OK);
    }


}
