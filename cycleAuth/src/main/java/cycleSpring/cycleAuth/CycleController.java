package cycleSpring.cycleAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cycleSpring.cycleAuth.CycleRepo;
import cycleSpring.cycleAuth.DetailRepo;


import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/cycles")
public class CycleController {

    @Autowired
    private CycleRepo cycleRepository;

    @Autowired
    private DomainUserService domainUserService;
    

    @GetMapping("/cycleList")
    public ResponseEntity<List<CycleEntity>> listCycles() {
        List<CycleEntity> cycles = cycleRepository.findAll();
        return ResponseEntity.ok(cycles);
    }

    @PostMapping("/cycleList")
    public ResponseEntity<String> incrementStock(@RequestBody Map<String, Integer> requestData) {
        Long cycleId = (long) requestData.get("cycleId");
        int quantity = requestData.get("quantity");

        CycleEntity cycle = cycleRepository.findById(cycleId).orElse(null);

        if (cycle != null) {
            int currentStock = cycle.getStockCount();
            cycle.setStockCount(currentStock + quantity);
            cycleRepository.save(cycle);
            return ResponseEntity.status(HttpStatus.OK).body("Cycle borrowed successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/borrow")
    public ResponseEntity<List<CycleEntity>> borrowCycle() {
        List<CycleEntity> cycles = cycleRepository.findAll();
        return ResponseEntity.ok(cycles);
    }

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowCycleById(@RequestBody Map<String, Integer> requestData) {
        Long cycleId = (long) requestData.get("cycleId");
        int quantity = requestData.get("quantity");
    	System.out.println(cycleId);
    	System.out.println(quantity);

        CycleEntity cycle = cycleRepository.findById(cycleId).orElse(null);

        if (cycle != null) {
            int currentStock = cycle.getStockCount();
            if (currentStock >= quantity) {
                cycle.setStockCount(currentStock - quantity);
                cycleRepository.save(cycle);
                return ResponseEntity.status(HttpStatus.OK).body("Cycle borrowed successfully");
            } else {
                return ResponseEntity.badRequest().body("Stock Empty");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CycleEntity>> listCyclesHTML() {
        List<CycleEntity> cycles = cycleRepository.findAll();
        return ResponseEntity.ok(cycles);
    }

  
    // // @GetMapping("/register")
    // //     public ResponseEntity<String> getRegistrationPage() {
    // //         return ResponseEntity.ok("Registration page"); 
    // //     }
    // @GetMapping("/register")
    //     public String getRegistrationPage() {
    //         return "register";
    //     }

    // @PostMapping("/register")
    // public ResponseEntity<String> register(@RequestBody RegistrationForm registrationForm) {
    //     if (!registrationForm.isValid()) {
    //         return ResponseEntity.badRequest().body("Passwords must match");
    //     }
    
    //     User registeredUser = domainUserService.save(registrationForm.getUsername(), registrationForm.getPassword());
    
    //     if (registeredUser != null) {
    //         return ResponseEntity.ok("Registration successful");
    //     } else {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
    //     }
    // }
    
    
}

