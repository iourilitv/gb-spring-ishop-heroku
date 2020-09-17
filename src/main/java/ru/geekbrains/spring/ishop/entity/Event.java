package ru.geekbrains.spring.ishop.entity;

import lombok.*;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "events")
@Getter
@Setter
@Slf4j
public class Event extends AbstractEntity {
    public static Event nullObject = initNullObject();
    public enum Issuers {STORE, SYSTEM}
    public enum Fields {id, actionType, issuer, issuerEventId, entityType, entityId,
        issuerCreatedAt, recipientAcceptedAt, entity}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "action_type_id")
    @NotNull(message = "не может быть пустым")
    private ActionType actionType;

    @Column(name = "issuer")
    @NotNull(message = "не может быть пустым")
    private String issuer;

    @Column(name = "issuer_event_id")
    private Long issuerEventId;

    @Column(name = "entity_type")
    @NotNull(message = "не может быть пустым")
    private String entityType;

    @Column(name = "entity_id")
    private Long entityId;

    @Column(name = "issuer_created_at")
    @CreationTimestamp
    private LocalDateTime issuerCreatedAt;

    @Column(name = "recipient_accepted_at")
    private LocalDateTime recipientAcceptedAt;

    @Tolerate
    public Event() {
    }

    private static Event initNullObject() {
        nullObject = Event.builder()
                .id(0L)
                .actionType(ActionType.nullObject)
                .issuer("")
                .issuerEventId(0L)
                .entityType("")
                .entityId(0L)
                .issuerCreatedAt(LocalDateTime.now())
                .recipientAcceptedAt(LocalDateTime.now())
                .build();
        return nullObject;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", actionType=" + actionType +
                ", issuer='" + issuer + '\'' +
                ", issuerEventId=" + issuerEventId +
                ", entityType='" + entityType + '\'' +
                ", entityId=" + entityId +
                ", issuerCreatedAt=" + issuerCreatedAt +
                ", recipientAcceptedAt=" + recipientAcceptedAt +
                '}';
    }
}
