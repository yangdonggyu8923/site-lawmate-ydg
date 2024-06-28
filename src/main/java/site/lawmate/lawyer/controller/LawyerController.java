package site.lawmate.lawyer.controller;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import site.lawmate.lawyer.component.Messenger;
import site.lawmate.lawyer.domain.dto.LawyerDto;
import site.lawmate.lawyer.domain.model.LawyerDetailModel;
import site.lawmate.lawyer.domain.model.LawyerModel;
import site.lawmate.lawyer.domain.model.ReplyModel;
import site.lawmate.lawyer.service.impl.LawyerServiceImpl;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping
public class LawyerController {

    private final LawyerServiceImpl lawyerService;

    @PostMapping("/login")
    public ResponseEntity<Mono<Messenger>> login(@RequestBody LawyerDto lawyerDto) {
        log.info("::: 로그인 컨트롤러 파라미터 : {}",lawyerDto.toString());
        return ResponseEntity.ok(lawyerService.login(lawyerDto));
    }

    @GetMapping("/logout")
    public ResponseEntity<Mono<Messenger>> logout(@RequestHeader("Authorization") String accessToken) {
        log.info("1- 로그아웃 접속토큰 : {}", accessToken);
        Messenger m = Messenger.builder().message("SUCCESS").build();
        Mono<Messenger> logout = Mono.just(m);
        return ResponseEntity.ok(logout);
    }

    @GetMapping("/count")
    public ResponseEntity<Mono<Long>> getLawyersCount() {
        return ResponseEntity.ok(lawyerService.getLawyersCount());
    }

    @GetMapping("/all")
    public ResponseEntity<Flux<LawyerModel>> getAllLawyers() {
        return ResponseEntity.ok(lawyerService.getAllLawyers());
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<Mono<LawyerModel>> getLawyerUsernameByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(lawyerService.getLawyerUsernameByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<LawyerModel>> getLawyerById(@PathVariable("id") String id) {
        return ResponseEntity.ok(lawyerService.getLawyerById(id));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Mono<LawyerDetailModel>> getLawyerDetailById(@PathVariable("id") String id) {
        return ResponseEntity.ok(lawyerService.getLawyerDetailById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Mono<LawyerModel>> saveLawyer(@RequestBody LawyerModel lawyer) {
        return ResponseEntity.ok(lawyerService.addLawyer(lawyer));
    }

    @PostMapping("/saveDetail/{id}")
    public ResponseEntity<Mono<LawyerModel>> saveLawyerDetail(@PathVariable("id") String lawyerId, @RequestBody LawyerDetailModel lawyer) {
        return ResponseEntity.ok(lawyerService.addLawyerDetailToLawyer(lawyerId, lawyer));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Mono<LawyerModel>> updateLawyer(@PathVariable("id") String id, @RequestBody LawyerModel lawyer) {
        return ResponseEntity.ok(lawyerService.updateLawyer(id, lawyer));
    }

    @PatchMapping("/detail/{id}")
    public ResponseEntity<Mono<LawyerModel>> updateLawyerDetail(@PathVariable("id") String id, @RequestBody LawyerDetailModel lawyer) {
        return ResponseEntity.ok(lawyerService.updateLawyerDetail(id, lawyer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteLawyer(@PathVariable("id") String id) {
        return ResponseEntity.ok(lawyerService.deleteLawyer(id));
    }
}