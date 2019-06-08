package moe.perci.hackday.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="accept")
public class Accept {
    @Id
    private int id;

    private int taskId;
    private int userId;
}
