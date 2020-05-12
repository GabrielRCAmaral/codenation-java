package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object classe) {
        BigDecimal total=BigDecimal.ZERO;
        for(Field field:classe.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Somar.class) && field.getType().getName().equals(BigDecimal.class.getName())){
                for(Method method:classe.getClass().getDeclaredMethods()){
                    if(method.getName().toUpperCase().equals("GET"+field.getName().toUpperCase())){
                        try {
                            total = total.add((BigDecimal)method.invoke(classe));
                        } catch (IllegalAccessException e) {

                        } catch (InvocationTargetException e) {

                        }
                    }
                }

            }

        }
        return total;
    }

    @Override
    public BigDecimal subtrair(Object classe)  {
        BigDecimal total=BigDecimal.ZERO;
        for(Field field:classe.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Subtrair.class) && field.getType().getName().equals(BigDecimal.class.getName())){
                for(Method method:classe.getClass().getDeclaredMethods()){
                    if(method.getName().toUpperCase().equals("GET"+field.getName().toUpperCase())){
                        try {
                            total = total.add((BigDecimal)method.invoke(classe));
                        } catch (IllegalAccessException e) {

                        } catch (InvocationTargetException e) {

                        }
                    }
                }

            }

        }
        return total;

    }

    @Override
    public BigDecimal totalizar(Object classe) {
        return somar(classe).subtract(subtrair(classe));
    }
}
