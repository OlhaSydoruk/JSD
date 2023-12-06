package com.example.vuespring.controller;

import com.example.vuespring.entity.Schedule;
import com.example.vuespring.repository.ScheduleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@CrossOrigin("http://localhost:5173")
public class ScheduleController {
  private final ScheduleRepository scheduleRepository;

  public ScheduleController (ScheduleRepository scheduleRepository){
      this.scheduleRepository=scheduleRepository;
  }


    @GetMapping
    public List<Schedule> listSchedule() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Schedule getSchedule(@PathVariable long id) {
        return scheduleRepository.getReferenceById(id);
    }

    @PostMapping
    public void insertSchedule(@RequestBody Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @PutMapping
    public void updateSchedule(@RequestBody Schedule schedule) {
        Schedule existingSchedule = scheduleRepository.getReferenceById(schedule.getId());
        existingSchedule.setClassroom(schedule.getClassroom());
        existingSchedule.setName(schedule.getName());
        existingSchedule.setDisciplinesId(schedule.getDisciplinesId());
        existingSchedule.setGroupsId(schedule.getGroupsId());
        existingSchedule.setTeacherId(schedule.getTeacherId());
        existingSchedule.setTime(schedule.getTime());
        scheduleRepository.save(existingSchedule);
    }
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable long id) {
        scheduleRepository.deleteById(id);
    }
}



