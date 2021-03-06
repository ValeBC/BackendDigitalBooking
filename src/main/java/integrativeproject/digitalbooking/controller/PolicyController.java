package integrativeproject.digitalbooking.controller;

import integrativeproject.digitalbooking.service.impl.PolicyService;
import integrativeproject.digitalbooking.model.dto.PolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/policies")

public class PolicyController {
    @Autowired
    PolicyService policyService;

    @PostMapping("/create")
    public ResponseEntity<?> policiesRegister(@RequestBody PolicyDTO policyDTO){
        policyService.create(policyDTO);

        return ResponseEntity.ok(HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> policiesUpdate(@PathVariable ("id") Integer id,  @RequestBody PolicyDTO policyDTO) {
        policyService.update(policyDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Set<PolicyDTO>> findPolicies(){

        return ResponseEntity.ok(policyService.findAll());

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findPoliciesById(@PathVariable("id") Integer id) {
        PolicyDTO policyDTO = policyService.findById(id);
        return ResponseEntity.ok(policyDTO);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> policiesDelete(@PathVariable("id") Integer id) {
        policyService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
