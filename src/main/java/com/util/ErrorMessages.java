package com.util;

public enum ErrorMessages {
	
	FILE_NOT_FOUND("No se encontro el archivo."),
    INVALID_FILE_FORMAT("El formato del archivo es invalido."),
    IO_EXCEPTION("Ocurrio un error al leer el archivo."),
    DATA_PERSISTENCE_ERROR("Ocurrio un error al guardar los datos en la base de datos."),
    EMPTY_FILE("El archivo esta vacio."),
    INVALID_DATA("El archivo excel contiene datos invalidos."),
	RESOURCE_NOT_FOUND("No existe un recurso para este id :: "),
    INTERNAL_SERVER_ERROR("Ocurrio un error inesperado :: ");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
