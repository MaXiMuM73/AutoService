package com.cars.bpp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Log4j2
@Component
@RequiredArgsConstructor
public class InjectMapBeanPostProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, @NonNull String beanName)
            throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectMap.class)) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, getMyCustomServiceMap());
                log.info("Map injected");
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, @NonNull String beanName)
            throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectMap.class)) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, getMyCustomServiceMap());
                log.info("Map injected");
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private Map<String, MyCustomService> getMyCustomServiceMap() {
        return applicationContext.getBeansOfType(MyCustomService.class);
    }
}
