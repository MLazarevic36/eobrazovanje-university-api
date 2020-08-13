package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.Colloquium;
import com.eobrazovanje.university.mapper.ColloquiumMapper;
import com.eobrazovanje.university.mapper.dto.ColloquiumDTO;
import com.eobrazovanje.university.service.ColloquiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/colloquiums")
public class ColloquiumController {

    @Autowired
    private ColloquiumService colloquiumService;

    @Autowired
    private ColloquiumMapper colloquiumMapper;

    @GetMapping
    public ResponseEntity<Set<ColloquiumDTO>> getColloquiums(Pageable pageable) {
        try {
            Page<Colloquium> colloquiums = colloquiumService.findAll(pageable);
            return new ResponseEntity<>(colloquiumMapper.convertToDtos(colloquiums),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ColloquiumDTO> getColloquium(@PathVariable("id") Long id){
        try {
            Colloquium colloquium = colloquiumService.findOne(id);
            return new ResponseEntity<>(colloquiumMapper.convertToDto(colloquium), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ColloquiumDTO> addColloquium(@RequestBody ColloquiumDTO colloquiumDTO) {
        Colloquium colloquium = colloquiumMapper.convertToEntity(colloquiumDTO);
        try {
            colloquium = colloquiumService.save(colloquium);
            return new ResponseEntity<>(colloquiumMapper.convertToDto(colloquium), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<ColloquiumDTO> updateColloquium(@RequestBody ColloquiumDTO colloquiumDTO) {
        Colloquium colloquium = colloquiumMapper.convertToEntity(colloquiumDTO);
        try {
            colloquium.setId(colloquiumDTO.getId());
            colloquium = colloquiumService.save(colloquium);
            return new ResponseEntity<>(colloquiumMapper.convertToDto(colloquium), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteColloquium(@PathVariable("id") Long id) {
        try {
            Colloquium colloquium = colloquiumService.findOne(id);
            colloquiumService.delete(colloquium);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
