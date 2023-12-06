package com.example.vuespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VueSpringApplication  {


    public static void main(String[] args) {
        SpringApplication.run(VueSpringApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Student student1 = Student.builder()
//                .name("Alan Lipton")
//                .groupId("IA-13")
//                .email("alanLipton.com")
//                .phone("+38(050)673 39 37").build();
//
//        Student student2 = Student.builder()
//                .name("Linda Lavazza")
//                .groupId("IA-14")
//                .email("Linda.com")
//                .phone("+38(050)768 94 33").build();
//
//        Student student3 = Student.builder()
//                .name("Kirk Tiberian")
//                .groupId("IA-11")
//                .email("kirk.com")
//                .phone("+38(050)900 34 68").build();
//        studentRepository.save(student1);
//        studentRepository.save(student2);
//        studentRepository.save(student3);
//    }
}
