package com.quantum.matrix.cli.exception;

import com.quantum.matrix.domain.ErrorCode;

/**
 * The type General exception.
 */
public class GeneralException extends Exception {

    private final ErrorCode errorCode;

    private GeneralException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * The type Exception builder.
     */
    public static class Builder {

        private ErrorCode errorCode;
        private String message;
        private Throwable cause;

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
         * With root exception builder.
         *
         * @param cause the cause
         * @return the builder
         */
        public Builder withRootException(Throwable cause) {
            this.cause = cause;
            return this;
        }

        /**
         * Build general exception general exception.
         *
         * @return the general exception
         */
        public GeneralException buildGeneralException() {
            return new GeneralException(this.message, this.errorCode, this.cause);
        }

    }


}
