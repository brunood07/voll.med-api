package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterDoctorDTO data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        repository.save(doctor);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new UpdateDoctorDTOResponse(doctor));
    }

    @GetMapping("/{id}")
    public ResponseEntity getDoctorById(@PathVariable long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new UpdateDoctorDTOResponse(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<ListingDoctorDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        return ResponseEntity.ok(repository.findAllByActiveTrue(pagination).map(ListingDoctorDTO::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDoctorDTO data, @PathVariable long id) {
        var doctor = repository.getReferenceById(id);
        doctor.updateDoctorInfo(data);
        return ResponseEntity.ok(new UpdateDoctorDTOResponse(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }
}
