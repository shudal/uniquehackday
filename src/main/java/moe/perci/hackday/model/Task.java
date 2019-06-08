package moe.perci.hackday.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    private int id;

    private String title;
    private String ddlRegister;
    private String startTime;
    private int peopleNeed;
    private String description;
    private String imgUrl;
    private int lastDays;
    private int schoolId;
    private String createTime;

    @ManyToOne
    @JoinColumn(name="schoolId", insertable = false, updatable = false)
    private User user;
}
