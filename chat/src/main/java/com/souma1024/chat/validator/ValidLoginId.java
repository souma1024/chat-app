    package com.souma1024.chat.validator;

    import jakarta.validation.Constraint;
    import jakarta.validation.Payload;

    import java.lang.annotation.ElementType;
    import java.lang.annotation.Retention;
    import java.lang.annotation.RetentionPolicy;
    import java.lang.annotation.Target;


    @Constraint(validatedBy = { LoginIdValidator.class })
    @Target({ElementType.FIELD}) //注釈型が適用可能なプログラム要素
    @Retention(RetentionPolicy.RUNTIME) //アノテーションの読み込みタイミング
    public @interface ValidLoginId {
        String message() default "そのユーザーIDは既に使用されています";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
