package br.com.fiap.fpf.fempowerfit.Validation;

import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target(FIELD)
@Retention(RUNTIME)
public @interface TipoSuplementacao {

    String message() default "Tipo inválido. Tipo deve ser ENTRADA ou SAIDA.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}