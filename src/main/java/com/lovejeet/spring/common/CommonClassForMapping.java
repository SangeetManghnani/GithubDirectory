package com.lovejeet.spring.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/** This class will have common method or fields which are applicable for all the mapping classes.<br>
 * This class will be extended by all the mapping classes. */
@MappedSuperclass
public class CommonClassForMapping {

    /** Id of the mapping objects. Applicable to all the mapping classes */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /** Constructor - Default */
    public CommonClassForMapping() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
