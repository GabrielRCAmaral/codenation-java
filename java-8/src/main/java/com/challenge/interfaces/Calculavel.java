package com.challenge.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public interface Calculavel {
    public BigDecimal somar(Object classe) throws InvocationTargetException, IllegalAccessException;
    public BigDecimal subtrair(Object classe) throws InvocationTargetException, IllegalAccessException;
    public BigDecimal totalizar(Object classe);
}
