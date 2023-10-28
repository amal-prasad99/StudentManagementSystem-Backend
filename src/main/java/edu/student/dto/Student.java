package edu.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
        private String studentName;
        private int studentAge;
        private String studentContact;
        private String guardianName;
        private String guardianAddress;
        private String guardianContact;
}
