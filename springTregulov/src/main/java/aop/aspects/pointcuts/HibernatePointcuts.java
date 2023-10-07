package aop.aspects.pointcuts;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class HibernatePointcuts {

    public void sessionSaveOrPersistObject(){}
}
