package com.nst.dms.controllers;

import com.nst.dms.domain.Descriptor;
import com.nst.dms.service.DescriptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
@RestController
@RequestMapping(value = "/descriptors")
public class DescriptorController {

    @Autowired
    private DescriptorService descriptorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Descriptor> findById(@PathVariable Long id) {

        Optional<Descriptor> descriptor = descriptorService.findById(id);

        if (!descriptor.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Descriptor>(descriptor.get(), HttpStatus.OK);
    }


}
