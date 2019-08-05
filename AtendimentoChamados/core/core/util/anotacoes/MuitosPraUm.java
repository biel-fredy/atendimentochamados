package core.util.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import core.util.anotacoesenum.CascadeType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MuitosPraUm {
	
	CascadeType cascade();
	boolean removerOrfao();
	String mappedBy();
	

}
