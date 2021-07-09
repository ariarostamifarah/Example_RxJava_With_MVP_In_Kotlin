package com.example.rxjava_with_mvp_in_kotlin.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by aria rostami farah on 7/5/21
 */



@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
