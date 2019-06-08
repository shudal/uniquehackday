package moe.perci.hackday.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="good")
public class Good {
    @Id
    private int id;

    private String author;
    private String title;
    private int price;
    private String size;
    private String phone;
    private String payment;
    private int type;
    private int status;
    private String imgUrl;
}
