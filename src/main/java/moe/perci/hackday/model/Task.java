package moe.perci.hackday.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int type;
    private int peopleNeed;
    private String description;
    private String imgUrl;
    private int lastDays;
    private int schoolId;
    private String createTime;
}