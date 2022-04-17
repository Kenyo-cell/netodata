package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.entity.PersonEntity;
import org.example.service.SecuredPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class SecuredPersonController {
    private final SecuredPersonService service;

    @GetMapping("/{id}")
    @Secured("ROLE_READ")
    public ResponseEntity<PersonEntity> getPersonById(@PathVariable long id) {
        return ResponseEntity.ok(service.getPersonById(id));
    }

    @PostMapping()
    @RolesAllowed("ROLE_WRITE")
    public ResponseEntity<PersonEntity> save(@RequestBody PersonEntity entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public ResponseEntity<PersonEntity> update(@RequestBody PersonEntity entity, @PathVariable long id) {
        return ResponseEntity.ok(service.update(entity, id));
    }

    @GetMapping("/by-username")
    @PreAuthorize("authentication.authenticated")
    @PostAuthorize("#username == authentication.name")
    public ResponseEntity<PersonEntity> getPersonByUsername(@RequestParam String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }
}
