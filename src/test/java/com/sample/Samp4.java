package com.sample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

public class Samp4 implements IAnnotationTransformer {

@Override
public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	Class<? extends IRetryAnalyzer> retryAnalyzer = annotation.getRetryAnalyzerClass();
	if(retryAnalyzer==null) {
		annotation.setRetryAnalyzer(Samp5.class);
	}
}
}
