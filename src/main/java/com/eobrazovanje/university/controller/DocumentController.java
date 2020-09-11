package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.entity.Document;
import com.eobrazovanje.university.mapper.DocumentMapper;
import com.eobrazovanje.university.mapper.dto.DocumentDTO;
import com.eobrazovanje.university.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentMapper documentMapper;

    @GetMapping
    public ResponseEntity<Set<DocumentDTO>> getDocuments(Pageable pageable) {
        try {
            Page<Document> documents = documentService.findAll(pageable);
            return new ResponseEntity<>(documentMapper.convertToDtos(documents),
                    HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DocumentDTO> getDocument(@PathVariable("id") Long id){
        try {
            Document document = documentService.findOne(id);
            return new ResponseEntity<>(documentMapper.convertToDto(document), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DocumentDTO> addDocument(@RequestBody DocumentDTO documentDTO) {
        Document document = documentMapper.convertToEntity(documentDTO);
        try {
            document = documentService.save(document);
            return new ResponseEntity<>(documentMapper.convertToDto(document), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping
    public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO documentDTO) {
        Document document = documentMapper.convertToEntity(documentDTO);
        try {
            document.setDocument_id(documentDTO.getDocument_id());
            document = documentService.save(document);
            return new ResponseEntity<>(documentMapper.convertToDto(document), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable("id") Long id) {
        try {
            Document document = documentService.findOne(id);
            documentService.delete(document);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
