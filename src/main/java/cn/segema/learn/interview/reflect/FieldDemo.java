package cn.segema.learn.interview.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldDemo {
    public static void main(String[] args) {
        Class c = Cat.class;
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            StringBuilder builder = new StringBuilder();
            // 获取名称
            builder.append("filed name = ");
            builder.append(f.getName());
            // 获取类型
            builder.append(" type = ");
            builder.append(f.getType());
            // 获取修饰符
            builder.append(" modifiers = ");
            builder.append(Modifier.toString(f.getModifiers()));
            // 获取注解
            Annotation[] ann = f.getAnnotations();
            if (ann.length != 0) {
                builder.append(" annotations = ");
                for (Annotation a : ann) {
                    builder.append(a.toString());
                    builder.append(" ");
                }
            } else {
                builder.append("  -- No Annotations --");
            }
            System.out.println(builder.toString());
        }
    }

}
