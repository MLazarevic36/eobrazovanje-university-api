package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.Term;
import com.eobrazovanje.university.mapper.TermMapper;
import com.eobrazovanje.university.mapper.dto.ExamDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.mapper.dto.TermDTO;
import com.eobrazovanje.university.mapper.dto.UserDTO;
import com.eobrazovanje.university.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/terms")
public class TermController {

    @Autowired
    private TermService termService;

    @Autowired
    private TermMapper termMapper;

    @GetMapping
    public PagedResponse<TermDTO> getTerms(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                           @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {

        return termService.getAllTerms(page, size);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TermDTO> getTerm(@PathVariable("id") Long id){
        try {
            Term term = termService.findOne(id);
            return new ResponseEntity<>(termMapper.convertToDto(term), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TermDTO> addTerm(@RequestBody TermDTO termDTO) {
        Term term = termMapper.convertToEntity(termDTO);
        try {
            term = termService.save(term);
            return new ResponseEntity<>(termMapper.convertToDto(term), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<TermDTO> updateTerm(@RequestBody TermDTO termDTO) {
        Term term = termMapper.convertToEntity(termDTO);
        try {
            term.setId(termDTO.getId());
            term = termService.save(term);
            return new ResponseEntity<>(termMapper.convertToDto(term), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTerm(@PathVariable("id") Long id) {
        try {
            Term term = termService.findOne(id);
            termService.delete(term);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
