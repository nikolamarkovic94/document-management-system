package com.nst.dms.controllers;

import com.nst.dms.domain.Descriptor;
import com.nst.dms.domain.DocumentType;
import com.nst.dms.service.DescriptorService;
import com.nst.dms.service.DocumentTypeService;
import com.sun.javadoc.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/25/18.
 */

@RestController
@RequestMapping(value = "/document_types")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @Autowired
    private DescriptorService descriptorService;

    @GetMapping
    public ModelAndView findAll() {

        List<DocumentType> documentTypes = documentTypeService.findAll();

        ModelAndView modelAndView = new ModelAndView("documentTypesView");
        modelAndView.addObject("types", documentTypes);

        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView findById(@PathVariable Long id) {

        Optional<DocumentType> documentType = documentTypeService.findById(id);

        ModelAndView modelAndView = new ModelAndView("documentTypeDetails");
        modelAndView.addObject("type", documentType.get());

        return modelAndView;
    }

    @PostMapping(value = "/{id}/add_descriptor")
    public RedirectView addNew(@PathVariable(value = "id") Long id, @ModelAttribute Descriptor descriptor) {

        Optional<DocumentType> documentType = documentTypeService.findById(id);

        descriptor.setDocumentType(documentType.get());

        Descriptor savedDescriptor = descriptorService.save(descriptor);

        return new RedirectView("/document_types/" + documentType.get().getId(), true);
    }

    @PostMapping(value = "add_new")
    public RedirectView addNew(@RequestParam String name) {
        DocumentType documentType = new DocumentType();
        documentType.setName(name);
        documentTypeService.save(documentType);

        return new RedirectView("/document_types", true);
    }

    @GetMapping("delete/{id}")
    public RedirectView delete(@PathVariable Long id) {
        documentTypeService.deleteById(id);

        return new RedirectView("/document_types", true);
    }
}
