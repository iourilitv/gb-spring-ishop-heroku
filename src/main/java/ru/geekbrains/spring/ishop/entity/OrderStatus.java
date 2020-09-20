package ru.geekbrains.spring.ishop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "order_statuses")
@Getter
@Setter
public class OrderStatus extends AbstractEntity {
    public enum Fields {id, title, description}
    public enum Statuses {Created, Canceled}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "title", unique = true)
    @NotNull(message = "Fill this field!")
    @Size(min = 1, max = 255, message = "Number of symbols should be between 5 to 255!")
    private String title;

    @Column(name = "description")
    @NotNull(message = "Fill this field!")
    @Size(max = 5000, message = "Maximum 5000 symbols is allowed!")
    private String description;

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
