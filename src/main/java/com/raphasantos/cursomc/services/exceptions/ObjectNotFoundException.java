package com.raphasantos.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 2964833559806295311L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
