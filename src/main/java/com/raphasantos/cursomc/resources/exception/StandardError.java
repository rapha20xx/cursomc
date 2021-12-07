package com.raphasantos.cursomc.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
    private static final long serialVersionUID = -1011269955866853868L;

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;


}

