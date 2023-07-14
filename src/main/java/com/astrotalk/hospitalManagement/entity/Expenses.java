package com.astrotalk.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The type Expenses.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Expenses {

    @Column(name = "expense_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    private Double amount;

    private String remarks;

    @Builder.Default
    private Integer recordStatus = 1; //1: Active Record; 5: Inactive Record

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

}
