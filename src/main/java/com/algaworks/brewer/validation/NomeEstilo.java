package com.algaworks.brewer.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Pattern(regexp = "([a-zA-Z]{15})?")
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface NomeEstilo {
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message()default "O prenchimento máximo são de 15 caracteres!";
	
	
	Class<?>[] groups()default{};
	Class<? extends Payload>[] payload() default{};
}
