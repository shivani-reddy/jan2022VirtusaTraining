package com.calender.calenderApi.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.example.calendar.models.Country;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Calendar")
public class Calendar {
    // Holiday Id
    @Id
    @Column(name = "Holiday_Id", length =5, nullable = false, unique = true)
    private long holidayId;
    // Event Description
    @Column(name = "Event", length = 50)
    private String event;
    // Category
    @Column(name = "Category", length = 25, nullable = false)
    private String category;
    // Date_Holiday
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "Date_Holiday", nullable = false)
    private LocalDate holidayDate;
    // Description
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name="Country_Code"), name="Country_Code")
    private Country country;
}
