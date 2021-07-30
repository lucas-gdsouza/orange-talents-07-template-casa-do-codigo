package br.com.zupacademy.cdc.validations.annotations;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class GenericUniqueElementValidator implements ConstraintValidator<GenericUniqueElement, Object> {

    private String field;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(GenericUniqueElement uniqueElementGeneric) {
        field = uniqueElementGeneric.fieldName();
        klass = uniqueElementGeneric.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + field + " =:value");
        query.setParameter("value", o);

        List<?> list = query.getResultList();
        Assert.state(list.size() <=1, "O elemento " + field + " já está em uso");

        return list.isEmpty();
    }
}