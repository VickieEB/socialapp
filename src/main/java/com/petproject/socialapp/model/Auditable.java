package com.petproject.socialapp.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable<U> {

    @CreatedBy

    protected U createdBy;

    @CreatedDate

    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @LastModifiedBy

    protected U lastModifiedBy;

    @LastModifiedDate

    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifiedDate;
}
