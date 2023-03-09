package br.com.woll.med.api.consultation.controller;

import br.com.woll.med.api.consultation.dto.ConsultationDto;
import br.com.woll.med.api.consultation.dto.ScheduleDetailsDto;
import br.com.woll.med.api.consultation.service.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/consultation")
@RequiredArgsConstructor
public class ConsultationController {
  private final ConsultationService consultationService;

  @PostMapping("/schedule")
  @Transactional
  public ResponseEntity scheduleANewConsultation(@RequestBody @Valid ConsultationDto consultationDto) {
    ScheduleDetailsDto scheduleDetailsDto = consultationService.schedule(consultationDto);
    return ResponseEntity.ok(scheduleDetailsDto);
  }
}
