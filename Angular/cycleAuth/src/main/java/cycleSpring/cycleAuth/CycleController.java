package cycleSpring.cycleAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cycles")
public class CycleController {

    @Autowired
    private CycleRepo cycleRepository;

    @Autowired
    private CycleBasketRepo basketRepository;
    

    @GetMapping("/list")
    public ResponseEntity<List<CycleEntity>> listCyclesHTML() {
        List<CycleEntity> cycles = cycleRepository.findAll();
        return ResponseEntity.ok(cycles);
    }

    @PostMapping("/restock")
    public ResponseEntity<Map<String, String>> incrementStock(@RequestBody Map<String, Integer> requestData) {
        Long cycleId = (long) requestData.get("cycleId");
        int quantity = requestData.get("quantity");
        CycleEntity cycle = cycleRepository.findById(cycleId).orElse(null);

        if (cycle != null) {
            int currentStock = cycle.getStockCount();
            cycle.setStockCount(currentStock + quantity);
            cycleRepository.save(cycle);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Cycle restocked successfully");
        
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @PostMapping("/return")
    public ResponseEntity<Map<String, String>> returnCycleById(@RequestBody Map<String, Integer> requestData) {
        Long cycleId = (long) requestData.get("cycleId");
        int quantity = requestData.get("quantity");

        CycleEntity cycle = cycleRepository.findById(cycleId).orElse(null);

        if (cycle != null) {
            int currentStock = cycle.getStockCount();
            int borrowStock = cycle.getNumBorrowed();
            if (borrowStock >= quantity) {
                cycle.setStockCount(currentStock + quantity);
                cycleRepository.save(cycle);
                 Map<String, String> response = new HashMap<>();
                response.put("message", "Cycle returned successfully");
        
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "More quantity returned");
        
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/borrow")
    public ResponseEntity<Map<String, String>> borrowCycleById(@RequestBody Map<String, Integer> requestData) {
        Long cycleId = (long) requestData.get("cycleId");
        int quantity = requestData.get("quantity");

        CycleEntity cycle = cycleRepository.findById(cycleId).orElse(null);

        if (cycle != null) {
            int currentStock = cycle.getStockCount();
            if (currentStock >= quantity) {
                cycle.setStockCount(currentStock - quantity);
                cycle.setNumBorrowed(cycle.getNumBorrowed() + quantity);
                cycleRepository.save(cycle);
                 Map<String, String> response = new HashMap<>();
                response.put("message", "Cycle borrowed successfully");
        
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                 Map<String, String> response = new HashMap<>();
                response.put("message", "Stock Empty");
        
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cartList")
    public ResponseEntity<List<CycleBasketEntity>> listCartCycles() {
    List<CycleBasketEntity> cycles = basketRepository.findAll();
    return ResponseEntity.ok(cycles);
    }

    @PostMapping("/cartAdd")
    public ResponseEntity<Map<String, String>> addCycleCart(@RequestBody Map<String, Integer> requestData) {
        Long cycleId = (long) requestData.get("cycleId");
        int quantityToAdd = requestData.get("quantity");
    
        CycleEntity cycle = cycleRepository.findById(cycleId).orElse(null);
    
        if (cycle != null) {
            int currentStock = cycle.getStockCount();
            if (currentStock >= quantityToAdd) {
                cycle.setStockCount(currentStock - quantityToAdd);
                cycle.setNumBorrowed(cycle.getNumBorrowed() + quantityToAdd);
                cycleRepository.save(cycle);
    
                CycleBasketEntity cartItem = basketRepository.findByCycleId(cycleId);
    
                if (cartItem == null) {
                    cartItem = new CycleBasketEntity();
                    cartItem.setCycle(cycle);
                    cartItem.setQuantity(quantityToAdd);
                } else {
                    cartItem.setQuantity(cartItem.getQuantity() + quantityToAdd);
                }
    
                basketRepository.save(cartItem);
    
                Map<String, String> response = new HashMap<>();
                response.put("message", "Cycle added to cart successfully");
    
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                 Map<String, String> response = new HashMap<>();
                response.put("message", "Stock Empty");
    
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
}

