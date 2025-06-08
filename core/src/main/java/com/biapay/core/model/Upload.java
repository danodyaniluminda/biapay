package com.biapay.core.model;

import com.biapay.core.constant.enums.UploadType;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "uploads")
@NoArgsConstructor
@AllArgsConstructor
public class Upload extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "file_size")
  private Long fileSize;

  @Column(name = "mime_type")
  private String mimeType;

  @Column(name = "uuid")
  private String uuid;

  @Column(name = "original_name")
  private String originalName;

  @Column(name = "upload_type")
  @Enumerated(EnumType.STRING)
  private UploadType uploadType;

  @Column(name = "local_path")
  private String localPath;

  @Column(name = "uploaded_at")
  private LocalDateTime uploadedAt;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
