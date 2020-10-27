package edu.cnm.deepdive.studentcontacts.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    indexes =
    @Index(columnList = "relationship_type"),
    uniqueConstraints =
    @UniqueConstraint(columnNames = {
        "student_id",
        "contact_id"
    })
)
public class StudentContact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_contact_id", nullable = false, updatable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "student_id")
  private long studentId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "contact_id")
  private long contactId;

  private boolean primary;

  @NonNull
  @Enumerated(EnumType.STRING)
  private RelationshipType relationshipType;

  public enum RelationshipType {

    PARENT, GUARDIAN, SIBLING, OTHER

  }

  public Long getId() {
    return id;
  }

  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public long getContactId() {
    return contactId;
  }

  public void setContactId(long contactId) {
    this.contactId = contactId;
  }

  public boolean isPrimary() {
    return primary;
  }

  public void setPrimary(boolean primary) {
    this.primary = primary;
  }

  @NonNull
  public RelationshipType getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(@NonNull RelationshipType relationshipType) {
    this.relationshipType = relationshipType;
  }
}
