package br.com.fiap.fpf.fempowerfit.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class TipoAcompanhamentoValidator implements ConstraintValidator<TipoSuplementacao, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("WHEYPROTEIN") || value.equals("CREATINA") || value.equals("PRE-TREINO") || value.equals("OUTRO");
    }

}