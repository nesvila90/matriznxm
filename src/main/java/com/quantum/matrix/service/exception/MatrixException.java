package com.quantum.matrix.service.exception;

import com.quantum.matrix.domain.ErrorCode;

/**
 * The type Matrix exception.
 */
public class MatrixException extends Exception {

    private MatrixException(String message, ErrorCode errorCode) {
        super(errorCode.toString().concat(" - ").concat(message));
    }

    /**
     * The type Exception builder.
     */
    public static class Builder {

        private ErrorCode errorCode;
        private String message;

        private Builder() {
        }

        /**
         * Builder exception builder.
         *
         * @return the exception builder
         */
        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * With error code exception builder.
         *
         * @param errorCode the error code
         * @return the exception builder
         */
        public Builder withErrorCode(ErrorCode errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        /**
         * With message exception builder.
         *
         * @param message the message
         * @return the exception builder
         */
        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * Build matrix exception matrix exception.
         *
         * @return the matrix exception
         */
        public MatrixException buildMatrixException() {
            return new MatrixException(this.message, this.errorCode);
        }

    }

}
