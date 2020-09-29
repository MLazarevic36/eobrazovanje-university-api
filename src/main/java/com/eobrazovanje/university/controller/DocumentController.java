package com.eobrazovanje.university.controller;

import com.eobrazovanje.university.config.AppConstants;
import com.eobrazovanje.university.entity.Document;
import com.eobrazovanje.university.entity.Student;
import com.eobrazovanje.university.mapper.DocumentMapper;
import com.eobrazovanje.university.mapper.dto.DocumentDTO;
import com.eobrazovanje.university.mapper.dto.PagedResponse;
import com.eobrazovanje.university.repository.StudentRepository;
import com.eobrazovanje.university.security.CurrentUser;
import com.eobrazovanje.university.security.UserPrincipal;
import com.eobrazovanje.university.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping(value = "api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private StudentRepository studentRepository;

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

    @GetMapping(value = "/student/{id}")
    public PagedResponse<DocumentDTO> getDocumentsByStudent(@RequestParam(value="page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                                            @RequestParam(value="size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size, @PathVariable("id") Long id) {

        return documentService.getAllDocumentsByStudent(id, page, size);
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

    @PostMapping("/upload")
    public ResponseEntity<DocumentDTO> uploadFile(@CurrentUser UserPrincipal currentUser, @RequestParam("file") MultipartFile file) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        currentUser = (UserPrincipal) auth.getPrincipal();
        Student student = studentRepository.findStudentByUser(currentUser.getId());
        Document document = new Document();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        document.setStudent(student);
        document.setName(fileName);
        document.setDeleted(false);
        try {
            document.setFile(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            documentService.save(document);
            return new ResponseEntity<DocumentDTO> (documentMapper.convertToDto(document), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/download/{id}")
    public ResponseEntity download(@PathVariable Long id) {
        Document document = documentService.findOne(id);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getName() + "\" ")
                .body(document.getFile());
    }


    @PutMapping
    public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO documentDTO) {
        Document document = documentMapper.convertToEntity(documentDTO);
        try {
            document.setId(documentDTO.getId());
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
